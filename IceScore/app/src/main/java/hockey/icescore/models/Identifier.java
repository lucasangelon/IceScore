package hockey.icescore.models;

/**
 * Created by Josh on 21/04/2015.
 */
public class Identifier {

    protected long id;
    protected String name;

    public Identifier()
    {

    }

    public Identifier(String name)
    {
        this.name = name;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
