package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionService {

    public static void selectAll(ArrayList<Question> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT QuestionId, " +
                                                                "Question, Answer1, Answer2, Answer3, Answer4, " +
                                                                "CorrectAnswer, QuizId FROM Question");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Question(
                                results.getInt("QuestionId"),
                                results.getString("Question"),
                                results.getString("Answer1"),
                                results.getString("Answer2"),
                                results.getString("Answer3"),
                                results.getString("Answer4"),
                                results.getInt("CorrectAnswer"),
                                results.getInt("QuizId")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }

    }

}
