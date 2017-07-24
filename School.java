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
		classes.add(new Class(10,1,"JAVA",1,true,false));
		classes.get(0).addStudent(students.get(0));
		classes.get(0).addStudent(students.get(1));
		classes.get(0).addTarget(new LearningTarget("Target 1",classes.get(0).num));
		classes.get(0).addAssignment(new Assignment("Homework",classes.get(0).num),0);
		classes.get(0).addGrade(100000, 92, "Homework");
		classes.get(0).addGrade(100001, 94, "Homework");
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
