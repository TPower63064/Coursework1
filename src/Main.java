
import Model.DatabaseConnection;
import Model.Question;
import Model.QuestionService;
import com.sun.org.apache.bcel.internal.generic.DUP;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.Optional;

public class Main extends Application {
    private static TextField txtFieldMessage;
    private static PasswordField txtFieldPassword;
    private static ListView<Main> proListView;
    public static DatabaseConnection database;


    @Override
    public void start(Stage stage) throws Exception {
        database = new DatabaseConnection("Database.db");


        Pane root = new Pane();
        Scene scene = new Scene(root, 1024, 768);
        stage.setScene(scene);
        stage.setTitle("Economics Quiz");
        stage.setWidth(768);
        stage.setHeight(568);

        proListView = new ListView<>();
        proListView.setLayoutX(700);
        proListView.setLayoutY(60);

        Label label = new Label("Enter Details");
        label.setLayoutX(189);
        label.getStyleClass().add("title_button");
        label.setLayoutY(190);
        root.getChildren().add(label);


        Label label2 = new Label("Student ID");
        label2.setLayoutX(189);
        label2.getStyleClass().add("label_button");
        label2.setLayoutY(240);
        root.getChildren().add(label2);

        Label label3 = new Label("Password");
        label3.setLayoutX(189);
        label3.getStyleClass().add("label_button");
        label3.setLayoutY(290);
        root.getChildren().add(label3);

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(270);
        txtFieldMessage.setLayoutY(240);
        txtFieldMessage.setPrefWidth(250);
        root.getChildren().add(txtFieldMessage);

        txtFieldPassword = new PasswordField();
        txtFieldPassword.setLayoutX(270);
        txtFieldPassword.setLayoutY(290);
        txtFieldPassword.setPrefWidth(250);
        root.getChildren().add(txtFieldPassword);

        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(334);
        scene.getStylesheets().add("stylesheet.css");
        btn.getStyleClass().add("enter_button");
        btn.setLayoutY(340);
        btn.setOnAction((ActionEvent ae) -> openNewStage(root));

        root.getChildren().add(btn);

        stage.show();
        stage.setOnCloseRequest ((WindowEvent we) -> displayCloseDialog(we));

    }


    private static void openNewStage(Pane parent) {
        new StageTwo(parent);
    }

    public static class StageTwo {

        static Pane parent;

        public StageTwo(Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);
            start(stage);

        }

        public void start(Stage stage) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("Economics quiz");
            stage.setScene(scene);
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();
            scene.getStylesheets().add("stylesheet.css");

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);

            Button btn = new Button();
            btn.setText("Start quiz");
            btn.setLayoutX(304);
            btn.getStyleClass().add("start_button");
            btn.setLayoutY(340);
            btn.setOnAction((ActionEvent ae) -> openNewStage2(root));
            root.getChildren().add(btn);

            Button btn2 = new Button();
            btn2.setText("Feedback");
            btn2.setLayoutX(470);
            btn2.getStyleClass().add("start_button");
            btn2.setLayoutY(340);
            btn2.setOnAction((ActionEvent ae) -> openNewStage7(root));
            root.getChildren().add(btn2);
        }

        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }

    }

    private static void openNewStage2(Pane parent) {
        new StageThree(parent);
    }

    public static class StageThree {

        static Pane parent;

        public StageThree(Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);

            ArrayList<Question> allTheQuestions = new ArrayList<>();
            QuestionService.selectAll(allTheQuestions, database);
            Question question = allTheQuestions.get(0);

            start(stage, question);

        }

        public void start(Stage stage, Question question) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("Economics quiz");
            stage.setScene(scene);
            scene.getStylesheets().add("stylesheet.css");
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);

            Label label = new Label(question.getQuestion());
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 1:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb[] = new CheckBox[4];
            for (int i = 0; i < 4; i++) {

                cb[i] = new CheckBox();
                cb[i].setText(question.getAnswers()[i]);
                cb[i].setLayoutX(370);
                cb[i].getStyleClass().add("answer_button");
                cb[i].setLayoutY(340 + i * 40);
                root.getChildren().add(cb[i]);

            }   


            Button btn5 = new Button();
            btn5.setText("Next");
            btn5.setLayoutX(470);
            btn5.getStyleClass().add("start_button");
            btn5.setLayoutY(540);
            btn5.setOnAction((ActionEvent ae) -> openNewStage3(root));
            root.getChildren().add(btn5);


        }
        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }

    }

    private static void openNewStage3(Pane parent) {
        new StageFour(parent);
    }
         public static class StageFour {

        static Pane parent;

        public StageFour(Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);

            ArrayList<Question> allTheQuestions = new ArrayList<>();
            QuestionService.selectAll(allTheQuestions, database);
            Question question = allTheQuestions.get(1);

            start(stage, question);

        }

        public void start(Stage stage, Question question) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("Economics quiz");
            stage.setScene(scene);
            scene.getStylesheets().add("stylesheet.css");
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);

            Label label = new Label(question.getQuestion());
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 2:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb1[] = new CheckBox[4];
            for (int i = 0; i < 4; i++) {
                cb1[i].setText(question.getAnswers()[i]);
                cb1[i].setLayoutX(370);
                cb1[i].getStyleClass().add("answer_button");
                cb1[i].setLayoutY(340 + i * 40);
                root.getChildren().add(cb1[i]);
            }


            Button btn5 = new Button();
            btn5.setText("Next");
            btn5.setLayoutX(470);
            btn5.getStyleClass().add("start_button");
            btn5.setLayoutY(540);
            btn5.setOnAction((ActionEvent ae) -> openNewStage4(root));
            root.getChildren().add(btn5);
        }

        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }
    }

    private static void openNewStage4(Pane parent) {
        new StageFive(parent);
    }
    @SuppressWarnings("Duplicates")

    public static class StageFive {

        static Pane parent;

        public StageFive (Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);

            ArrayList<Question> allTheQuestions = new ArrayList<>();
            QuestionService.selectAll(allTheQuestions, database);
            Question question = allTheQuestions.get(2);

            start(stage, question);

        }

        public void start(Stage stage, Question question) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("Economics quiz");
            stage.setScene(scene);
            scene.getStylesheets().add("stylesheet.css");
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);

            Label label = new Label(question.getQuestion());
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 3:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb[] = new CheckBox[4];
            for (int i = 0; i < 4; i++) {

                cb[i].setText(question.getAnswers()[i]);
                cb[i].setLayoutX(370);
                cb[i].getStyleClass().add("answer_button");
                cb[i].setLayoutY(340 + i * 40);
                root.getChildren().add(cb[i]);
            }

            Button btn5 = new Button();
            btn5.setText("Next");
            btn5.setLayoutX(470);
            btn5.getStyleClass().add("start_button");
            btn5.setLayoutY(540);
            btn5.setOnAction((ActionEvent ae) -> openNewStage5(root));
            root.getChildren().add(btn5);


        }

        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }
    }


    private static void openNewStage5(Pane parent) {
        new StageSix(parent);
    }

    public static class StageSix {

        static Pane parent;

        public StageSix(Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);
            start(stage);

        }

        public void start(Stage stage) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("Economics quiz");
            stage.setScene(scene);
            scene.getStylesheets().add("stylesheet.css");
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);

            Label label = new Label("Which one of the following situations would lead to an increase in equilibrium price?");
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 4:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb = new CheckBox();
            cb.setText("A.  Demand is perfectly inelastic and a firm’s labour costs fall.");
            cb.setLayoutX(370);
            cb.getStyleClass().add("answer_button");
            cb.setLayoutY(340);
            root.getChildren().add(cb);

            CheckBox cb2 = new CheckBox();
            cb2.setText("B.  Demand is perfectly elastic and a firm’s labour costs rise. ");
            cb2.setLayoutX(370);
            cb2.getStyleClass().add("answer_button");
            cb2.setLayoutY(380);
            root.getChildren().add(cb2);

            CheckBox cb3 = new CheckBox();
            cb3.setText("C.  Supply is perfectly elastic and the price of a substitute good falls.");
            cb3.setLayoutX(370);
            cb3.getStyleClass().add("answer_button");
            cb3.setLayoutY(420);
            root.getChildren().add(cb3);

            CheckBox cb4 = new CheckBox();
            cb4.setText("D.  Demand is perfectly inelastic and a firm’s labour costs rise.");
            cb4.setLayoutX(370);
            cb4.getStyleClass().add("answer_button");
            cb4.setLayoutY(480);
            root.getChildren().add(cb4);

            Button btn5 = new Button();
            btn5.setText("Next");
            btn5.setLayoutX(470);
            btn5.getStyleClass().add("start_button");
            btn5.setLayoutY(540);
            btn5.setOnAction((ActionEvent ae) -> openNewStage6(root));
            root.getChildren().add(btn5);
        }

        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }
    }

    private static void openNewStage6(Pane parent) {
        new StageSeven(parent);
    }

    public static class StageSeven {

        static Pane parent;

        public StageSeven(Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);
            start(stage);

        }

        public void start(Stage stage) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("Economics quiz");
            stage.setScene(scene);
            scene.getStylesheets().add("stylesheet.css");
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);

            Label label = new Label("Which one of the following is true? ");
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 5:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb = new CheckBox();
            cb.setText("A.  A positive statement is one which can be tested against the facts. ");
            cb.setLayoutX(370);
            cb.getStyleClass().add("answer_button");
            cb.setLayoutY(340);
            root.getChildren().add(cb);

            CheckBox cb2 = new CheckBox();
            cb2.setText("B.  A positive statement is one which never contains words such as ‘could’ or ‘should’.");
            cb2.setLayoutX(370);
            cb2.getStyleClass().add("answer_button");
            cb2.setLayoutY(380);
            root.getChildren().add(cb2);

            CheckBox cb3 = new CheckBox();
            cb3.setText("C.  A normative statement is one which can be scientifically proven to be true or false. ");
            cb3.setLayoutX(370);
            cb3.getStyleClass().add("answer_button");
            cb3.setLayoutY(420);
            root.getChildren().add(cb3);

            CheckBox cb4 = new CheckBox();
            cb4.setText("D.  A normative statement is one which never contains words such as ‘is’ or ‘will’ or ‘always’.");
            cb4.setLayoutX(370);
            cb4.getStyleClass().add("answer_button");
            cb4.setLayoutY(480);
            root.getChildren().add(cb4);

            Button btn5 = new Button();
            btn5.setText("Next");
            btn5.setLayoutX(470);
            btn5.getStyleClass().add("start_button");
            btn5.setLayoutY(540);
            btn5.setOnAction((ActionEvent ae) -> openNewStage7(root));
            root.getChildren().add(btn5);
        }

        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }
    }


    private static void openNewStage7(Pane parent) {
        new StageEight(parent);
    }

    public static class StageEight{

        static Pane parent;

        public StageEight(Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);
            start(stage);

        }

        public void start(Stage stage) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("Economics quiz");
            stage.setScene(scene);
            scene.getStylesheets().add("stylesheet.css");
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);

            Label label3 = new Label("Feedback");
            label3.setLayoutX(380);
            label3.getStyleClass().add("feedback_label");
            label3.setLayoutY(200);
            root.getChildren().add(label3);

            txtFieldMessage = new TextField();
            txtFieldMessage.setLayoutX(270);
            txtFieldMessage.setLayoutY(240);
            txtFieldMessage.setPrefSize(400,200);
            root.getChildren().add(txtFieldMessage);

            Button btn5 = new Button();
            btn5.setText("Finish");
            btn5.setLayoutX(400);
            btn5.getStyleClass().add("start_button");
            btn5.setLayoutY(470);
            root.getChildren().add(btn5);
            btn5.setOnAction((ActionEvent ae) -> stage.close());
        }

        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }
    }


    private static void displayCloseDialog(WindowEvent we) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to quiz");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK)
        {
            System.exit(0);
        }
        else
        {
            we.consume();
        }
    }




}