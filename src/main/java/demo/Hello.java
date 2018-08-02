package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            getChildren().add(createLink());
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    private Hyperlink createLink() {
        String url = "http://github.com";
        return new Hyperlink() {{
            setText(url);
            setOnAction(e -> {
                System.out.println("This link is clicked");
                openInBrowser(url);
            });
        }};
    }

    private void openInBrowser(String url) {
        getHostServices().showDocument(url);
    }

}