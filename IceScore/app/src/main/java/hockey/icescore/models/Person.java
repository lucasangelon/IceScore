package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class Person {

    protected long id;
    protected String name;
    protected long identifierId;

    public Person()
    {

    }

    public Person(String name, long iId)
    {
        this.name = name;
        this.identifierId = iId;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public long getIdentifierId() { return identifierId; }

    public void setIdentifierId(long identifierId) { this.identifierId = identifierId; }
}
