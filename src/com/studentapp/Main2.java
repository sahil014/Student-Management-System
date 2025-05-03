package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	
	public static List<Student> studentList=new ArrayList<>();
	public static void main(String[] args) {
		
		System.out.println("******* Student Management System ********");
		System.out.println("*************** WELCOME ****************");
		
	//	List<Student> studentList=new ArrayList<>();
		
		Student student1=new Student("Sahil Narang", 25, "S-1");
	
		student1.enrollCourse("Java");
		student1.enrollCourse("DsA");
		student1.enrollCourse("DEVOPS");
		student1.printStudentInfo();
		
		Student student2=new Student("Henry",30,"S-2");
		student2.enrollCourse("DSA");
		student2.printStudentInfo();
				
		Student student3=new Student("John", 27, "S-3");
		student3.enrollCourse("Devops");
		student3.printStudentInfo();
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		Student result=findStudentById("S-3");
		System.out.println(result);
		
		sortByName();
	}

	  private static void sortByName() {
		Comparator<Student> studentNameComparator=new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
				
			}
			
		};
		
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
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
