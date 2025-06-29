package chess.chess.Board.Pieces;

import java.util.ArrayList;

public class Pawn extends Piece{
    public ArrayList<int[]> getAbleToMove() {
        result = new ArrayList<int[]>();
        if (this.Moved) {
            if (this.Team.equals("my")) {
                result.add(new int[]{this.posX, this.posY - 1});
            } else if (this.Team.equals("opposite")) {
                result.add(new int[]{this.posX, this.posY + 1});
            }
        }
        else {
            if (this.Team.equals("my")) {
                result.add(new int[]{this.posX, this.posY - 1});
                result.add(new int[]{this.posX, this.posY - 2});
            } else if (this.Team.equals("opposite")) {
                result.add(new int[]{this.posX, this.posY + 1});
                result.add(new int[]{this.posX, this.posY + 2});
            }
        }
        result.removeIf(pos -> ! ((0 <= pos[0]) && (pos[0] < 8)) || ! ((0 <= pos[1]) && (pos[1] < 8)));
        return result;
    }
    public Pawn setTeam(String team) {this.Team = team; return this;}
}
