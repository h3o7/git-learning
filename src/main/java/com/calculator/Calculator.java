package com.calculator;

/**
 * 简化版计算器类 - 专为Web接口设计
 * 
 * @author h3o7
 * @version 1.0.0
 */
public class Calculator {
    
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a / b;
    }
    
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    public static double sqrt(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("负数无法计算平方根");
        }
        return Math.sqrt(number);
    }
    
    public static double sin(double angleInDegrees) {
        return Math.sin(Math.toRadians(angleInDegrees));
    }
    
    public static double cos(double angleInDegrees) {
        return Math.cos(Math.toRadians(angleInDegrees));
    }
    
    public static double tan(double angleInDegrees) {
        return Math.tan(Math.toRadians(angleInDegrees));
    }
}
