package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;
	
	
	public Student(String name, int age, String studentId) {
		super();
		if(validateAge(age) && vaildateName(name) && vaildateStudentId(studentId)) {
		this.name=name;
		this.age=age;
		this.studentId=studentId;
		courses= new ArrayList<String>();
		}
	}
	

	public void enrollCourse(String course) {
		
	 if(validateCourse(course)){
		if(!courses.contains(course)) {
			
			courses.add(course);
			System.out.println("Student enrolled for "+ course+" successfully");
		}
		else {
			
			System.err.println("Student alrealdy enrolled in the course "+course);		
		}
	 }	
				
	}
	
	public boolean validateCourse(String course) {
	 	
		if(course.equalsIgnoreCase("JAVA")|| course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DEVOPS")) {
		    return true;	
		}
		else {
			System.err.println("Invalid course ! Please select from Java, DSA, Devops");
			return false;
		}
			
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public List<String> getCourses() {
		return courses;
	}


	public void setCourses(List<String> courses) {
		this.courses = courses;
	}


	public void printStudentInfo() {
		
		System.out.println("*************************************************************");
		System.out.println("Name "+name + "\n"+"Age "+age+ "\n"+"Id "+studentId+"\n"+ "course "+courses);
		  	
	}
	
	@Override
	public String toString() {
		return "Student[name=" +name + " Age "+age + " studentId "+ studentId+ " courses "+courses+"]";
				
	}
	
	//validating instance variables
	public Boolean validateAge(int age) {
		
		if(age>=19 && age<=35) {
			
			return true;
		}
		else {
			System.err.println("Inavlid age, age should be between 19 and 35");
			return false;
		}
	}
	
public Boolean vaildateName(String name) {
		
		String nameRegex="^[a-zA-Z\\s]+$";
		Pattern namePattern=Pattern.compile(nameRegex);	
		Matcher nameMatcher=namePattern.matcher(name);
		if(nameMatcher.matches()) {
			return true;
		}
		else {
			System.err.println("Inavlid name");
			return false;
		}
		
	}

private boolean vaildateStudentId(String studentId) {
	
	String studentIdRegex="S-\\d+$";
	Pattern studentIdPattern=Pattern.compile(studentIdRegex);
	Matcher studentIdMatcher=studentIdPattern.matcher(studentId);
	if(studentIdMatcher.matches()) {
		return true;
	}
	else {
		System.err.println("Invalid studentid");
	    return false;
	}
}



	
}
