package com.company;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.WindowEvent;
import java.util.ArrayList;

public class Main
{
    private static TextField txtFieldMessage;
    private static TextField txtFieldName;
    private static TextField txtFieldCountry;
    private static ListView<Main> uniListView;
    private static ArrayList<Main> uniArrList = new ArrayList<>();

    public static void main(String args[])
    {
        launchFX();
    }

    private static void launchFX()
    {
        new JFXPanel();
        Platform.runLater(() -> initialiseGUI());
    }

    private static void terminate()
    {
        System.out.println("bye bye!");
        System.exit(0);
    }

    private static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle ("Top universities");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();

        uniListView = new ListView<>();
        uniListView.setLayoutX(700);
        uniListView.setLayoutY(60);
        char label;
        rootPane.getChildren().add(label);

        Label label = new label ("eNTER dETail");
        label.setLayoutX(60);
        label.setLayoutY(60);
        rootPane.getChildren().add(label);

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(50);
        txtFieldMessage.setLayoutY(100);
        txtFieldMessage.setPrefWidth(400);
        txtFieldMessage.setPromptText("Enter ranking");
        rootPane.getChildren().add(txtFieldMessage);

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(50);
        txtFieldMessage.setLayoutY(150);
        txtFieldMessage.setPrefWidth(400);
        txtFieldMessage.setPromptText("Enter name");
        rootPane.getChildren().add(txtFieldMessage);

        txtFieldMessage = new TextField();
        txtFieldMessage.setLayoutX(50);
        txtFieldMessage.setLayoutY(200);
        txtFieldMessage.setPrefWidth(400);
        txtFieldMessage.setPromptText("Enter country");
        rootPane.getChildren().add(txtFieldMessage);

        Button btn = new Button();
        btn.setText (" click me ");
        btn.setLayoutX(50);
        btn.setLayoutY(500);
        btn.setOnAction((ActionEvent ae) -> addNewItem());
        rootPane.getChildren().add(btn);
    }


    private static void addNewItem() {
        int ranking = Integer.parseInt(txtFieldRanking.getText());
        String name = txtFieldName.getText();
        String country = txtFieldCountry.getText();
        uniArrList.add(new University(ranking, name, country));

        uniListView.getItems().clear();
        for ( University uni : uniArrList){
            uniListView.getItems().add(uni);
        }
    }

    public static void setTxtFieldName(TextField txtFieldName) {
        Main.txtFieldName = txtFieldName;
    }

    public static void setTxtFieldCountry(TextField txtFieldCountry) {
        Main.txtFieldCountry = txtFieldCountry;
    }
}
