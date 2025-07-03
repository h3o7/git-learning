package com.calculator;

/**
 * 运算类型枚举
 * 定义所有支持的运算类型
 * 
 * @author h3o7
 * @version 1.0.0
 */
public enum OperationType {
    // 基础运算
    ADD("加法", "+"),
    SUBTRACT("减法", "-"),
    MULTIPLY("乘法", "*"),
    DIVIDE("除法", "/"),
    MODULO("取模", "%"),
    
    // 高级运算
    POWER("幂运算", "^"),
    SQUARE_ROOT("平方根", "√"),
    CUBE_ROOT("立方根", "∛"),
    NATURAL_LOG("自然对数", "ln"),
    COMMON_LOG("常用对数", "log"),
    FACTORIAL("阶乘", "!"),
    
    // 三角函数
    SINE("正弦", "sin"),
    COSINE("余弦", "cos"),
    TANGENT("正切", "tan");
    
    private final String description;
    private final String symbol;
    
    OperationType(String description, String symbol) {
        this.description = description;
        this.symbol = symbol;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString() {
        return symbol + " (" + description + ")";
    }
}
