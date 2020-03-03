package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox farba = new HBox();
        HBox znaky = new HBox();
        Group root = new Group();
        Scene scena = new Scene(root, 500, 400);

        Button but = new Button("Zmen pozadie");
        TextField text = new TextField("Real PlaceHolder :P");
        farba.setSpacing(10.0);farba.setLayoutY(5.0);farba.setLayoutX(scena.getWidth()/3.5);
        znaky.setLayoutX(80.0);znaky.setLayoutY(100.0);znaky.setSpacing(25.0);
        but.setOnAction(actionEvent -> {
            String txt = text.getText();
            int samo = 0,spolu = 0;
            int r = 0,g = 0,b = 0;
            for(int i = 0;i < txt.length();i++){
                if(txt.charAt(i) == 'a' || txt.charAt(i) == 'e' || txt.charAt(i) == 'i'
                        || txt.charAt(i) == 'o' || txt.charAt(i) == 'u') samo++;
                else spolu++;
            }
            if(samo*16<255)r = samo*16;
            else r = 255;
            if(spolu*24<255)g = spolu*24;
            else g = 255;
            if((txt.length()%25)*10<255)b = (txt.length()%25)*10;
            else b = 255;
            scena.setFill(Color.rgb(r,g,b));
            text.setText(" ");
        });

        Polyline l1 = new Polyline();
        l1.getPoints().addAll(new Double[]{12.0,8.0,17.0,3.0,3.0,3.0,17.0,19.0,3.0,19.0,7.0,14.0});
        l1.setStroke(Color.PURPLE);

        Polyline l2 = new Polyline();
        l2.getPoints().addAll(new Double[]{48.0,8.0,53.0,8.0,56.0,3.0,39.0,3.0,47.0,18.0,50.0,14.0});
        l2.setStroke(Color.YELLOW);

        Polyline l3 = new Polyline();
        l3.getPoints().addAll(new Double[]{86.0,3.0,77.0,19.0,94.0,19.0,89.0,10.0});
        l3.setStroke(Color.RED);

        Polyline l4 = new Polyline();
        l4.getPoints().addAll(new Double[]{132.0,3.0,115.0,3.0,123.0,18.0,129.0,9.0});
        l4.setStroke(Color.GREEN);

        Polyline l5 = new Polyline();
        l5.getPoints().addAll(new Double[]{159.0,8.0,162.0,3.0,170.0,19.0,153.0,19.0,156.0,13.0,161.0,13.0});
        l5.setStroke(Color.CYAN);

        scena.setFill(Color.rgb(1,1,1));
        znaky.getChildren().addAll(l1,l2,l3,l4,l5);
        farba.getChildren().addAll(text,but);
        root.getChildren().addAll(farba,znaky);
        primaryStage.setTitle("Witcher znaky + Farba pozadia");
        primaryStage.setScene(scena);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
