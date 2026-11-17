package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		try {
			Student student = new Student();
			student.setName("김민수");
			student.setMajor("컴퓨터공학");
//			student.setGrade(3);
			student.setGrade(5);
			
			System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade());
			
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
