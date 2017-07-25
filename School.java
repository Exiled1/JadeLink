import java.util.ArrayList;
import java.util.Scanner;

public class School {
	String name;
	
	public School() {
		
	}
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Class> classes = new ArrayList<Class>();
		students.add(new Student(100000,10,"Russell","Chai"));
		students.add(new Student(100001,10,"Justin","Yang"));
		for(int i=0;i<7;i++) {
			classes.add(new Class(10,i+1,"JAVA",i+1,true,false));
			classes.get(i).addStudent(students.get(0));
			classes.get(i).addStudent(students.get(1));
			classes.get(i).addTarget(new LearningTarget("Target 1",classes.get(0).num));
			classes.get(i).addAssignment(new Assignment("Homework",classes.get(0).num),0);
			classes.get(i).addGrade(100000, 92, "Homework");
			classes.get(i).addGrade(100001, 94, "Homework");
			classes.get(i).targets.get(0).average();
		}
		classes.add(new Class(10,8,"PE",8,false,true));
		classes.get(7).addStudent(students.get(0));
		classes.get(7).addStudent(students.get(1));
		classes.get(7).addTarget(new LearningTarget("Target 1",classes.get(0).num));
		classes.get(7).addAssignment(new Assignment("Homework",classes.get(0).num),0);
		classes.get(7).addGrade(100000, 2, "Homework");
		classes.get(7).addGrade(100001, 2, "Homework");
		classes.get(7).targets.get(0).average();
		for(int i=0;i<8;i++) {
			students.get(0).classgrade(i);
			students.get(1).classgrade(i);
		}
		students.get(0).update();
		students.get(1).update();
		System.out.println(students.get(0).gpa);
		System.out.println(students.get(1).gpa);
		/*Scanner in = new Scanner(System.in);
		while(true) {
			String[] input = in.nextLine().split(" ");
			if(input[0].equals("new")) {
				if(input[1].equals("student")) {
					students.add(new Student(Integer.parseInt(input[4]),Integer.parseInt(input[5]),input[2],input[3]));
				}
				if(input[1].equals("class")) {
					classes.add(new Class(Integer.parseInt(input[4]),Integer.parseInt(input[3]),input[2]));
				}
			}
			if(input[0].equals("list")) {
				if(input[1].equals("students")) {
					for(int i=0;i<students.size();i++) {
						System.out.println(students.get(i).toString());
					}
				}
			}
			if(input[0].equals("class")) {
				int tempid = Integer.parseInt(input[1]);
				int index = -1;
				for(int i=0;i<classes.size();i++) {
					if(classes.get(i).id == tempid) index = i;
				}
				
			}
		}*/
	}
}
