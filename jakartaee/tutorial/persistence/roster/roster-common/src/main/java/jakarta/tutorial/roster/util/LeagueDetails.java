package jakarta.tutorial.roster.util;

import java.io.Serializable;


public class LeagueDetails implements Serializable {
    private static final long serialVersionUID = 290368886584321980L;
    private String id;
    private String name;
    private String sport;

    public LeagueDetails(String id, String name, String sport) {

        this.id = id;
        this.name = name;
        this.sport = sport;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }

    @Override public String toString() {
        String s = id + " " + name + " " + sport;
        return s;
    }

}
