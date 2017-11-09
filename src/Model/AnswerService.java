package Model;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnswerService {

    public static void selectById(int answerID, DatabaseConnection database) {
    }

    public static void save(Console console, DatabaseConnection database) {
    }

    public static void deleteById(int id, DatabaseConnection database) {
    }


    public static void selectAll(ArrayList<Answer> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT AnswerID, Answer FROM Answer ORDER BY AnswerID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Answer(results.getInt("AnswerID"), results.getString("Answer"), results.getInt("QuestionID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

    }
}





