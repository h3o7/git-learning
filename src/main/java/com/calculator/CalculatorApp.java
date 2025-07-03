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
        System.out.println("12. 运行测试程序");
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
            case 12: CalculatorTest.main(new String[]{}); break;
            default: System.out.println("无效的选择！"); break;
        }
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
