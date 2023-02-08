package com.techpalle;

import java.util.ArrayList;

public class MyProgram 
{
	public static void main(String[] args) 
	{
//		Student.creating();
		
//		Student.inserting("Bharat", "Java", "bharat@gmail.com");
//		Student.inserting("Aryan", "Java", "aryan@gmail.com");
		
//		Student.update(2, "SQL", "aryanK@gmail.com");
		
//		Student.delete(2);
	
//		Student.read();
		
		ArrayList<Object> arr=Student.reading();

		for(Object j: arr)
		{
			System.out.println(j);
		}
	}
}
