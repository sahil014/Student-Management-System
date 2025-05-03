package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	
	public static List<Student> studentList=new ArrayList<>();
	public static void main(String[] args) {
		
		System.out.println("******* Student Management System ********");
		System.out.println("*************** WELCOME ****************");
        	
		Scanner scannerobj=new Scanner(System.in);
		System.out.println("Enter Student Name...");
		String name=scannerobj.next();
		System.out.println("You have entered the name --"+ name);
		int age=scannerobj.nextInt();
		System.out.println("The Student age is--"+age);
  }		
}	