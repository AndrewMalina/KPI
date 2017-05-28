package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import models.City;
import models.Stop;
import models.Train;
import service.DBTrainService;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import static java.awt.SystemColor.window;

public class Controller implements Initializable {

    @FXML
    private Button buyButton, searchButton;

    @FXML
    private TextField fieldFrom, fieldTo, fieldCarriage, fieldPlace;

    @FXML
    private TableView<TrainTableRow> table;

    @FXML
    private DatePicker fieldDate;

    private final String pattern = "yyyy-MM-dd";

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void searchEvent(ActionEvent event) {
        buyButton.setStyle("-fx-background-color: #60a024; -fx-border-color: #5b9b21; -fx-border-radius: 4;");
        buyButton.setTextFill(Paint.valueOf("WHITE"));
        buyButton.setDisable(false);

        searchButton.setStyle(null);
        searchButton.setTextFill(Paint.valueOf("BLACK"));

        showTable();

    }


    public void buyEvent(ActionEvent event) {
        buyButton.setStyle(null);
        buyButton.setTextFill(Paint.valueOf("BLACK"));
        buyButton.setDisable(true);

        searchButton.setStyle("-fx-background-color: #60a024; -fx-border-color: #5b9b21; -fx-border-radius: 4;");
        searchButton.setTextFill(Paint.valueOf("WHITE"));
    }

    public void dateEvent(ActionEvent event){

        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };

        fieldDate.setConverter(converter);
        fieldDate.setPromptText(pattern.toLowerCase());
        fieldDate.requestFocus();
    }

    private void showTable() {
        table.setItems(getTrainTableRow());
    }

    private ObservableList<TrainTableRow> getTrainTableRow() {
        ObservableList<TrainTableRow> trainTableRows = FXCollections.observableArrayList();

        List<Train> neadTrains = DBTrainService.getInstance().search(fieldFrom.getText(), fieldTo.getText(),fieldDate.getValue());


        List<Stop> stopTrains;
        DBTrainService city = new DBTrainService();
        List<City> cities = city.getAllCity();
        String start = "";
        String end = "";

        for (Train train : neadTrains) {
            stopTrains = train.getStops();
            for (Stop stop : stopTrains) {
                if (fieldFrom.getText().equals(cities.get(stop.getCity()-1).getCityName())){
                    start = stop.getDate().toString();
                }
                if (fieldTo.getText().equals(cities.get(stop.getCity()-1).getCityName())){
                    end = stop.getDate().toString();
                }
            }
            trainTableRows.add(new TrainTableRow(train.getId(), train.getName(), train.getType(), fieldFrom.getText() + " - " + fieldTo.getText(), start,end,2));
        }
        return trainTableRows;
    }
}
