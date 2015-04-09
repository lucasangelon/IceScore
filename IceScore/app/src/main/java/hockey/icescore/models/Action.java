package hockey.icescore.models;

/**
 * Created by Lucas Angelon on 09-Apr-15.
 */
public class Action
{
    protected long id;
    protected String name;

    public Action(String name)
    {
        this.name = name;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
