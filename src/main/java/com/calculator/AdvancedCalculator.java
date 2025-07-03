package com.calculator;

/**
 * 高级数学运算计算器
 * 提供幂运算、对数、三角函数等高级运算功能
 * 
 * @author h3o7
 * @version 1.0.0
 */
public class AdvancedCalculator {
    
    /**
     * 幂运算
     * @param base 底数
     * @param exponent 指数
     * @return base的exponent次方
     */
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    /**
     * 平方根运算
     * @param number 被开方数
     * @return 平方根结果
     * @throws IllegalArgumentException 当输入负数时抛出异常
     */
    public static double squareRoot(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("负数无法计算平方根");
        }
        return Math.sqrt(number);
    }
    
    /**
     * 立方根运算
     * @param number 被开方数
     * @return 立方根结果
     */
    public static double cubeRoot(double number) {
        return Math.cbrt(number);
    }
    
    /**
     * 自然对数运算
     * @param number 真数
     * @return 自然对数结果
     * @throws IllegalArgumentException 当输入小于等于0的数时抛出异常
     */
    public static double naturalLogarithm(double number) throws IllegalArgumentException {
        if (number <= 0) {
            throw new IllegalArgumentException("对数的真数必须大于0");
        }
        return Math.log(number);
    }
    
    /**
     * 常用对数运算（以10为底）
     * @param number 真数
     * @return 常用对数结果
     * @throws IllegalArgumentException 当输入小于等于0的数时抛出异常
     */
    public static double commonLogarithm(double number) throws IllegalArgumentException {
        if (number <= 0) {
            throw new IllegalArgumentException("对数的真数必须大于0");
        }
        return Math.log10(number);
    }
    
    /**
     * 任意底数对数运算
     * @param number 真数
     * @param base 底数
     * @return 对数结果
     * @throws IllegalArgumentException 当真数或底数不符合要求时抛出异常
     */
    public static double logarithm(double number, double base) throws IllegalArgumentException {
        if (number <= 0) {
            throw new IllegalArgumentException("对数的真数必须大于0");
        }
        if (base <= 0 || base == 1) {
            throw new IllegalArgumentException("对数的底数必须大于0且不等于1");
        }
        return Math.log(number) / Math.log(base);
    }
    
    /**
     * 阶乘运算
     * @param n 非负整数
     * @return n的阶乘
     * @throws IllegalArgumentException 当输入负数时抛出异常
     */
    public static long factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("负数无法计算阶乘");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * 正弦函数
     * @param angleInRadians 弧度制角度
     * @return 正弦值
     */
    public static double sine(double angleInRadians) {
        return Math.sin(angleInRadians);
    }
    
    /**
     * 余弦函数
     * @param angleInRadians 弧度制角度
     * @return 余弦值
     */
    public static double cosine(double angleInRadians) {
        return Math.cos(angleInRadians);
    }
    
    /**
     * 正切函数
     * @param angleInRadians 弧度制角度
     * @return 正切值
     */
    public static double tangent(double angleInRadians) {
        return Math.tan(angleInRadians);
    }
    
    /**
     * 角度转弧度
     * @param degrees 角度
     * @return 弧度
     */
    public static double degreesToRadians(double degrees) {
        return Math.toRadians(degrees);
    }
    
    /**
     * 弧度转角度
     * @param radians 弧度
     * @return 角度
     */
    public static double radiansToDegrees(double radians) {
        return Math.toDegrees(radians);
    }
}
