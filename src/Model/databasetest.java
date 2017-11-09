package Model;

import java.util.ArrayList;

public class databasetest {

    public static DatabaseConnection database;

    public static void main(String[] Args){

        database = new DatabaseConnection("Database.db");
        ArrayList<Answer> testList = new ArrayList<>();

        AnswerService.selectAll(testList, database);

        for (Answer c: testList) {
            System.out.println(c);
        }
    }

}
