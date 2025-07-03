#!/bin/bash

echo "=== 运行Java计算器 ==="

# 检查是否已编译
if [ ! -d "target/classes" ]; then
    echo "项目尚未编译，正在编译..."
    ./compile.sh
fi

# 运行主程序
java -cp target/classes com.calculator.CalculatorApp
