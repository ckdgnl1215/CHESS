package chess.chess.Board;

import chess.chess.Board.Elements.BWPos;
import chess.chess.Board.Elements.GarbagePos;
import javafx.scene.layout.Pane;

public class Board {

    final static public BWPos[][] boardMatrix = new BWPos[8][8];
    public static BWPos garbagePos = new GarbagePos();
    public static BWPos nowFocused = garbagePos;
    public TeamColor Teams;
    public Board(Pane mainPane) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardMatrix[i][j] = new BWPos(80 * i, 80 * j, (i + j) % 2 == 0 ? "blackbutton" : "whitebutton", (i + j) % 2 == 0 ? "black" : "white");
                mainPane.getChildren().add(boardMatrix[i][j]);
            }
        }
    }
    public void spanTeams() {}
    public BWPos[][] getBoardMatrix() {return boardMatrix;}
}
