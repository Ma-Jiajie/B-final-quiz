package com.example.demo;

// TODO GTB-工程实践: - 及时清理无用的import
//import com.sun.tools.jdeprscan.scan.Scan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
// TODO GTB-知识点: - @ComponentScan可以省略
@ComponentScan({"com.*"})
public class FinalQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalQuizApplication.class, args);
	}

}

// TODO GTB-测试: * 没有任何测试
// TODO GTB-完成度: * 完成了大部分功能，没有实现查询分组的接口
// TODO GTB-知识点: * 掌握了常用Spring MVC和IoC注解的使用，API设计符合Restful风格
// TODO GTB-知识点: * 合理的处理了各类异常
// TODO GTB-知识点: * 没有掌握和理解JPA相关的注解
// TODO GTB-工程实践: * 能够合理使用三层架构，分包合理