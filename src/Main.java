
import Model.AnswerService;
import Model.DatabaseConnection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.Console;
import java.util.ArrayList;
import java.util.Optional;

public class Main extends Application {
    private static TextField txtFieldMessage;
    private static ListView<Main> proListView;
    public static DatabaseConnection database;


    @Override
    public void start(Stage stage) throws Exception {
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

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(270);
        txtFieldMessage.setLayoutY(290);
        txtFieldMessage.setPrefWidth(250);
        root.getChildren().add(txtFieldMessage);

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
            btn2.setText("Give feedback");
            btn2.setLayoutX(470);
            btn2.getStyleClass().add("start_button");
            btn2.setLayoutY(340);
            btn2.setOnAction((ActionEvent ae) -> openNewStage(root));
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

            Label label = new Label("The equilibrium market price can be defined as the price at which: ");
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 1:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb = new CheckBox();
            cb.setText("A.  The market for the product clears");
            cb.setLayoutX(370);
            cb.getStyleClass().add("answer_button");
            cb.setLayoutY(340);
            root.getChildren().add(cb);

            CheckBox cb2 = new CheckBox();
            cb2.setText("B.  The PED equals the PES");
            cb2.setLayoutX(370);
            cb2.getStyleClass().add("answer_button");
            cb2.setLayoutY(380);
            root.getChildren().add(cb2);

            CheckBox cb3 = new CheckBox();
            cb3.setText("C.  Producers maximise their profits");
            cb3.setLayoutX(370);
            cb3.getStyleClass().add("answer_button");
            cb3.setLayoutY(420);
            root.getChildren().add(cb3);

            CheckBox cb4 = new CheckBox();
            cb4.setText("D.  Positive excess demand equals negative supply");
            cb4.setLayoutX(370);
            cb4.getStyleClass().add("answer_button");
            cb4.setLayoutY(480);
            root.getChildren().add(cb4);

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

            Label label = new Label("Diseconomies of scale occur when:");
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 2:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb = new CheckBox();
            cb.setText("A.  Average cost falls due to the growth of a firm.");
            cb.setLayoutX(370);
            cb.getStyleClass().add("answer_button");
            cb.setLayoutY(340);
            root.getChildren().add(cb);

            CheckBox cb2 = new CheckBox();
            cb2.setText("B.  Average cost rises due to a firm reducing its output ");
            cb2.setLayoutX(370);
            cb2.getStyleClass().add("answer_button");
            cb2.setLayoutY(380);
            root.getChildren().add(cb2);

            CheckBox cb3 = new CheckBox();
            cb3.setText("C.  Total cost rises due to the growth of a firm");
            cb3.setLayoutX(370);
            cb3.getStyleClass().add("answer_button");
            cb3.setLayoutY(420);
            root.getChildren().add(cb3);

            CheckBox cb4 = new CheckBox();
            cb4.setText("D.  Average cost rises due to the growth of a firm");
            cb4.setLayoutX(370);
            cb4.getStyleClass().add("answer_button");
            cb4.setLayoutY(480);
            root.getChildren().add(cb4);

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

    public static class StageFive {

        static Pane parent;

        public StageFive(Pane theParent) {

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

            Label label = new Label("Which one of the following is most likely to make a market more competitive? :");
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 3:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb = new CheckBox();
            cb.setText("A.  An increase in the cost of equipment used in the production process.");
            cb.setLayoutX(370);
            cb.getStyleClass().add("answer_button");
            cb.setLayoutY(340);
            root.getChildren().add(cb);

            CheckBox cb2 = new CheckBox();
            cb2.setText("B.  The development of a successful new product by the largest firm in the market.");
            cb2.setLayoutX(370);
            cb2.getStyleClass().add("answer_button");
            cb2.setLayoutY(380);
            root.getChildren().add(cb2);

            CheckBox cb3 = new CheckBox();
            cb3.setText("C.  An increase in the degree of concentration in the market.");
            cb3.setLayoutX(370);
            cb3.getStyleClass().add("answer_button");
            cb3.setLayoutY(420);
            root.getChildren().add(cb3);

            CheckBox cb4 = new CheckBox();
            cb4.setText("D.  The removal of legal barriers to entry into the market.");
            cb4.setLayoutX(370);
            cb4.getStyleClass().add("answer_button");
            cb4.setLayoutY(480);
            root.getChildren().add(cb4);

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

            Label label = new Label("Diseconomies of scale occur when:");
            label.setLayoutX(169);
            label.getStyleClass().add("questions_button");
            label.setLayoutY(210);
            root.getChildren().add(label);

            Label label2 = new Label("Question 2:");
            label2.setLayoutX(189);
            label2.getStyleClass().add("questions_button");
            label2.setLayoutY(160);
            root.getChildren().add(label2);

            CheckBox cb = new CheckBox();
            cb.setText("A.  Average cost falls due to the growth of a firm.");
            cb.setLayoutX(370);
            cb.getStyleClass().add("answer_button");
            cb.setLayoutY(340);
            root.getChildren().add(cb);

            CheckBox cb2 = new CheckBox();
            cb2.setText("B.  Average cost rises due to a firm reducing its output ");
            cb2.setLayoutX(370);
            cb2.getStyleClass().add("answer_button");
            cb2.setLayoutY(380);
            root.getChildren().add(cb2);

            CheckBox cb3 = new CheckBox();
            cb3.setText("C.  Total cost rises due to the growth of a firm");
            cb3.setLayoutX(370);
            cb3.getStyleClass().add("answer_button");
            cb3.setLayoutY(420);
            root.getChildren().add(cb3);

            CheckBox cb4 = new CheckBox();
            cb4.setText("D.  Average cost rises due to the growth of a firm");
            cb4.setLayoutX(370);
            cb4.getStyleClass().add("answer_button");
            cb4.setLayoutY(480);
            root.getChildren().add(cb4);

            Button btn5 = new Button();
            btn5.setText("Next");
            btn5.setLayoutX(470);
            btn5.getStyleClass().add("start_button");
            btn5.setLayoutY(540);
            btn5.setOnAction((ActionEvent ae) -> openNewStage2(root));
            root.getChildren().add(btn5);
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