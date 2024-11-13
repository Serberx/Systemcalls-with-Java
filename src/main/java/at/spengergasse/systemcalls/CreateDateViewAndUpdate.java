package at.spengergasse.systemcalls;

import at.spengergasse.systemcalls.domain.DateTimeCall;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateDateViewAndUpdate{

    DateTimeCall dc       = new DateTimeCall();
    String       locDate  = dc.getLocDate();
    String       locTime  = dc.getLocTime();
    String       geoData  = dc.getGeoData();
    String       language = dc.getLanguage();

    ObservableList<String> ol      = FXCollections.observableArrayList(locDate,
                                                                       locTime,
                                                                       geoData,
                                                                       language);
    ListView<String>       sysList = new ListView<>(ol);

    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    TextField tf3 = new TextField();
    TextField tf4 = new TextField();

    Button btn1      = new Button("Aktualisieren");
    Label  labelDate = new Label("Date: ");
    Label  labelTime = new Label("Time: ");
    Label  labelGeo  = new Label("Geo: ");
    Label  labelLang = new Label("Language: ");

    public CreateDateViewAndUpdate(){
        initView();
        actions();
    }

    public void initView(){
        tf1.setPrefWidth(200);
        
        //        TextField tf1 = new TextField(sysList.getItems().get(0));
        tf1.setText(sysList.getItems()
                           .get(0));
        tf1.setPadding(new Insets(5,
                                  0,
                                  5,
                                  0));
        tf1.setDisable(true);

        //        TextField tf2 = new TextField(sysList.getItems().get(1));
        tf2.setText(sysList.getItems()
                           .get(1));
        tf2.setPadding(new Insets(5,
                                  0,
                                  5,
                                  0));
        tf2.setDisable(true);

        //        TextField tf3 = new TextField(sysList.getItems().get(2));
        tf3.setText(sysList.getItems()
                           .get(2));
        tf3.setPadding(new Insets(5,
                                  0,
                                  5,
                                  0));
        tf3.setDisable(true);

        //        TextField tf4 = new TextField(sysList.getItems().get(3));
        tf4.setText(sysList.getItems()
                           .get(3));
        tf4.setPadding(new Insets(5,
                                  0,
                                  5,
                                  0));
        tf4.setDisable(true);

        Stage stage1 = new Stage();
        stage1.setWidth(320);
        stage1.setHeight(290);

        VBox root2 = new VBox(labelDate,
                              tf1,
                              labelTime,
                              tf2,
                              labelGeo,
                              tf3,
                              labelLang,
                              tf4);
        root2.setAlignment(Pos.TOP_LEFT);
        HBox root1 = new HBox(root2,
                              btn1);
        root1.setAlignment(Pos.BOTTOM_LEFT);
        root1.setPadding(new Insets(0,0,10,0));
        root2.setPadding(new Insets(5,0,0,10));

        btn1.setPrefSize(100,
                         20);
                btn1.setAlignment(Pos.TOP_CENTER);


        //        root2.getChildren().add(labelDate);
        //        root2.getChildren().add(tf1);
        //        root2.getChildren().add(labelTime);
        //        root2.getChildren().add(tf2);
        //        root2.getChildren().add(labelGeo);
        //        root2.getChildren().add(tf3);
        //        root2.getChildren().add(labelLang);
        //        root2.getChildren().add(tf4);


        //        root1.getChildren().addAll(root2,btn1);

        Scene scene1 = new Scene(root1,
                                 320,
                                 240);
//        scene1.getStylesheets().add("src/main/at/spengergasse/ TextfieldChanges.css");

        stage1.setTitle("Labor NVS");
        stage1.setScene(scene1);
        stage1.show();


    }

    public void actions(){
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                //                initView();
                onAction();

            }
        });
    }


    private void onAction(){
        dc       = new DateTimeCall();
        locDate  = dc.getLocDate();
        locTime  = dc.getLocTime();
        geoData  = dc.getGeoData();
        language = dc.getLanguage();

        //        ol = FXCollections.observableArrayList(locDate, locTime, geoData, language);
        //        sysList = new ListView<String>(ol);

        tf1.setText(locDate);
        //        tf1.setPadding(new Insets(5,0,5,0));
        tf2.setText(locTime);
        //        tf1.setPadding(new Insets(5,0,5,0));
        tf3.setText(geoData);
        //        tf1.setPadding(new Insets(5,0,5,0));
        tf4.setText(language);
        //        tf1.setPadding(new Insets(5,0,5,0));

        //        Stage stage1 = new Stage();
        //        HBox root1 = new HBox();
        //        VBox root2 = new VBox();
        //
        //        btn1.setPrefSize(100,20);
        //
        //
        //        root2.getChildren().add(labelDate);
        //        root2.getChildren().add(tf1);
        //        root2.getChildren().add(labelTime);
        //        root2.getChildren().add(tf2);
        //        root2.getChildren().add(labelGeo);
        //        root2.getChildren().add(tf3);
        //        root2.getChildren().add(labelLang);
        //        root2.getChildren().add(tf4);
        //        root2.setAlignment(Pos.TOP_LEFT);
        //
        //
        //        root1.getChildren().addAll(root2,btn1);
        //        root1.setAlignment(Pos.BOTTOM_LEFT);
        //
        //        Scene scene1 = new Scene(root1, 320,240);
        //
        //        stage1.setTitle("Labor NVS");
        //        stage1.setScene(scene1);
        //        stage1.show();

        //        initView();
    }
}
