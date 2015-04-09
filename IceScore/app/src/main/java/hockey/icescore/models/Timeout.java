package hockey.icescore.models;

/**
 * Created by Josh on 7/04/2015.
 */
public class Timeout {

    protected long id;
    protected long teamId;
    protected long gameId;
    protected String timestamp;

    public Timeout()
    {
    }

    public Timeout(long tId, long gId, String timestamp)
    {
        this.teamId = tId;
        this.gameId = gId;
        this.timestamp = timestamp;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getTeamId() { return teamId; }

    public void setTeamId(long teamId) { this.teamId = teamId; }

    public long getGameId() { return gameId; }

    public void setGameId(long gameId) { this.gameId = gameId; }

    public String getTimestamp() { return timestamp; }

    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
