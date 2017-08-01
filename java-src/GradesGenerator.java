import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class GradesGenerator {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("grades.sql")); //PrintWriter to write to the file w/
        String output = "create table grades (student_id int not null, course_id int not null, lt_one int, lt_two int, lt_three int, lt_four int);"; //initial MySQL statement to create the table
        for (int i = 0; i < 1000; i++) { //looping through all the students
            int student_id = 100000 + 287 * (i + 1); //aligns with the generation of student IDs
            ArrayList<Integer> possibleCourses = new ArrayList<Integer>();
            for (int j = 0; j < 16; j++) { //populating the ArrayList w/ all the initial possible course IDs
                possibleCourses.add(j + 1);
            }
            for (int j = 0; j < 7; j++) { //7 classes per student
                int[] lt = new int[4]; //the learning target grades
                int randomIndex = new Random().nextInt(possibleCourses.size()); //a random index of the possible courses
                int course_id = possibleCourses.get(randomIndex); //get the actual value of it
                possibleCourses.remove(randomIndex); //remove that index from the ArrayList
                //50% chance of a 3, 20% chance of a 4, 20% chance of a 2, 10% chance of a 1
                for (int k = 0; k < lt.length; k++) {
                    double random = Math.random();
                    if (random < .5) {
                        lt[k] = 3;
                    }
                    else if (random < .7) {
                        lt[k] = 4;
                    }
                    else if (random < .9) {
                        lt[k] = 2;
                    }
                    else {
                        lt[k] = 1;
                    }
                }
                output += "\ninsert into grades (student_id, course_id, lt_one, lt_two, lt_three, lt_four) values (" + student_id + ", " + course_id + ", " + lt[0] + ", " + lt[1] + ", " + lt[2] + ", " + lt[3] + ");"; //an insert statement to add a new record for a class
            }
        }
        pw.print(output); //printing to the file
        pw.close();
    }

}