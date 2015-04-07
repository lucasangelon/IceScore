package hockey.icescore.OldClasses;

public class Goalie extends Player
{

    public int shots;
    public int saves;

    public Goalie(int id, String name, int num)
    {
        super(id,name,num);
        shots = 0;
        saves = 0;
    }
}

