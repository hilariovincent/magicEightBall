import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Ball {
    private final StackPane stackPane;
    private String eightBall = "";
    private final double spaceSize;


    public Ball(StackPane stackPane, double spaceSize) {
        this.stackPane = stackPane;
        this.spaceSize = spaceSize;

        draw8Ball();
    }

    /**
     * Draws the new ball after user inputs a question in the text field.
     */
    public void draw8Ball() {
        Circle outerCircle = new Circle(spaceSize / 3, Color.BLACK);
        Circle innerCircle = new Circle(spaceSize / 6, Color.DARKGRAY);
        Rectangle rect = new Rectangle(spaceSize / 5, spaceSize / 5, Color.PURPLE);

        logic();

        Text text = new Text(eightBall);
        text.setFont(Font.font("verdana"));
        text.setFill(Color.WHITE);

        stackPane.getChildren().addAll(outerCircle, innerCircle, rect, text);
    }

    /**
     * Randomly generates answers for the magic 8Ball
     * uses only 10 answers
     */
    public void logic() {
        double randomNumber = Math.floor(Math.random() * 11);
        switch ((int) randomNumber) {
            case 0 -> eightBall = "It is certain";
            case 1 -> eightBall = "It is decidedly so";
            case 2 -> eightBall = "Reply hazy try again";
            case 3 -> eightBall = "Cannot predict now";
            case 4 -> eightBall = "Do not count on it";
            case 5 -> eightBall = "My sources say no";
            case 6 -> eightBall = "Outlook not so good";
            case 7 -> eightBall = "Signs point to yes";
            case 8 -> eightBall = "Focus and ask again";
            case 9 -> eightBall = "There's a 50/50 chance";
            case 10 -> eightBall = "Straight up, no <3";
        }
    }


}
