package chess.chess.Board.Pieces;

import java.util.ArrayList;

public class Pawn extends Piece{

    public ArrayList<int[]> getAbleToMove() {
        result = new ArrayList<int[]>();
        result.add(new int[]{this.posX, this.posY - 1});
        result.removeIf(pos -> ! ((0 <= pos[0]) && (pos[0] < 8)) || ! ((0 <= pos[1]) && (pos[1] < 8)));
        return result;
    }

}
