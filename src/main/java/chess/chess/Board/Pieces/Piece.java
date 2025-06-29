package chess.chess.Board.Pieces;

import chess.chess.Board.Board;
import chess.chess.Board.Elements.BWPos;

import java.util.ArrayList;

public abstract class Piece {
    protected BWPos[][] BM = Board.boardMatrix;
    protected int posX, posY;
    protected String TeamColor;
    public String Team;
    public boolean Moved;
    protected ArrayList<int[]> result = new ArrayList<>();

    public Piece setPos(int xPos, int yPos) {
        this.posX = xPos;
        this.posY = yPos;
        return this;
    }

    public Piece setPos(int xPos, int yPos, String teamColor) {
        this.posX = xPos;
        this.posY = yPos;
        this.TeamColor = teamColor;
        return this;
    }

    public Piece setMoved() {this.Moved = true; return this;}

    public String getTeamColor() {return this.TeamColor;}

    public abstract Piece setTeam(String team);

    public abstract ArrayList<int[]> getAbleToMove();
}
