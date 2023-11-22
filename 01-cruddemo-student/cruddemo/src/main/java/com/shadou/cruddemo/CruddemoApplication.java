package com.shadou.cruddemo;

import com.shadou.cruddemo.dao.StudentDAO;
import com.shadou.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			// createStudent(studentDao);
			createMultipleStudents(studentDao);
			// readStudent(studentDao);
			// queryForStudents(studentDao);
			// queryForStudentsByLastName(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDAO studentDao) {
		System.out.println("Deleting all students ...");
		int numRowsDeleted = studentDao.deleteAll();
		System.out.println("Number of deleted students: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDao) {
		int theId = 3;
		System.out.println("Deleting student id: " + theId);
		studentDao.delete(theId);
	}

	private void updateStudent(StudentDAO studentDao) {

		// retrieve student based on the id: primary key
		int theId = 1;
		System.out.println("Getting student with id: " + theId);
		Student theStudent = studentDao.findById(theId);

		// change first name to "John"
		System.out.println("Updating student ...");
		theStudent.setFirstName("John");

		// update the student
		studentDao.update(theStudent);

		// display the updated student
		System.out.println("Updated student: " + theStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDao) {

		// Get a list of students
		List<Student> students = studentDao.findByLastName("Duck");

		// Display the list of students
		for (Student student : students) {
			System.out.println(student);
		}

	}

	private void queryForStudents(StudentDAO studentDao) {

		// Get a list of students
		List<Student> students = studentDao.findAll();

		// Display the list of students
		for (Student student : students) {
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDao) {

		// Creating a student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// Save the students
		System.out.println("Saving the student ...");
		studentDao.save(student);

		// Display id of the saved student
		int theId = student.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// Retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		var myStudent = studentDao.findById(theId);

		// Display Student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDao) {

		// Create multiple students
		System.out.println("Creating 3 student objects ...");
		Student student1 = new Student("John", "Doe", "paul@luv2code.com");
		Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// Save the students
		System.out.println("Saving the student ...");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);

	}

	private void createStudent(StudentDAO studentDao) {

		// Create the student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Paul", "Doe", "paul@luv2code.com");

		// Save the student object
		System.out.println("Saving the student ...");
		studentDao.save(student);

		// Display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());

	}

}
