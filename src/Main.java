
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
    private static ListView<Main> proListView;


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
            btn.setOnAction((ActionEvent ae) -> openNewStage(root));
            root.getChildren().add(btn);

            Button btn2 = new Button();
            btn2.setText("Give feedback");
            btn2.setLayoutX(470);
            btn2.getStyleClass().add("start_button");
            btn2.setLayoutY(340);
            btn2.setOnAction((ActionEvent ae) -> openNewStage2(root));
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
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);
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