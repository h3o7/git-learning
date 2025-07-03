#!/bin/bash

echo "=== 编译Java计算器项目 ==="

# 创建输出目录
mkdir -p target/classes
mkdir -p target/test-classes

# 编译主程序
echo "编译主程序..."
javac -d target/classes src/main/java/com/calculator/*.java

if [ $? -eq 0 ]; then
    echo "✓ 主程序编译成功"
else
    echo "✗ 主程序编译失败"
    exit 1
fi

# 编译测试程序
echo "编译测试程序..."
javac -d target/test-classes -cp target/classes src/test/java/com/calculator/*.java

if [ $? -eq 0 ]; then
    echo "✓ 测试程序编译成功"
else
    echo "✗ 测试程序编译失败"
    exit 1
fi

echo "=== 编译完成 ==="
EOF

# 创建运行脚本
cat > run.sh << 'EOF'
#!/bin/bash

echo "=== 运行Java计算器 ==="

# 检查是否已编译
if [ ! -d "target/classes" ]; then
    echo "项目尚未编译，正在编译..."
    ./compile.sh
fi

# 运行主程序
java -cp target/classes com.calculator.CalculatorApp
