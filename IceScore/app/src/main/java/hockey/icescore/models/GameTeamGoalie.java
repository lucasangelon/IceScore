package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class GameTeamGoalie {

    protected long id;
    protected long personId;
    protected long gameId;
    protected long teamId;
    protected String timestamp;

    public GameTeamGoalie()
    {

    }

   public GameTeamGoalie(long pId, long gId, long tId, String timestamp)
    {
        this.personId = pId;
        this.gameId = gId;
        this.teamId = tId;
        this.timestamp = timestamp;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getPersonId() { return personId; }

    public void setPersonId(long personId) { this.personId = personId; }

    public long getTeamId() { return teamId; }

    public void setTeamId(long teamId) { this.teamId = teamId; }

    public long getGameId() { return gameId; }

    public void setGameId(long gameId) { this.gameId = gameId; }

    public String getTimestamp() { return timestamp; }

    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
