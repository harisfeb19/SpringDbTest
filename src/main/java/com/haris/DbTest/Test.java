package com.haris.DbTest;
 
import java.util.List;  

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		 EmployeeDao dao = context.getBean("edao",EmployeeDao.class);
		   
		/*
		 * int status = dao.saveEmployee(new Employee(102,"Anas",35000));
		 * 
		 * System.out.println(status);
		 */
		
		 List<Employee> list = dao.getAllEmployees();
		 
		for(Employee e:list) {
			System.out.println(e);
		}
	}
}
