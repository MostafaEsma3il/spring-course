package com.mostafaesmail.cruddemo;

import com.mostafaesmail.cruddemo.dao.StudentDAO;
import com.mostafaesmail.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
			return runner -> {
//				createStudent(studentDAO);
//				createMultipleStudent(studentDAO);
//				readStudent(studentDAO);

//				queryForStudents(studentDAO);

//				queryForStudentsByLastName(studentDAO);
//				updateStudent(studentDAO);

//				deleteStudent(studentDAO);

				deleteAllStudents(studentDAO);
			};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");

		int x = studentDAO.deleteAll();

		System.out.println("Number of deleted rows: " + x);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;

		System.out.println("Deleting student with id = " + id);

		// delete the student
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;

		// getting the student we want to update
		Student x = studentDAO.findById(id);


		// updating the student's first name
		x.setFirstName("Malek");

		// updating the table
		studentDAO.update(x);

		// printing the student data
		System.out.println("The student now is: " + x);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> list = studentDAO.findByLastName("Mohsen");

		for (Student x: list) {
			System.out.println(x);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findAll();

		for (Student s: students) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// creating a new student
		Student x = new Student("Tamer", "Rageh", "rageh@gmail.com");

		// saving the student
		studentDAO.save(x);

		// printing the id of the newly created student
		System.out.println("Student saved with id: " + x.getId());

		// getting the newly created student by his id
		Student retStudent = studentDAO.findById(x.getId());

		// printing the student details
		System.out.println(retStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// creating multiple students
		Student tempStudent1 = new Student("Mohamed", "Mohsen", "mohsen1@gmail.com");
		Student tempStudent2 = new Student("Mahmoud", "Mohsen", "mohsen2@gmail.com");
		Student tempStudent3 = new Student("Hassan", "Mohsen", "mohsen3@gmail.com");

		// saving the students
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// return the ids of the last inserted students
		System.out.println("Student saved with id: " + tempStudent1.getId());
		System.out.println("Student saved with id: " + tempStudent2.getId());
		System.out.println("Student saved with id: " + tempStudent3.getId());
	}

	public void createStudent (StudentDAO studentDAO) {
		// create a new student object
		Student tempStudent = new Student("Ahmed", "Mohsen", "mohsen@gmail.com");

		// save the student
		studentDAO.save(tempStudent);
		// return the id of the last inserted student
		System.out.println("Student saved with id: " + tempStudent.getId());
	}
}
