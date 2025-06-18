package chess.chess.Board.Pieces;

import java.util.ArrayList;

public class Bishop extends Piece{
    public ArrayList<int[]> getAbleToMove() {
        result = new ArrayList<int[]>();
        Search(1, 1);
        Search(1, -1);
        Search(-1, 1);
        Search(-1, -1);
        for(int[] i : result) {
            System.out.print(i[0]);
            System.out.println(i[1]);
        }
        return result;
    }
    private void Search(int dx, int dy) {
        int i;
        int newX, newY;
        for(i = 1; i < 8; i++) {
            newX = this.posX + dx * i;
            newY = this.posY + dy * i;
            if(newX > 7 || newY > 7 || newX < 0 || newY < 0) {
                break;
            }
            else if (BM[newX][newY].getPiece() instanceof Garbage) {
                result.add(new int[]{newX, newY});
            }
            else if (!BM[newX][newY].getPiece().getTeamColor().equals(this.TeamColor)) {
                result.add(new int[]{newX, newY});
                break;
            }
            else {
                break;
            }
        }
    }
    public Bishop setTeam(String team) {this.Team = team; return this;}
}
