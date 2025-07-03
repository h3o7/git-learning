package com.calculator;

/**
 * 基础数学运算计算器
 * 提供加减乘除等基本运算功能
 * 
 * @author h3o7
 * @version 1.0.0
 */
public class BasicCalculator {
    
    /**
     * 加法运算
     * @param a 第一个操作数
     * @param b 第二个操作数
     * @return 运算结果
     */
    public static double add(double a, double b) {
        return a + b;
    }
    
    /**
     * 减法运算
     * @param a 被减数
     * @param b 减数
     * @return 运算结果
     */
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    /**
     * 乘法运算
     * @param a 第一个操作数
     * @param b 第二个操作数
     * @return 运算结果
     */
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * 除法运算
     * @param a 被除数
     * @param b 除数
     * @return 运算结果
     * @throws ArithmeticException 当除数为零时抛出异常
     */
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a / b;
    }
    
    /**
     * 取模运算
     * @param a 被除数
     * @param b 除数
     * @return 余数
     * @throws ArithmeticException 当除数为零时抛出异常
     */
    public static double modulo(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a % b;
    }
}
