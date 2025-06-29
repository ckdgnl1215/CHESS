package chess.chess.Board.Team;

import chess.chess.Board.Pieces.*;

public class MyTeam extends BWTeam {

    public MyTeam(String teamColor) {this.teamColor = teamColor; spanTeam(teamColor);}

    public void spanTeam(String teamColor) {
        for (int i = 0; i < 8; i++) {
            BM[i][6].setPiece(new Pawn().setPos(i, 6, teamColor).setTeam("my"));
            this.teamPieces.setPawn(BM[i][6]);
        }
        this.teamPieces.setRook(BM[0][7].setPiece(new Rook().setPos(0, 7, teamColor).setTeam("my")));
        this.teamPieces.setRook(BM[7][7].setPiece(new Rook().setPos(7, 7, teamColor).setTeam("my")));
        this.teamPieces.setKnight(BM[1][7].setPiece(new Knight().setPos(1, 7, teamColor).setTeam("my")));
        this.teamPieces.setKnight(BM[6][7].setPiece(new Knight().setPos(6, 7, teamColor).setTeam("my")));
        this.teamPieces.setBishop(BM[2][7].setPiece(new Bishop().setPos(2, 7, teamColor).setTeam("my")));
        this.teamPieces.setBishop(BM[5][7].setPiece(new Bishop().setPos(5, 7, teamColor).setTeam("my")));
        if (teamColor.equals("white")) {
            this.teamPieces.setQueen(BM[3][7].setPiece(new Queen().setPos(3, 7, teamColor).setTeam("my")));
            this.teamPieces.setKing(BM[4][7].setPiece(new King().setPos(4, 7, teamColor).setTeam("my")));
        }
        else if (teamColor.equals("black")) {
            this.teamPieces.setQueen(BM[4][7].setPiece(new Queen().setPos(4, 7, teamColor).setTeam("my")));
            this.teamPieces.setKing(BM[3][7].setPiece(new King().setPos(3, 7, teamColor).setTeam("my")));
        }
    }
}
