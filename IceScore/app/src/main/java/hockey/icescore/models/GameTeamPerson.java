package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class GameTeamPerson {

    protected long id;
    protected long gameId;
    protected long teamId;
    protected long personId;
    protected long roleId;

    GameTeamPerson()
    {

    }

    GameTeamPerson(long gId, long tId, long pId, long rId)
    {
        this.gameId = gId;
        this.teamId = tId;
        this.personId = pId;
        this.roleId = rId;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getGameId() { return gameId; }

    public void setGameId(long gameId) { this.gameId = gameId; }

    public long getTeamId() { return teamId; }

    public void setTeamId(long teamId) { this.teamId = teamId; }

    public long getPersonId() { return personId; }

    public void setPersonId(long personId) { this.personId = personId; }

    public long getRoleId() { return roleId; }

    public void setRoleId(long roleId) { this.roleId = roleId; }
}
