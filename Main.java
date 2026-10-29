import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Tip Calculator");

        TextField billField = new TextField();
        billField.setPromptText("Enter bill amount");

        ComboBox<Integer> tipBox = new ComboBox<>();
        tipBox.getItems().addAll(5, 10, 15, 20, 25);
        tipBox.setValue(15);

        Button button = new Button("Calculate Tip");
        Label result = new Label("Tip and Total");

        button.setOnAction(e -> {
            try {
                double bill = Double.parseDouble(
                    billField.getText()
                );
                double tip = bill * tipBox.getValue() / 100;
                double total = bill + tip;

                result.setText(String.format(
                    "Tip: %.2f | Total: %.2f", tip, total
                ));
            } catch (NumberFormatException ex) {
                result.setText("Enter a valid amount!");
            }
        });

        VBox root = new VBox(15, title, billField,
                tipBox, button, result);

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 25; -fx-font-size: 16px;");

        stage.setScene(new Scene(root, 350, 300));
        stage.setTitle("Tip Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
