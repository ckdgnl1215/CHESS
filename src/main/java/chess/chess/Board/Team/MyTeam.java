package chess.chess.Board.Team;

import chess.chess.Board.Pieces.*;

public class MyTeam extends BWTeam {

    public Team teamColor;
    public MyTeam() {    }

    @Override
    public void spanWhiteTeam() {
        for (int i = 0; i < 8; i++) {
            BM[i][6].setPiece(new Pawn().setPos(i, 6));
            this.teamPiece.add(BM[i][6]);
        }
        BM[0][7].setPiece(new Rook().setPos(0, 7));
        BM[7][7].setPiece(new Rook().setPos(7, 7));
        BM[1][7].setPiece(new Knight().setPos(0, 7));
        BM[6][7].setPiece(new Knight().setPos(7, 7));
        BM[2][7].setPiece(new Bishop().setPos(0, 7));
        BM[5][7].setPiece(new Bishop().setPos(7, 7));
        BM[3][7].setPiece(new Queen().setPos(3, 7));
        BM[4][7].setPiece(new King().setPos(4, 7));
    }
}
