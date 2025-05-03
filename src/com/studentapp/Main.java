package com.studentapp;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("******* Student Management System ********");
		System.out.println("*************** WELCOME ****************");
		
		Student student1=new Student("Sahil Narang", 25, "S-1");
	
		
		student1.enrollCourse("Java");
		student1.enrollCourse("DsA");
		student1.enrollCourse("DEVOPS");
		student1.printStudentInfo();
		
		Student student2=new Student("Joe",30,"S-2");
		student2.enrollCourse("DSA");
		student2.printStudentInfo();
				
		Student student3=new Student("John", 27, "S-3");
		student3.enrollCourse("Devops");
		student3.printStudentInfo();
		
		
	}

}
