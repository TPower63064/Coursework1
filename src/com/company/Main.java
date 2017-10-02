package com.company;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    private static TextField txtFieldMessage;
    private static TextField txtFieldName;
    private static TextField txtFieldCountry;
    private static ListView<Main> proListView;
    private static ArrayList<Main> proArrList = new ArrayList<>();

    public static void main(String args[]) {
        launchFX();
    }

    private static void launchFX() {
        new JFXPanel();
        Platform.runLater(() -> initialiseGUI());
    }

    private static void displayCloseDialog(WindowEvent we) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to quiz");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK)
        { terminate();
        }
        else
        {
            we.consume();
        }
    }

    private static void terminate() {
        System.out.println("Thank you");
        System.exit(0);
    }

    private static void initialiseGUI() {
        Stage stage = new Stage();
        stage.setTitle("Economics Quiz");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();
        stage.setOnCloseRequest ((WindowEvent we) -> displayCloseDialog(we));


        proListView = new ListView<>();
        proListView.setLayoutX(700);
        proListView.setLayoutY(60);

        Label label = new Label("Enter Details");
        label.setLayoutX(60);
        label.setLayoutY(60);
        rootPane.getChildren().add(label);

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(50);
        txtFieldMessage.setLayoutY(100);
        txtFieldMessage.setPrefWidth(400);
        txtFieldMessage.setPromptText("Enter Student ID");
        rootPane.getChildren().add(txtFieldMessage);

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(50);
        txtFieldMessage.setLayoutY(150);
        txtFieldMessage.setPrefWidth(400);
        txtFieldMessage.setPromptText("Enter Password");
        rootPane.getChildren().add(txtFieldMessage);

        Button btn = new Button();
        btn.setText("Enter");
        btn.setLayoutX(50);
        btn.setLayoutY(500);
//        btn.setOnAction((ActionEvent ae) -> addNewItem());
        rootPane.getChildren().add(btn);
    }
}


//    private static void addNewItem() {
//        int ranking = Integer.parseInt(txtFieldName.getText());
//        String name = txtFieldName.getText();
//        String country = txtFieldCountry.getText();
//        proArrList.add(new Economics(StudentID, name, country));
//
//        proListView.getItems().clear();
//        for ( Economics : uniArrList){
//            proListView.getItems().add(pro);
//        }
//    }

//    public static void setTxtFieldName(TextField txtFieldName) {
//        Main.txtFieldName = txtFieldName;
//    }
//
//    public static void setTxtFieldCountry(TextField txtFieldCountry) {
//        Main.txtFieldCountry = txtFieldCountry;
//    }
//}
