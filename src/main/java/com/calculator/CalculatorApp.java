package com.calculator;

import java.util.Scanner;

/**
 * 计算器应用程序主类
 * 提供命令行交互界面
 * 
 * @author h3o7
 * @version 1.0.0
 */
public class CalculatorApp {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("     欢迎使用Java科学计算器");
        System.out.println("=================================");
        
        while (true) {
            try {
                showMenu();
                int choice = getIntInput("请选择操作 (1-12, 0退出): ");
                
                if (choice == 0) {
                    System.out.println("感谢使用！再见！");
                    break;
                }
                
                handleOperation(choice);
                
            } catch (Exception e) {
                System.err.println("发生错误: " + e.getMessage());
            }
            
            System.out.println("\n" + "=".repeat(40) + "\n");
        }
        
        scanner.close();
    }
    
    private static void showMenu() {
        System.out.println("请选择运算类型:");
        System.out.println("1. 加法 (+)");
        System.out.println("2. 减法 (-)");
        System.out.println("3. 乘法 (*)");
        System.out.println("4. 除法 (/)");
        System.out.println("5. 取模 (%)");
        System.out.println("6. 幂运算 (^)");
        System.out.println("7. 平方根 (√)");
        System.out.println("8. 立方根 (∛)");
        System.out.println("9. 对数运算");
        System.out.println("10. 阶乘 (!)");
        System.out.println("11. 三角函数");
        System.out.println("12. 运行内置测试");
        System.out.println("0. 退出程序");
    }
    
    private static void handleOperation(int choice) {
        switch (choice) {
            case 1: performBinaryOperation(OperationType.ADD); break;
            case 2: performBinaryOperation(OperationType.SUBTRACT); break;
            case 3: performBinaryOperation(OperationType.MULTIPLY); break;
            case 4: performBinaryOperation(OperationType.DIVIDE); break;
            case 5: performBinaryOperation(OperationType.MODULO); break;
            case 6: performBinaryOperation(OperationType.POWER); break;
            case 7: performUnaryOperation(OperationType.SQUARE_ROOT); break;
            case 8: performUnaryOperation(OperationType.CUBE_ROOT); break;
            case 9: handleLogarithm(); break;
            case 10: handleFactorial(); break;
            case 11: handleTrigonometry(); break;
            case 12: runBuiltInTests(); break;
            default: System.out.println("无效的选择！"); break;
        }
    }
    
    /**
     * 运行内置测试程序
     */
    private static void runBuiltInTests() {
        System.out.println("=== Java 计算器内置测试程序 ===\n");
        
        testBasicOperations();
        testAdvancedOperations();
        testTriangleFunctions();
        testErrorHandling();
        
        System.out.println("所有测试完成！");
    }
    
    /**
     * 测试基础运算
     */
    private static void testBasicOperations() {
        System.out.println("=== 基础运算测试 ===");
        
        try {
            System.out.printf("10 + 5 = %.2f%n", 
                CalculatorFactory.calculate(OperationType.ADD, 10, 5));
            System.out.printf("10 - 5 = %.2f%n", 
                CalculatorFactory.calculate(OperationType.SUBTRACT, 10, 5));
            System.out.printf("10 * 5 = %.2f%n", 
                CalculatorFactory.calculate(OperationType.MULTIPLY, 10, 5));
            System.out.printf("10 / 5 = %.2f%n", 
                CalculatorFactory.calculate(OperationType.DIVIDE, 10, 5));
            System.out.printf("10 %% 3 = %.2f%n", 
                CalculatorFactory.calculate(OperationType.MODULO, 10, 3));
        } catch (Exception e) {
            System.err.println("基础运算测试出错: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 测试高级运算
     */
    private static void testAdvancedOperations() {
        System.out.println("=== 高级运算测试 ===");
        
        try {
            System.out.printf("2^8 = %.2f%n", 
                CalculatorFactory.calculate(OperationType.POWER, 2, 8));
            System.out.printf("√16 = %.2f%n", 
                CalculatorFactory.calculate(OperationType.SQUARE_ROOT, 16));
            System.out.printf("∛27 = %.2f%n", 
                CalculatorFactory.calculate(OperationType.CUBE_ROOT, 27));
            System.out.printf("ln(e) = %.6f%n", 
                CalculatorFactory.calculate(OperationType.NATURAL_LOG, Math.E));
            System.out.printf("log(100) = %.2f%n", 
                CalculatorFactory.calculate(OperationType.COMMON_LOG, 100));
            System.out.printf("5! = %d%n", 
                CalculatorFactory.calculateFactorial(5));
        } catch (Exception e) {
            System.err.println("高级运算测试出错: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 测试三角函数
     */
    private static void testTriangleFunctions() {
        System.out.println("=== 三角函数测试 ===");
        
        try {
            double angle90 = AdvancedCalculator.degreesToRadians(90);
            double angle45 = AdvancedCalculator.degreesToRadians(45);
            
            System.out.printf("sin(90°) = %.6f%n", 
                CalculatorFactory.calculate(OperationType.SINE, angle90));
            System.out.printf("cos(90°) = %.6f%n", 
                CalculatorFactory.calculate(OperationType.COSINE, angle90));
            System.out.printf("tan(45°) = %.6f%n", 
                CalculatorFactory.calculate(OperationType.TANGENT, angle45));
        } catch (Exception e) {
            System.err.println("三角函数测试出错: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * 测试错误处理
     */
    private static void testErrorHandling() {
        System.out.println("=== 错误处理测试 ===");
        
        // 测试除零错误
        try {
            CalculatorFactory.calculate(OperationType.DIVIDE, 10, 0);
        } catch (ArithmeticException e) {
            System.out.println("✓ 正确捕获除零错误: " + e.getMessage());
        }
        
        // 测试负数开平方根错误
        try {
            CalculatorFactory.calculate(OperationType.SQUARE_ROOT, -4);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ 正确捕获负数开方错误: " + e.getMessage());
        }
        
        // 测试负数阶乘错误
        try {
            CalculatorFactory.calculateFactorial(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ 正确捕获负数阶乘错误: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void performBinaryOperation(OperationType type) {
        double a = getDoubleInput("请输入第一个数: ");
        double b = getDoubleInput("请输入第二个数: ");
        
        try {
            double result = CalculatorFactory.calculate(type, a, b);
            System.out.printf("结果: %.6f %s %.6f = %.6f%n", a, type.getSymbol(), b, result);
        } catch (Exception e) {
            System.err.println("计算错误: " + e.getMessage());
        }
    }
    
    private static void performUnaryOperation(OperationType type) {
        double a = getDoubleInput("请输入数值: ");
        
        try {
            double result = CalculatorFactory.calculate(type, a);
            System.out.printf("结果: %s(%.6f) = %.6f%n", type.getSymbol(), a, result);
        } catch (Exception e) {
            System.err.println("计算错误: " + e.getMessage());
        }
    }
    
    private static void handleLogarithm() {
        System.out.println("选择对数类型:");
        System.out.println("1. 自然对数 (ln)");
        System.out.println("2. 常用对数 (log10)");
        System.out.println("3. 任意底对数");
        
        int choice = getIntInput("请选择: ");
        double number = getDoubleInput("请输入真数: ");
        
        try {
            double result;
            switch (choice) {
                case 1:
                    result = CalculatorFactory.calculate(OperationType.NATURAL_LOG, number);
                    System.out.printf("结果: ln(%.6f) = %.6f%n", number, result);
                    break;
                case 2:
                    result = CalculatorFactory.calculate(OperationType.COMMON_LOG, number);
                    System.out.printf("结果: log(%.6f) = %.6f%n", number, result);
                    break;
                case 3:
                    double base = getDoubleInput("请输入底数: ");
                    result = AdvancedCalculator.logarithm(number, base);
                    System.out.printf("结果: log_%f(%.6f) = %.6f%n", base, number, result);
                    break;
                default:
                    System.out.println("无效的选择！");
            }
        } catch (Exception e) {
            System.err.println("计算错误: " + e.getMessage());
        }
    }
    
    private static void handleFactorial() {
        int n = getIntInput("请输入非负整数: ");
        
        try {
            long result = CalculatorFactory.calculateFactorial(n);
            System.out.printf("结果: %d! = %d%n", n, result);
        } catch (Exception e) {
            System.err.println("计算错误: " + e.getMessage());
        }
    }
    
    private static void handleTrigonometry() {
        System.out.println("选择三角函数:");
        System.out.println("1. 正弦 (sin)");
        System.out.println("2. 余弦 (cos)");
        System.out.println("3. 正切 (tan)");
        
        int choice = getIntInput("请选择: ");
        System.out.println("角度输入方式:");
        System.out.println("1. 度数");
        System.out.println("2. 弧度");
        
        int angleType = getIntInput("请选择: ");
        double angle = getDoubleInput("请输入角度值: ");
        
        if (angleType == 1) {
            angle = AdvancedCalculator.degreesToRadians(angle);
        }
        
        try {
            double result;
            OperationType type;
            String funcName;
            
            switch (choice) {
                case 1: type = OperationType.SINE; funcName = "sin"; break;
                case 2: type = OperationType.COSINE; funcName = "cos"; break;
                case 3: type = OperationType.TANGENT; funcName = "tan"; break;
                default: 
                    System.out.println("无效的选择！");
                    return;
            }
            
            result = CalculatorFactory.calculate(type, angle);
            System.out.printf("结果: %s(%.6f) = %.6f%n", funcName, angle, result);
        } catch (Exception e) {
            System.err.println("计算错误: " + e.getMessage());
        }
    }
    
    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("请输入有效的数字: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("请输入有效的整数: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
