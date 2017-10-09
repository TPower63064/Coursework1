
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
    private static TextField txtFieldName;
    private static TextField txtFieldCountry;
    private static ListView<Main> proListView;
    private static ArrayList<Main> proArrList = new ArrayList<>();



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
        label.setLayoutX(334);
        label.setLayoutY(210);
        root.getChildren().add(label);

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(194);
        txtFieldMessage.setLayoutY(240);
        txtFieldMessage.setPrefWidth(400);
        txtFieldMessage.setPromptText("Enter Student ID");
        root.getChildren().add(txtFieldMessage);

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(194);
        txtFieldMessage.setLayoutY(290);
        txtFieldMessage.setPrefWidth(400);
        txtFieldMessage.setPromptText("Enter Password");
        root.getChildren().add(txtFieldMessage);

        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(344);
        btn.getStyleClass().add("funky_button");
        stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
        btn.setLayoutY(340);
        btn.setOnAction((ActionEvent ae) -> openNewStage(root));

        root.getChildren().add(btn);

        stage.show();
        stage.setOnCloseRequest ((WindowEvent we) -> displayCloseDialog(we));
    }


    private static void openNewStage(Pane parent) {
        StageTwo newStage = new StageTwo(parent);
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

            proListView = new ListView<>();
            proListView.setLayoutX(700);
            proListView.setLayoutY(60);

            Button btn = new Button();
            btn.setText("Start quiz");
            btn.setLayoutX(344);
            btn.getStyleClass().add("start_button");
            btn.setLayoutY(340);
            btn.setOnAction((ActionEvent ae) -> openNewStage(root));
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            root.getChildren().add(btn);

            Button btn2 = new Button();
            btn2.setText("Give feedback");
            btn2.setLayoutX(410);
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
        StageThree newStage = new StageThree(parent);
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