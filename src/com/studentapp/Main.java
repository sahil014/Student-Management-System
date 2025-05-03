package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	private static List<Student> studentList=new ArrayList<Student>();
	private static Scanner scannerobj;
	public static void main(String[] args) {
		
		System.out.println("******* Student Management System ********");
		while(true) {
		System.out.println("*************** WELCOME ****************");
		System.out.println("Select an option..");
		System.out.println("1.Register a student");
		System.out.println("2.Find a student with studentid");
		System.out.println("3.List all student information");
		System.out.println("4.List all student information in sorted order");
		System.out.println("5.Exit");
		
		scannerobj=new Scanner(System.in);
		int option=scannerobj.nextInt();
		switch(option) {
		    
		case 1:
			enrollStudent(scannerobj);
			break;
			
		case 2:	
			findStudentById(scannerobj);
			break;
			
		case 3:
			printAllStudentData();
			break;	
			
		case 4:	
			sortByName();
			break;
			
		case 5:	
			exit();
			break;
			
		default:	
			System.out.println("Invalid values...Enter value between 1 to 5");
		}
		
		
		}		
			
			
	   
	}

	  private static void exit() {
		System.exit(0);
		
	}

	private static void printAllStudentData() {
		
	  if(studentList.size()>0) {
		for(Student student:studentList) {
			System.out.println("------------------Printing Student Info.------------------");
			student.printStudentInfo();
			System.out.println("**********************************************************");
		}
	}
	  else {
		  System.err.println("Student list is empty.... No record found.");
	  }
   }
	private static void findStudentById(Scanner scannerobj2) {
		
		
		  Student studentresult=null;
		  System.out.println("Enter studentid to find...");
		  String studentId=scannerobj2.next();
		  try {
		  studentresult= studentList.stream().filter(x ->x.getStudentId().equalsIgnoreCase(studentId))
		  .findFirst()
		  .orElseThrow(() -> new RuntimeException("No data found !!!"));
		  }
		  catch(RuntimeException e) {
			  System.err.println("Student with id "+studentId+" not found");
		  }
		  
		  studentresult.printStudentInfo();  
		
	}

	private static void enrollStudent(Scanner scannerobj2) {
		
		System.out.println("Enter the student name");
		String name=scannerobj2.next();
		
		System.out.println("Enter the student age");
		int age=scannerobj2.nextInt();
		
		System.out.println("Enter the studentId");
		String stundentId=scannerobj2.next();
		
		Student  newStudent=new Student(name, age, stundentId);
		studentList.add(newStudent);
		
		while(true) {
		System.out.println("Enter the course to be enrolled... or type DONE to exit");
		String courseName=scannerobj2.next();
		if(courseName.equalsIgnoreCase("DONE")) {
			break;
		}
		newStudent.enrollCourse(courseName);
		
		}	
		newStudent.printStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator=new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
				
			}
			
		};
		
		Collections.sort(studentList,studentNameComparator);
		printAllStudentData();
	}

	public static Student findStudentById(String studentId) {
		  
		  Student result=null;
		  try {
		  result= studentList.stream().filter(x ->x.getStudentId().equalsIgnoreCase(studentId))
		  .findFirst()
		  .orElseThrow(() -> new RuntimeException("No data found !!!"));
		  }
		  catch(RuntimeException e) {
			  System.err.println("Student with id "+studentId+" not found");
		  }
		  return result; 
	  }
}
