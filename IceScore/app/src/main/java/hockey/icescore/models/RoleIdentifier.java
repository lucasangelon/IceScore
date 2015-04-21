package hockey.icescore.models;

/**
 * Created by 041402463 on 21/04/2015.
 */
public class RoleIdentifier {

    protected long id;
    protected long roleId;
    protected long identifierId;

    public RoleIdentifier()
    {

    }

    public RoleIdentifier(long rId, long iId)
    {
        this.roleId = rId;
        this.identifierId = iId;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getRoleId() { return roleId; }

    public void setRoleId(long roleId) { this.roleId = roleId; }

    public long getIdentifierId() { return identifierId; }

    public void setIdentifierId(long identifierId) { this.identifierId = identifierId; }
}
