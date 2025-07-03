#!/bin/bash

echo "=== 运行测试程序 ==="

# 检查是否已编译
if [ ! -d "target/test-classes" ]; then
    echo "测试程序尚未编译，正在编译..."
    ./compile.sh
fi

# 运行测试
java -cp target/classes:target/test-classes com.calculator.CalculatorTest
