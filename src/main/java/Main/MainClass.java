package Main;

import Entities.Simbol;
import Entities.TIPSimbol;
import Service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try{
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));
            Scene MainScene = new Scene(root);
            stage.setScene(MainScene);
            stage.setTitle("Welcome");
            stage.show();
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
}
