import java.util.List;

/**
 * Adventurer POJO
 */

public class Adventurer
{
    String name;
    int age;
    String role;
    double goldEarned;
    List<Skills> skills;

    public Adventurer(String name, int age, String role, double goldEarned, List<Skills> skills)
    {
        this.name = name;
        this.age = age;
        this.role = role;
        this.goldEarned = goldEarned;
        this.skills = skills;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getRole()
    {
        return role;
    }

    public double getGoldEarned()
    {
        return goldEarned;
    }

    public List<Skills> getSkills()
    {
        return skills;
    }

    public void setName(String name)
    {
        if (!name.isEmpty())
            this.name = name;
    }

    public void setAge(int age)
    {
        if (age > 0)
            this.age = age;
    }

    public void setRole(String role)
    {
        if (!role.isEmpty())
            this.role = role;
    }

    public void setGoldEarned(double goldEarned)
    {
        if (goldEarned >= 0)
            this.goldEarned = goldEarned;
    }

    public void setSkills(List<Skills> skills)
    {
        if (!skills.isEmpty())
            this.skills = skills;
    }

    @Override
    public String toString()
    {
        String info;
        info = "Name: " + name + " Age: " + age + " Role: " + role + " Gold Earned: " + goldEarned + " Skills: " + skills;
        return info;
    }
}
