package com.mainapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DAO.DAO;
import com.models.Student;

public class GPA {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String key;
		do {
			System.out.println();
			System.out.println("Grade Analysis App");
			System.out.println();
			System.out.println("0-To exit");
			System.out.println("1-Create Course");
			System.out.println("2-Enter student's average grades");
			System.out.println("3-Show course's average grade");
			System.out.println("4-Show course's minimum and maximum grades");

			Scanner scanner=new Scanner(System.in);
			key=scanner.next();
			DAO dao=new DAO();
			switch (key) {
			case "1":
				dao.createCourse();
				break;
			case "2":
				dao.createGrades();
				break;
			case "3":
				dao.averageGrade();
				break;
			case "4":
				dao.minAndmax();
			default:
				break;
			}
		} while (!key.equals("0"));
		System.out.println("Terminated");
	} 



}
