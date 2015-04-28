package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class TeamPersonNumber {

    protected long id;
    protected long teamId;
    protected long personId;
    protected String number;

    TeamPersonNumber()
    {

    }

    TeamPersonNumber(long tId, long pId, String number)
    {
        this.teamId = tId;
        this.personId = pId;
        this.number = number;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getTeamId() { return teamId; }

    public void setTeamId(long teamId) { this.teamId = teamId; }

    public long getPersonId() { return personId; }

    public void setPersonId(long personId) { this.personId = personId; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }
}
