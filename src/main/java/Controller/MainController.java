package Controller;

import Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    Button refreshDataBttn;
    @FXML
    TextArea RegArea;
    @FXML
    Button checkRegBttn;
    @FXML
    ComboBox<String> SimboluriBox;
    private Service service;

    @FXML
    Button searchProdBttn;

    @FXML
    Button LoadButton;
    @FXML
    Button SimbNeterminaleBttn;
    @FXML
    Button SimbTerminaleBttn;
    @FXML
    Button SimbStartBttn;
    @FXML
    Button ProductiiBttn;
    @FXML
    TextArea showArea;
    @FXML
    Button clearBttn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service=new Service();
        SimbNeterminaleBttn.setDisable(true);
        SimbTerminaleBttn.setDisable(true);
        SimbStartBttn.setDisable(true);
        ProductiiBttn.setDisable(true);
        checkRegBttn.setDisable(true);
        searchProdBttn.setDisable(true);
        SimboluriBox.setDisable(true);
        refreshDataBttn.setDisable(true);
    }
    @FXML
    public void loadData(ActionEvent actionEvent) {
        try{
            service.ReadFromFile("inputFile.txt");
            SimbNeterminaleBttn.setDisable(false);
            SimbTerminaleBttn.setDisable(false);
            SimbStartBttn.setDisable(false);
            ProductiiBttn.setDisable(false);
            checkRegBttn.setDisable(false);
            searchProdBttn.setDisable(false);
            SimboluriBox.setDisable(false);
            refreshDataBttn.setDisable(false);
            ObservableList<String> Simboluri= FXCollections.observableArrayList();
            Simboluri.addAll(service.getListNeterminale());
            SimboluriBox.setItems(Simboluri);
        }catch (IOException ex){
            Alert msg=new Alert(Alert.AlertType.ERROR);
            msg.setHeaderText("Incarcarea datelor a esuat");
            msg.setContentText(ex.getMessage());
            msg.showAndWait();
        }
    }

    public void showSimbNeter(ActionEvent actionEvent) {
        showArea.setText(service.NonTerminale());
    }

    public void showSimbTer(ActionEvent actionEvent) {
        showArea.setText(service.Terminale());
    }

    public void showSimbStart(ActionEvent actionEvent) {
        showArea.setText(service.SimbStart());
    }

    public void showProductii(ActionEvent actionEvent) {
        showArea.setText(service.Productii());
    }

    public void clear(ActionEvent actionEvent) {
        showArea.setText("");
    }

    public void searchProductiiSimbol(ActionEvent actionEvent) {
        showArea.setText(service.getProductiiForSimbol(SimboluriBox.getValue()));
    }

    public void checkReg(ActionEvent actionEvent) {
            if(service.chechReg()){
                RegArea.setText("Gramatica regulara");
            }
            else RegArea.setText("Gramatica nu e regulara");
    }

    public void refreshData(ActionEvent actionEvent) {
        clear(actionEvent);
        service=new Service();
        try{
            service.ReadFromFile("inputFile.txt");
            ObservableList<String> Simboluri= FXCollections.observableArrayList();
            Simboluri.addAll(service.getListNeterminale());
            SimboluriBox.setItems(Simboluri);
        }catch (IOException ex){
            Alert msg=new Alert(Alert.AlertType.ERROR);
            msg.setHeaderText("Incarcarea datelor a esuat");
            msg.setContentText(ex.getMessage());
            msg.showAndWait();
        }
    }
}
