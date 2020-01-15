package com.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.models.Student;

public class DAO {
	public void createCourse() throws IOException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the course name");
		String courseName=scanner.next();
		String filepath="C:\\Users\\perscholas_student\\Desktop\\"+courseName+".csv";
		File file=new File(filepath);
		file.createNewFile();
		System.out.println("How many students you awant to add?");
		int noOfStd=scanner.nextInt();
		List<Student> students=new ArrayList<Student>();
		System.out.println("Add student");
		for (int i = 0; i <noOfStd; i++) {
			Student student=new Student();
			System.out.println("Enter id");
			student.setId(scanner.next());
			System.out.println("Enter name");
			scanner.nextLine();
			scanner.hasNextLine();
			student.setName(scanner.nextLine());
			System.out.println("Enter email");
			student.setEmail(scanner.nextLine());
			students.add(student);
		}
		File file2=new File(file.getPath());
		FileWriter fileWriter=new FileWriter(file2,true);
		for (Student student : students) {
			fileWriter.write(String.format("%s,%s,%s\n",student.getId(),student.getName(),student.getEmail()));
		}
		fileWriter.flush();
		fileWriter.close();
	}
	public void createGrades() throws IOException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the course name");
		String courseName=scanner.next();
		String filepath="C:\\Users\\perscholas_student\\Desktop\\"+courseName+".csv";
		File file=new File(filepath);
		if (file.exists()) {
			Scanner scannerf=new Scanner(file);
			List<Student> students=new ArrayList<Student>();
			while (scannerf.hasNextLine()) {
				String[] info=scannerf.nextLine().split(",");
				Student student=new Student();
				student.setId(info[0]);
				student.setName(info[1]);
				student.setEmail(info[2]);
				students.add(student);
			}
			System.out.println("Enter an id of student");
			String id=scanner.next();
			for (Student student : students) {
				if (student.getId().equals(id)) {
					System.out.println("Enter score");
					String score=scanner.next();
					File gradFile=new File("C:\\Users\\perscholas_student\\Desktop\\"+courseName+"Grades.csv");
					gradFile.createNewFile();
					FileWriter fileWriter=new FileWriter(gradFile,true);
					fileWriter.write(String.format("%s,%s,%s,%s\n",student.getId(),student.getName(),student.getEmail(),score));
					fileWriter.flush();
					fileWriter.close();
					return;
				}
				
			}
			System.out.println("Student does not exist with this id");
		}
		else {
			System.out.println("File does not exist");
		}
		
	}
	public void averageGrade() throws FileNotFoundException {

		Scanner scanner=new Scanner(System.in);
		List<Integer> grades=new ArrayList<Integer>();
		System.out.println("Enter the course name");
		String courseName=scanner.next();
		String filepath="C:\\Users\\perscholas_student\\Desktop\\"+courseName+"Grades.csv";
		File file=new File(filepath);
		if (file.exists()) {
			Scanner scannerf=new Scanner(file);
			while (scannerf.hasNextLine()) {
				String[] line=scannerf.nextLine().split(",");
				grades.add(Integer.parseInt(line[3]));
			}
			int averageGrade=0;
			int sum=0;
			List<Integer> belowAverage=new ArrayList<Integer>();
			List<Integer> aboveAverage=new ArrayList<Integer>();
			for (Integer integer : grades) {
				sum=sum+integer;
			}
			averageGrade=sum/grades.size();
			for (Integer integer : grades) {
				if (integer<averageGrade) {
					belowAverage.add(integer);
				}
				else {
					aboveAverage.add(integer);
				}
			}
			System.out.println("Average Grade = "+averageGrade);
			System.out.println("Students below average = "+belowAverage.size());
			System.out.println("Students above average = "+aboveAverage.size());
		}
		else {
			System.out.println("File does not exist");
		}
	}
	public void minAndmax() throws FileNotFoundException {
		Scanner scanner=new Scanner(System.in);
		List<Integer> grades=new ArrayList<Integer>();
		System.out.println("Enter the course name");
		String courseName=scanner.next();
		String filepath="C:\\Users\\perscholas_student\\Desktop\\"+courseName+"Grades.csv";
		File file=new File(filepath);
		if (file.exists()) {
			Scanner scannerf=new Scanner(file);
			while (scannerf.hasNextLine()) {
				String[] line=scannerf.nextLine().split(",");
				grades.add(Integer.parseInt(line[3]));
			}
			System.out.println("Minimum grade is "+Collections.min(grades));
			System.out.println("Maximum grade is "+Collections.max(grades));
		}
		else {
			System.out.println("File does not exist");
		}
	}
}
