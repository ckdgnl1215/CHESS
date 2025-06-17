package chess.chess.Board.Team;

import chess.chess.Board.Board;
import chess.chess.Board.Elements.BWPos;
import chess.chess.Board.Elements.TeamPieces;
import chess.chess.Board.Pieces.*;

import java.util.ArrayList;

public abstract class BWTeam {

    protected String teamColor;
    protected TeamPieces teamPieces = new TeamPieces(new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>());
    protected BWPos[][] BM = Board.boardMatrix;

    public abstract void spanTeam(String teamColor);

    public void resetTeam() {
        teamPieces.pawn().clear();
        teamPieces.rook().clear();
        teamPieces.bishop().clear();
        teamPieces.knight().clear();
        teamPieces.queen().clear();
        teamPieces.king().clear();
    }

    public String getTeamColor() {return teamColor;}

}
