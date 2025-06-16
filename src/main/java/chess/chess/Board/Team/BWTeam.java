package chess.chess.Board.Team;

import chess.chess.Board.Board;
import chess.chess.Board.Elements.BWPos;
import chess.chess.Board.Pieces.*;

import java.util.ArrayList;

public abstract class BWTeam {

    protected Team teamColor;
    protected ArrayList<BWPos> teamPiece = new ArrayList<BWPos>();
    public static ArrayList<BWTeam> teamList = new ArrayList<BWTeam>();
    protected BWPos[][] BM = Board.boardMatrix;

    public abstract void spanWhiteTeam();

    public Team getTeamColor() {return teamColor;}

}
