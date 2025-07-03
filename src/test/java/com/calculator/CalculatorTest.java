package com.calculator;

/**
 * 计算器功能测试类
 * 测试基础和高级计算功能
 * 
 * @author h3o7
 * @version 1.0.0
 */
public class CalculatorTest {
    
    public static void main(String[] args) {
        System.out.println("=== Java 计算器测试程序 ===\n");
        
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
}
