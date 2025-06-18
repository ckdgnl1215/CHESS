package chess.chess.Board.Team;

import chess.chess.Board.Pieces.*;

public class OppositeTeam extends BWTeam {

    public OppositeTeam(String teamColor) {this.teamColor = teamColor; spanTeam(teamColor);}

    public void spanTeam(String teamColor) {
        for (int i = 0; i < 8; i++) {
            BM[i][1].setPiece(new Pawn().setPos(i, 1, teamColor).setTeam("opposite"));
            this.teamPieces.setPawn(BM[i][1]);
        }
        this.teamPieces.setRook(BM[0][0].setPiece(new Rook().setPos(0, 0, teamColor).setTeam("opposite")));
        this.teamPieces.setRook(BM[7][0].setPiece(new Rook().setPos(7, 0, teamColor).setTeam("opposite")));
        this.teamPieces.setKnight(BM[1][0].setPiece(new Knight().setPos(1, 0, teamColor).setTeam("opposite")));
        this.teamPieces.setKnight(BM[6][0].setPiece(new Knight().setPos(6, 0, teamColor).setTeam("opposite")));
        this.teamPieces.setBishop(BM[2][0].setPiece(new Bishop().setPos(2, 0, teamColor).setTeam("opposite")));
        this.teamPieces.setBishop(BM[5][0].setPiece(new Bishop().setPos(5, 0, teamColor).setTeam("opposite")));
        if (teamColor.equals("black")) {
            this.teamPieces.setQueen(BM[3][0].setPiece(new Queen().setPos(3, 0, teamColor).setTeam("opposite")));
            this.teamPieces.setKing(BM[4][0].setPiece(new King().setPos(4, 0, teamColor).setTeam("opposite")));
        }
        else if (teamColor.equals("white")) {
            this.teamPieces.setQueen(BM[4][0].setPiece(new Queen().setPos(4, 0, teamColor).setTeam("opposite")));
            this.teamPieces.setKing(BM[3][0].setPiece(new King().setPos(3, 0, teamColor).setTeam("opposite")));
        }
    }

    public void AutoClick(int[] Select, int[] Move) {
        BM[Select[0]][Select[1]].setSelected(true);
        BM[Move[0]][Move[1]].setSelected(true);
    }
}