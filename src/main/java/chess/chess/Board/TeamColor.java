package chess.chess.Board;

import chess.chess.Board.Team.BWTeam;

public record TeamColor(BWTeam MyTeam, BWTeam OppositeTeam) {
    public void SwapColor() {
        String temp1 = MyTeam.getTeamColor();
        String temp2 = OppositeTeam.getTeamColor();
        MyTeam.resetTeam();
        OppositeTeam.resetTeam();
        OppositeTeam.spanTeam(temp1);
        MyTeam.spanTeam(temp2);
    }
}
