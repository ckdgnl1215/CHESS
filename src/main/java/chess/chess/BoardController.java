package chess.chess;

import chess.chess.Board.Board;
import chess.chess.Board.Elements.BWPos;
import chess.chess.Board.Pieces.*;
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

        boardMatrix[1][1].setPiece(new King().setPos(1, 1));
        boardMatrix[1][2].setPiece(new Queen().setPos(1, 2));
        boardMatrix[1][3].setPiece(new Rook().setPos(1, 3));
        boardMatrix[1][4].setPiece(new Bishop().setPos(1, 4));
        boardMatrix[1][5].setPiece(new Knight().setPos(1, 5));
        boardMatrix[1][6].setPiece(new Pawn().setPos(1, 6));
    }
}