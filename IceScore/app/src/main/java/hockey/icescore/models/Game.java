package hockey.icescore.models;

/**
 * Created by Josh on 22/04/2015. Most Likely need to be edited later
 */
public class Game {

    protected long id;
    protected long venueId;
    protected long homeTeamId;
    protected long awayTeamId;
    protected long homeTeamManagerId;
    protected long awayTeamManagerId;
    protected long refereeId;
    protected long linesmanId;
    protected long linesman2Id;
    protected long scorekeeperId;
    protected String date;

    public Game()
    {

    }

    public Game(long vId, long htId, long atId, long htmId, long atmId, long rId,
                long lId, long l2Id, long sId, String date)
    {
        this.venueId = vId;
        this.homeTeamId = htId;
        this.awayTeamId = atId;
        this.homeTeamManagerId = htmId;
        this.awayTeamManagerId = atmId;
        this.refereeId = rId;
        this.linesmanId = lId;
        this.linesman2Id = l2Id;
        this.scorekeeperId = sId;
        this.date = date;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getVenueId() { return venueId; }

    public void setVenueId(long venueId) { this.venueId = venueId; }

    public long getHomeTeamId() { return homeTeamId; }

    public void setHomeTeamId(long homeTeamId) { this.homeTeamId = homeTeamId; }

    public long getAwayTeamId() { return awayTeamId; }

    public void setAwayTeamId(long awayTeamId) { this.awayTeamId = awayTeamId; }

    public long getHomeTeamManagerId() { return homeTeamManagerId; }

    public void setHomeTeamManagerId(long homeTeamManagerId)
    { this.homeTeamManagerId = homeTeamManagerId; }

    public long getAwayTeamManagerId() { return awayTeamManagerId; }

    public void setAwayTeamManagerId(long awayTeamManagerId)
    { this.awayTeamManagerId = awayTeamManagerId; }

    public long getRefereeId() { return refereeId; }

    public void setRefereeId(long refereeId) { this.refereeId = refereeId; }

    public long getScorekeeperId() { return scorekeeperId; }

    public void setScorekeeperId(long scorekeeperId) { this.scorekeeperId = scorekeeperId; }

    public long getLinesman2Id() { return linesman2Id; }

    public void setLinesman2Id(long linesman2Id) { this.linesman2Id = linesman2Id; }

    public long getLinesmanId() { return linesmanId; }

    public void setLinesmanId(long linesmanId) { this.linesmanId = linesmanId; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}
