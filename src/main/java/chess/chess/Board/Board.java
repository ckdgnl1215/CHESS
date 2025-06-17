package chess.chess.Board;

import chess.chess.Board.Elements.BWPos;
import chess.chess.Board.Elements.GarbagePos;
import chess.chess.Board.Team.MyTeam;
import chess.chess.Board.Team.OppositeTeam;
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
    public void spanTeams(String myColor) {
        this.Teams = new TeamColor(new MyTeam(myColor.equals("black") ? "black" : "white"), new OppositeTeam(myColor.equals("black") ? "black" : "white"));
    }
    public void swapTeams() {
        this.Teams.SwapColor();
    }

    public BWPos[][] getBoardMatrix() {return boardMatrix;}
}
