package chess.chess.Board.Team;

import java.util.ArrayList;

public abstract class BWTeam {

    protected Team teamColor;
    public static ArrayList<BWTeam> teamList = new ArrayList<BWTeam>();

    public abstract void spanTeam();

    public Team getTeamColor() {return teamColor;}

}
