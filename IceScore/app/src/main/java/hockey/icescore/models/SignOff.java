package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class SignOff {

    protected long id;
    protected long gameId;
    protected long personId;
    protected String signature;

    public SignOff()
    {

    }

    public SignOff(long gId, long pId, String signature)
    {
        this.gameId = gId;
        this.personId = pId;
        this.signature = signature;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getGameId() { return gameId; }

    public void setGameId(long gameId) { this.gameId = gameId; }

    public long getPersonId() { return personId; }

    public void setPersonId(long personId) { this.personId = personId; }

    public String getSignature() { return signature; }

    public void setSignature(String signature) { this.signature = signature; }
}
