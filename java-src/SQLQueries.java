import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class SQLQueries {

    MysqlDataSource mds; //the data source
    Connection conn; //the connection to the database

    final static int OVERVIEW = 0;
    final static int GRADES = 1;
    final static int COURSEHISTORY = 2;
    final static int HEALTH = 3;
    final static int STUDENTINFORMATION = 4;

    String queryString; //the String that contains the query itself

    public SQLQueries (int whichQuery, int student_id) { //constructor requires which query to run and which student it is
        mds = new MysqlDataSource(); //initialize the data source

        //setting login credentials to read the MySQL database
        mds.setUser("teammate");
        mds.setPassword("TM:MySQL420");

        mds.setServerName("localhost"); //for proof of concept, just using local MySQL database; no money for cloud hosted
        mds.setPortNumber(3306); //the port used for MySQL connections
        mds.setDatabaseName("JadeLink"); //the database's name

        PreparedStatement readValues = null; //the PreparedStatement used to query the database
        if (whichQuery == OVERVIEW || whichQuery == GRADES) { //querying grades for overview
            queryString = "SELECT course_info.course_name, grades.lt_one, grades.lt_two, grades.lt_three, grades.lt_four " +
                    "FROM grades " +
                    "INNER JOIN course_info ON course_info.course_id = grades.course_id " +
                    "WHERE student_id = " + student_id + ";";
        }
        else if (whichQuery == COURSEHISTORY) { //querying which courses the student has taken
            //TODO add to database as well as add Java functionality
        }
        else if (whichQuery == HEALTH) { //querying health info
            queryString = "SELECT student_info.first_name, student_info.last_name, immunizations.* " +
                    "FROM immunizations " +
                    "INNER JOIN student_info ON student_info.student_id = immunizations.student_id " +
                    "WHERE student_info.student_id = " + student_id + ";";
        }
        else if (whichQuery == STUDENTINFORMATION) { //querying student info

        }

        try {
            conn = mds.getConnection(); //creating the connection
            readValues = conn.prepareStatement(queryString); //preparing the query
            ResultSet rs = readValues.executeQuery(queryString); //executing the query
            if (whichQuery == OVERVIEW) { //if querying for overview
                while (rs.next()) { //while still records left
                    double lt_avg = (rs.getInt("lt_one") + rs.getInt("lt_two") + rs.getInt("lt_three") + rs.getInt("lt_four")) / 4; //averages the four learning target grades
                    char letterGrade; //the letter grade for the class

                    //calculating letter grade
                    if (lt_avg >= 3.4) {
                        letterGrade = 'A';
                    }
                    else if (lt_avg >= 2.8) {
                        letterGrade = 'B';
                    }
                    else if (lt_avg >= 2.2) {
                        letterGrade = 'C';
                    }
                    else if (lt_avg >= 1.6) {
                        letterGrade = 'D';
                    }
                    else {
                        letterGrade = 'F';
                    }

                    System.out.println(rs.getString("course_name") + ": " + letterGrade); //prints simple String stating the letter grade in the class
                }
            }
            else if (whichQuery == GRADES) { //if querying for specific grades
                while (rs.next()) {
                    System.out.println(rs.getString("course_name") + ": " +
                            "\nLearning Target 1: " + rs.getInt("lt_one") +
                            "\nLearning Target 2: " + rs.getInt("lt_two") +
                            "\nLearning Target 3: " + rs.getInt("lt_three") +
                            "\nLearning Target 4: " + rs.getInt("lt_four") + "\n");
                }
            }
            else if (whichQuery == COURSEHISTORY) {
                //TODO refer to previous TODO
            }
            else if (whichQuery == HEALTH) { //if querying for health info
                while (rs.next()) {
                    ResultSetMetaData rsmd = rs.getMetaData(); //used to get column names
                    String immunizations = rs.getString("first_name") + " " + rs.getString("last_name") + ": ";
                    for (int i = 0; i < 9; i++) {
                        immunizations += "\n\t";
                        if (rs.getInt(i + 4) == 1) {
                            immunizations += rsmd.getColumnName(i + 4) + ": ✓";
                        }
                        else {
                            immunizations += rsmd.getColumnName(i + 4) + ": ✘";
                        }
                    }
                    System.out.println(immunizations);
                }
            }
            rs.close();
            readValues.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main (String[] args) { //for debugging purposes
        new SQLQueries(HEALTH, 100287);
    }

}