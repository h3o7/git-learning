package com.calculator.web;

import com.calculator.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Web计算器控制器
 * 
 * @author h3o7
 * @version 1.0.0
 */
@Controller
public class CalculatorController {
    
    @GetMapping("/")
    public String index() {
        return "calculator";
    }
    
    @PostMapping("/calculate")
    @ResponseBody
    public CalculationResult calculate(@RequestBody CalculationRequest request) {
        try {
            double result = performCalculation(request);
            return new CalculationResult(true, result, null);
        } catch (Exception e) {
            return new CalculationResult(false, 0, e.getMessage());
        }
    }
    
    private double performCalculation(CalculationRequest request) {
        String operation = request.getOperation();
        double a = request.getA();
        double b = request.getB();
        
        switch (operation.toLowerCase()) {
            case "add": return Calculator.add(a, b);
            case "subtract": return Calculator.subtract(a, b);
            case "multiply": return Calculator.multiply(a, b);
            case "divide": return Calculator.divide(a, b);
            case "power": return Calculator.power(a, b);
            case "sqrt": return Calculator.sqrt(a);
            case "sin": return Calculator.sin(a);
            case "cos": return Calculator.cos(a);
            case "tan": return Calculator.tan(a);
            default: throw new IllegalArgumentException("不支持的运算: " + operation);
        }
    }
    
    // 内部类：计算请求
    public static class CalculationRequest {
        private String operation;
        private double a;
        private double b;
        
        // Getters and Setters
        public String getOperation() { return operation; }
        public void setOperation(String operation) { this.operation = operation; }
        public double getA() { return a; }
        public void setA(double a) { this.a = a; }
        public double getB() { return b; }
        public void setB(double b) { this.b = b; }
    }
    
    // 内部类：计算结果
    public static class CalculationResult {
        private boolean success;
        private double result;
        private String error;
        
        public CalculationResult(boolean success, double result, String error) {
            this.success = success;
            this.result = result;
            this.error = error;
        }
        
        // Getters
        public boolean isSuccess() { return success; }
        public double getResult() { return result; }
        public String getError() { return error; }
    }
}
