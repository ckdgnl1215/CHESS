package chess.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Board.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        URL css = getClass().getResource("/css/boardstyle.css");
        if (css != null) {
            scene.getStylesheets().add(css.toExternalForm());
        } else {
            System.err.println("style.css 로딩 실패");
        }

        stage.setScene(scene);
        stage.show();
    }

    public static void Main(String[] args) {
        launch();
    }
}