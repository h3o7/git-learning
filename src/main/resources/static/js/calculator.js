let currentInput = '';
let currentOperation = null;
let firstOperand = null;
let waitingForOperand = false;
let history = [];

// 更新显示
function updateDisplay() {
    const display = document.getElementById('display');
    const operationDisplay = document.getElementById('operation-display');
    
    display.value = currentInput || '0';
    
    if (currentOperation && firstOperand !== null) {
        operationDisplay.textContent = `${firstOperand} ${getOperationSymbol(currentOperation)}`;
    } else {
        operationDisplay.textContent = '';
    }
}

// 获取运算符号
function getOperationSymbol(operation) {
    const symbols = {
        'add': '+',
        'subtract': '-',
        'multiply': '×',
        'divide': '÷',
        'power': '^',
        'sqrt': '√',
        'sin': 'sin',
        'cos': 'cos',
        'tan': 'tan'
    };
    return symbols[operation] || operation;
}

// 添加数字
function appendNumber(number) {
    if (waitingForOperand) {
        currentInput = number;
        waitingForOperand = false;
    } else {
        currentInput = currentInput === '0' ? number : currentInput + number;
    }
    updateDisplay();
}

// 设置运算
function setOperation(operation) {
    if (firstOperand === null) {
        firstOperand = parseFloat(currentInput) || 0;
    } else if (currentOperation) {
        const result = performCalculation();
        if (result !== null) {
            currentInput = result.toString();
            firstOperand = result;
        }
    }
    
    // 对于单操作数函数，立即计算
    if (['sqrt', 'sin', 'cos', 'tan'].includes(operation)) {
        performSingleOperandCalculation(operation);
        return;
    }
    
    waitingForOperand = true;
    currentOperation = operation;
    updateDisplay();
}

// 执行单操作数计算
async function performSingleOperandCalculation(operation) {
    const value = parseFloat(currentInput) || 0;
    
    try {
        const response = await fetch('/calculate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                operation: operation,
                a: value,
                b: 0
            }),
        });
        
        const result = await response.json();
        
        if (result.success) {
            const historyItem = `${getOperationSymbol(operation)}(${value}) = ${result.result}`;
            addToHistory(historyItem, false);
            
            currentInput = result.result.toString();
            firstOperand = null;
            currentOperation = null;
            waitingForOperand = true;
        } else {
            addToHistory(`${getOperationSymbol(operation)}(${value}) = Error: ${result.error}`, true);
            currentInput = 'Error';
        }
    } catch (error) {
        addToHistory(`${getOperationSymbol(operation)}(${value}) = Error: ${error.message}`, true);
        currentInput = 'Error';
    }
    
    updateDisplay();
}

// 计算结果
async function calculate() {
    if (currentOperation && firstOperand !== null && !waitingForOperand) {
        const result = await performCalculation();
        if (result !== null) {
            currentInput = result.toString();
            firstOperand = null;
            currentOperation = null;
            waitingForOperand = true;
            updateDisplay();
        }
    }
}

// 执行计算
async function performCalculation() {
    const prev = firstOperand;
    const current = parseFloat(currentInput) || 0;
    
    if (currentOperation === null || prev === null) {
        return null;
    }
    
    try {
        const response = await fetch('/calculate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                operation: currentOperation,
                a: prev,
                b: current
            }),
        });
        
        const result = await response.json();
        
        if (result.success) {
            const historyItem = `${prev} ${getOperationSymbol(currentOperation)} ${current} = ${result.result}`;
            addToHistory(historyItem, false);
            return result.result;
        } else {
            const historyItem = `${prev} ${getOperationSymbol(currentOperation)} ${current} = Error: ${result.error}`;
            addToHistory(historyItem, true);
            currentInput = 'Error';
            return null;
        }
    } catch (error) {
        const historyItem = `${prev} ${getOperationSymbol(currentOperation)} ${current} = Error: ${error.message}`;
        addToHistory(historyItem, true);
        currentInput = 'Error';
        return null;
    }
}

// 清除所有
function clearAll() {
    currentInput = '';
    currentOperation = null;
    firstOperand = null;
    waitingForOperand = false;
    updateDisplay();
}

// 删除最后一个字符
function deleteLast() {
    currentInput = currentInput.slice(0, -1);
    updateDisplay();
}

// 添加到历史记录
function addToHistory(item, isError) {
    history.unshift({text: item, isError: isError});
    if (history.length > 10) {
        history.pop(); // 只保留最近10条记录
    }
    updateHistoryDisplay();
}

// 更新历史记录显示
function updateHistoryDisplay() {
    const historyList = document.getElementById('history-list');
    historyList.innerHTML = '';
    
    history.forEach(item => {
        const div = document.createElement('div');
        div.className = `history-item ${item.isError ? 'error' : ''}`;
        div.textContent = item.text;
        historyList.appendChild(div);
    });
}

// 键盘支持
document.addEventListener('keydown', function(event) {
    const key = event.key;
    
    if (key >= '0' && key <= '9' || key === '.') {
        appendNumber(key);
    } else if (key === '+') {
        setOperation('add');
    } else if (key === '-') {
        setOperation('subtract');
    } else if (key === '*') {
        setOperation('multiply');
    } else if (key === '/') {
        event.preventDefault();
        setOperation('divide');
    } else if (key === 'Enter' || key === '=') {
        event.preventDefault();
        calculate();
    } else if (key === 'Escape' || key === 'c' || key === 'C') {
        clearAll();
    } else if (key === 'Backspace') {
        deleteLast();
    }
});

// 初始化显示
updateDisplay();
