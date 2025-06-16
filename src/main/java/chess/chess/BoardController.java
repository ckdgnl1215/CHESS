package chess.chess;

import chess.chess.Board.Board;
import chess.chess.Board.Elements.BWPos;
import chess.chess.Board.Pieces.*;
import chess.chess.Board.Team.MyTeam;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {
    @FXML public Pane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle RsBnd)  {
        Board chessBoard = new Board(mainPane);

        BWPos[][] boardMatrix = chessBoard.getBoardMatrix();

        MyTeam myTeam = new  MyTeam("black");
        myTeam.resetTeam();
        myTeam.spanTeam("white");
    }
}