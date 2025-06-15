module chess.chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;


    opens chess.chess to javafx.fxml;
    exports chess.chess;
}