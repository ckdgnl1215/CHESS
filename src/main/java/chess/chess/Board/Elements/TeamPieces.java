package chess.chess.Board.Elements;

import java.util.ArrayList;

public record TeamPieces(ArrayList<BWPos> pawn,
                         ArrayList<BWPos> rook,
                         ArrayList<BWPos> bishop,
                         ArrayList<BWPos> knight,
                         ArrayList<BWPos> queen,
                         ArrayList<BWPos> king) {
    public void setPawn(BWPos newPawn) {pawn.add(newPawn);}
    public void setRook(BWPos newRook) {rook.add(newRook);}
    public void setBishop(BWPos newBishop) {bishop.add(newBishop);}
    public void setKnight(BWPos newKnight) {knight.add(newKnight);}
    public void setQueen(BWPos newQueen) {queen.add(newQueen);}
    public void setKing(BWPos newKing) {knight.add(newKing);}
}
