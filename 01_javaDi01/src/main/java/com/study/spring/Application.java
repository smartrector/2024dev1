package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring.bean.Config;
import com.study.spring.bean.Member;
import com.study.spring.bean.Printer;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		
		
		Member member1 = (Member) context.getBean("member1");
		member1.print();
		
		Member member2 = (Member) context.getBean("han");
		member2.print();
		
		Member member3 = context.getBean("han",Member.class);
		member3.print();
		
		Printer printer = context.getBean("printerB",Printer.class);
		member1.setPrinter(printer);
		member1.print();
	}

}
