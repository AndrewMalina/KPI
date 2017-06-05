package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import models.City;
import models.Stop;
import models.Train;
import service.DBTicketService;
import service.DBTrainService;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerSampleFXML implements Initializable {

    private final String pattern = "yyyy-MM-dd";
    @FXML
    private Button buyButton, searchButton;
    @FXML
    private TextField fieldFrom, fieldTo, fieldCarriage, fieldPlace, fieldName, fieldSurname;
    @FXML
    private TableView<TrainTableRow> table;
    @FXML
    private DatePicker fieldDate;

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
        if(buyTicket()){
            buyButton.setStyle(null);
            buyButton.setTextFill(Paint.valueOf("BLACK"));
            buyButton.setDisable(true);

            searchButton.setStyle("-fx-background-color: #60a024; -fx-border-color: #5b9b21; -fx-border-radius: 4;");
            searchButton.setTextFill(Paint.valueOf("WHITE"));
        }else {
            buyButton.setDisable(false);
        }
    }

    public void dateEvent(ActionEvent event) {

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

        List<Train> needTrains = DBTrainService.getInstance().search(fieldFrom.getText(), fieldTo.getText(), fieldDate.getValue());


        List<Stop> stopTrains;
        DBTrainService city = new DBTrainService();
        List<City> cities = city.getAllCity();
        String start = "";
        String end = "";

        for (Train train : needTrains) {
            stopTrains = train.getStops();
            for (Stop stop : stopTrains) {
                if (fieldFrom.getText().equals(cities.get(stop.getCity() - 1).getCityName())) {
                    start = stop.getDate().toString();
                }
                if (fieldTo.getText().equals(cities.get(stop.getCity() - 1).getCityName())) {
                    end = stop.getDate().toString();
                }
            }
            trainTableRows.add(new TrainTableRow(train.getId(), train.getName(), train.getType(), fieldFrom.getText() + " - " + fieldTo.getText(), start, end, 2,
                    train.getStops()));
        }
        return trainTableRows;
    }

    private boolean buyTicket() {
        TrainTableRow selectedTrain;

        selectedTrain = table.getSelectionModel().getSelectedItem();

        DBTicketService dbTicketService = new DBTicketService();

        int start, end;
        start = end = 0;

        DBTrainService city = new DBTrainService();
        List<City> cities = city.getAllCity();

        for (City cityObject : cities) {
            if (cityObject.getCityName().equalsIgnoreCase(fieldFrom.getText())) {
                start = cityObject.getId();
            }
            if (cityObject.getCityName().equalsIgnoreCase(fieldTo.getText())) {
                end = cityObject.getId();
            }
        }
        if (check(dbTicketService,start, end, fieldCarriage.getText(), fieldPlace.getText(), selectedTrain.getId())) {
            dbTicketService.buy(selectedTrain.getStopList(), start, end, fieldName.getText(), fieldSurname.getText(), fieldCarriage.getText(), fieldPlace.getText(), selectedTrain.getType(),
                    selectedTrain.getId());
            return true;
        } else {
            try{
                Parent root  = FXMLLoader.load(getClass().getClassLoader().getResource("Error.fxml"));
                Scene scene = new Scene(root, 350, 140);

                Stage primaryStage = new Stage();
                primaryStage.setResizable(false);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Error");

                primaryStage.show();

            }catch(Exception e){
                System.out.println("can`t load exception window");
            }
            return false;
        }

    }

    private boolean check(DBTicketService dbTicketService, int start, int end, String carriageText, String placeText, Integer id) {
        return dbTicketService.reservation(start, end, carriageText, placeText, id);
    }
}
