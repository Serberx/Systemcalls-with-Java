package at.spengergasse.systemcalls;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class DateTimeApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException{
        CreateDateViewAndUpdate setAndBuild = new CreateDateViewAndUpdate();
//        ProcessBuilder          processBuilder = new ProcessBuilder();

    }

    public static void main(String[] args){
        launch();
    }
}