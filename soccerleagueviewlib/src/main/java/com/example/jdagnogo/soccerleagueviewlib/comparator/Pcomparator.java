package com.example.jdagnogo.soccerleagueviewlib.comparator;

import com.example.jdagnogo.soccerleagueviewlib.models.TeamInLeague;

import java.io.Serializable;
import java.util.Comparator;

public class Pcomparator implements Comparator<TeamInLeague>, Serializable {

    @Override
    public int compare(TeamInLeague o1, TeamInLeague o2) {
        int diff = o2.getNumberOfmatchLost() - o1.getNumberOfmatchLost();
        if (diff == 0) {
            return o2.getCurrentPoints() - o1.getCurrentPoints();
        }
        return diff;
    }
}
