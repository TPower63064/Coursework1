package Model;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnswerService {

    public static void selectAll(ArrayList<Answer> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT AnswerID, Answer FROM Answer ORDER BY AnswerID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Answer(
                                results.getInt("AnswerID"),
                                results.getInt("QuestionID"),
                                results.getString("Answer")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

    }


}





