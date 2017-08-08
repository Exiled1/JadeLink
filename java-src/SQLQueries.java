import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLQueries {

    MysqlDataSource mds; //the data source
    Connection conn; //the connection to the database

    final static int OVERVIEW = 0;
    final static int MESSAGES = 1;
    final static int COURSEHISTORY = 2;
    final static int COURSEREQUEST = 3;
    final static int HEALTH = 4;
    final static int STUDENTINFORMATION = 5;

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
        if (whichQuery == OVERVIEW) { //querying average grade for overview
            queryString = "SELECT course_info.course_name, grades.lt_one, grades.lt_two, grades.lt_three, grades.lt_four " +
                    "FROM grades " +
                    "INNER JOIN course_info ON course_info.course_id = grades.course_id " +
                    "WHERE student_id = " + student_id + ";";
        }

        try {
            conn = mds.getConnection(); //creating the connection
            readValues = conn.prepareStatement(queryString); //preparing the query
            ResultSet rs = readValues.executeQuery(queryString); //executing the query
            if (whichQuery == OVERVIEW) { //if querying for overview
                while (rs.next()) { //while still records left
                    double lt_avg = (rs.getInt("lt_one") + rs.getInt("lt_two") + rs.getInt("lt_three") + rs.getInt("lt_four")) / 4; //averages the four learning target grades
                    char grade; //the grade for the class
                    if (lt_avg >= 3.4) {
                        grade = 'A';
                    }
                    else if (lt_avg >= 2.8) {
                        grade = 'B';
                    }
                    else if (lt_avg >= 2.2) {
                        grade = 'C';
                    }
                    else if (lt_avg >= 1.6) {
                        grade = 'D';
                    }
                    else {
                        grade = 'F';
                    }
                    System.out.println(rs.getString("course_name") + ": " + grade);
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
        new SQLQueries(OVERVIEW, 100287);
    }

}