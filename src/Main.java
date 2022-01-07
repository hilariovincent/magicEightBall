import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

import javax.swing.plaf.basic.BasicTreeUI;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();

        double gridSize = 700;
        double sixthOfGrid = gridSize / 6;
        double thirdOfGrid = gridSize / 3;

        gridPane.setMinHeight(gridSize);
        gridPane.setMinWidth(gridSize);

        //for the 8ball itself
        StackPane ballStack = new StackPane();

        /**
         * three vars are the components to add to the ballStack
         * still need to replace the rectangle with a proper triangle
         * to replicate an actual magic 8Ball
         */
        Circle outerCircle = new Circle(thirdOfGrid, Color.BLACK);
        Circle innerCircle = new Circle(sixthOfGrid, Color.DARKGRAY);
        Rectangle rect = new Rectangle(gridSize / 5, gridSize / 5, Color.PURPLE);
//        Polygon triangle = Triangle.createTriangle(innerCircle.getCenterX(), innerCircle.getCenterY(),
//                (Math.sqrt(3) * innerCircle.getRadius()));



        ballStack.getChildren().addAll(outerCircle, innerCircle, rect);

        gridPane.add(ballStack, 0, 0);
        gridPane.setAlignment(Pos.CENTER);

        //VBox is used to put the text field and button
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(8);

        Text text = new Text("Enter a yes/no question below: ");
        text.setFont(Font.font("verdana"));
        text.setFill(Color.WHITE);

        //User enters question here
        TextField textField = new TextField();

        //User clicks button to predict fortune for them
        Button predictButton = new Button("Predict!");

        vBox.getChildren().addAll(text, textField, predictButton);

        gridPane.add(vBox, 0, 1);
        gridPane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));


        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        predictButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!textField.getText().equals("")) {

                    ballStack.getChildren().clear();
                    new Ball(ballStack, gridSize);

                    textField.clear();
                }

            }
        });

    }
}
