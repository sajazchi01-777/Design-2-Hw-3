import java.util.List;

/**
 * Guild POJO, contains list of Adventurer objects
 */

public class Guild
{
    String name;
    List<Adventurer> adventurers;

    public Guild(String name, List<Adventurer> adventurers)
    {
        this.name = name;
        this.adventurers = adventurers;
    }

    public String getName()
    {
        return name;
    }

    public List<Adventurer> getAdventurers()
    {
        return adventurers;
    }

    public void setName(String name)
    {
        if (!name.isEmpty())
            this.name = name;
    }

    public void setAdventurers(List<Adventurer> adventurers)
    {
        if (!adventurers.isEmpty())
            this.adventurers = adventurers;
    }

    @Override
    public String toString()
    {
        String info;
        info = "Name: " + name + " Members: " + adventurers;
        return info;
    }
}
