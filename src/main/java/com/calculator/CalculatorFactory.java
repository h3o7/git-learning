package com.calculator;

/**
 * 计算器工厂类
 * 提供统一的计算接口，封装基础和高级计算功能
 * 
 * @author h3o7
 * @version 1.0.0
 */
public class CalculatorFactory {
    
    /**
     * 执行双操作数运算
     * @param type 运算类型
     * @param a 第一个操作数
     * @param b 第二个操作数
     * @return 运算结果
     * @throws IllegalArgumentException 当运算类型不支持双操作数时
     * @throws ArithmeticException 当运算出现数学错误时
     */
    public static double calculate(OperationType type, double a, double b) 
            throws IllegalArgumentException, ArithmeticException {
        switch (type) {
            case ADD:
                return BasicCalculator.add(a, b);
            case SUBTRACT:
                return BasicCalculator.subtract(a, b);
            case MULTIPLY:
                return BasicCalculator.multiply(a, b);
            case DIVIDE:
                return BasicCalculator.divide(a, b);
            case MODULO:
                return BasicCalculator.modulo(a, b);
            case POWER:
                return AdvancedCalculator.power(a, b);
            default:
                throw new IllegalArgumentException("运算类型 " + type + " 不支持双操作数");
        }
    }
    
    /**
     * 执行单操作数运算
     * @param type 运算类型
     * @param a 操作数
     * @return 运算结果
     * @throws IllegalArgumentException 当运算类型不支持单操作数时
     * @throws ArithmeticException 当运算出现数学错误时
     */
    public static double calculate(OperationType type, double a) 
            throws IllegalArgumentException, ArithmeticException {
        switch (type) {
            case SQUARE_ROOT:
                return AdvancedCalculator.squareRoot(a);
            case CUBE_ROOT:
                return AdvancedCalculator.cubeRoot(a);
            case NATURAL_LOG:
                return AdvancedCalculator.naturalLogarithm(a);
            case COMMON_LOG:
                return AdvancedCalculator.commonLogarithm(a);
            case SINE:
                return AdvancedCalculator.sine(a);
            case COSINE:
                return AdvancedCalculator.cosine(a);
            case TANGENT:
                return AdvancedCalculator.tangent(a);
            default:
                throw new IllegalArgumentException("运算类型 " + type + " 不支持单操作数");
        }
    }
    
    /**
     * 计算阶乘（特殊方法，因为需要整数输入）
     * @param n 非负整数
     * @return n的阶乘
     */
    public static long calculateFactorial(int n) {
        return AdvancedCalculator.factorial(n);
    }
}
