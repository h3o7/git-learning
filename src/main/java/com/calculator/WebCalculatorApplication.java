package com.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Web计算器应用主类
 * 
 * @author h3o7
 * @version 1.0.0
 */
@SpringBootApplication
public class WebCalculatorApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WebCalculatorApplication.class, args);
        System.out.println("\n=================================");
        System.out.println("🌐 Web计算器已启动！");
        System.out.println("📱 访问地址: http://localhost:8080");
        System.out.println("=================================\n");
    }
}
