package hockey.icescore.models;

import android.graphics.Bitmap;

/**
 * Created by Josh on 21/04/2015.
 */
public class SignOff {

    protected long id;
    protected long gameId;
    protected long personId;
    protected Bitmap signature;

    public SignOff()
    {

    }

    public SignOff(long gId, long pId, Bitmap signature)
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

    public Bitmap getSignature() { return signature; }

    public void setSignature(Bitmap signature) { this.signature = signature; }
}
