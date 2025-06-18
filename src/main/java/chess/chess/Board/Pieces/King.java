package chess.chess.Board.Pieces;

import java.util.ArrayList;

public class King extends Piece {

    public ArrayList<int[]> getAbleToMove() {
        result = new ArrayList<int[]>();
        for (int i = - 1; i < 2; i++) {
            for (int j = - 1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                this.result.add(new int[]{this.posX + i, this.posY + j});
            }
        }
        result.removeIf(pos -> ! ((0 <= pos[0]) && (pos[0] < 8)) || ! ((0 <= pos[1]) && (pos[1] < 8)));
        return result;
    }
    public King setTeam(String team) {this.Team = team; return this;}
}
