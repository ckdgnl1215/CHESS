package chess.chess.Board.Pieces;

import java.util.ArrayList;

public class Knight extends Piece {

    public ArrayList<int[]> getAbleToMove() {
        result = new ArrayList<>();
        int[][] deltas = {
                {2, 1}, {2, -1}, {1, 2}, {-1, 2},
                {-2, 1}, {-2, -1}, {1, -2}, {-1, -2}
        };

        for (int[] d : deltas) {
            int newX = this.posX + d[0];
            int newY = this.posY + d[1];
            if (0 <= newX && newX < 8 && 0 <= newY && newY < 8) {
                result.add(new int[]{newX, newY});
            }
        }
        return result;
    }

}
