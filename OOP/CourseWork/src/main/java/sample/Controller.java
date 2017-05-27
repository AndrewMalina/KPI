package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import service.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button buyButton, searchButton;

    @FXML
    private TextField fieldFrom, fieldTo, fieldCarriage, fieldPlace;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void searchEvent(ActionEvent event) {
        buyButton.setStyle("-fx-background-color: #60a024; -fx-border-color: #5b9b21; -fx-border-radius: 4;");
        buyButton.setTextFill(Paint.valueOf("WHITE"));
        buyButton.setDisable(false);

        searchButton.setStyle(null);
        searchButton.setTextFill(Paint.valueOf("BLACK"));


    }

    public void buyEvent(ActionEvent event) {
        buyButton.setStyle(null);
        buyButton.setTextFill(Paint.valueOf("BLACK"));
        buyButton.setDisable(true);

        searchButton.setStyle("-fx-background-color: #60a024; -fx-border-color: #5b9b21; -fx-border-radius: 4;");
        searchButton.setTextFill(Paint.valueOf("WHITE"));
    }
}
