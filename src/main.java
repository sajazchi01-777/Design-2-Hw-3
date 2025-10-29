import java.util.*;
import java.util.stream.Collectors;

public class main
{
    /**
     * Method that filters Adventurers by a given skill.
     */
    public static List<Adventurer> filterAdventurersBySkill(List<Guild> guilds, Skills s)
    {
        return guilds.stream() //turns guilds list into stream//
                .flatMap(g -> g.getAdventurers().stream()) //flatmaps the stream and becomes a stream of adventurers//
                .filter(p -> p.getSkills().contains(s)) //filters the adventurers by their skill//
                .collect(Collectors.toList()); //collects the adventurers into a list//
    }

    /**
     * Method that groups adventurers by their roles.
     */

    public static void groupAdventurersByRole(List<Guild> guilds)
    {
        Map<String, List<Adventurer>> groups = guilds.stream() //turns list of guilds into a stream//
                .flatMap(g -> g.getAdventurers().stream()) //flatmaps the stream and becomes a stream of adventurers//
                .collect(Collectors.groupingBy(Adventurer::getRole)); //collects the adventurers and groups them by their role//

        System.out.println(groups); //prints out the groups//
    }

    /**
     * Method that finds adventurer with most skills.
     */

    public static Optional<Adventurer> findAdventurerWithMostSkills(List<Guild> guilds)
    {
        return guilds.stream() //turns guild list into stream//
                .flatMap(g -> g.getAdventurers().stream()) //flatmaps the stream into a stream of adventurers//
                .max(Comparator.comparingInt(a -> a.getSkills().size())); //compares size of list of skills between adventurers//
    }

    /**
     * Method that ranks guilds by average adventurer age.
     */

    public static List<Guild> rankGuildsByAverageAdventurerAge(List<Guild> guilds)
    {
        return guilds.stream() //turns guild list into stream//
                .sorted(Comparator.comparingInt(g -> g.getAdventurers().stream() //gets the stream of adventurers//
                        .mapToInt(Adventurer::getAge) //gets the age of each adventurer//
                        .sum() //sums the ages//
                        / g.getAdventurers().size() //gets average by dividing the sum of all ages by dividing the number of adventurers in the guild//
                ))
                .collect(Collectors.toList()); //collects average in a list//
    }

    /**
     * Method that prints a map of a skill and adventurers proficient in that skill.
     */

    public static void skillWiseAdventurerCountMap(List<Guild> guilds)
    {
        Map<String, Long> skillCount = guilds.stream() //Turns list of guilds into stream//
                .flatMap(g -> g.getAdventurers().stream()) //turns stream of guilds into stream of adventurers//
                .flatMap(a -> a.getSkills().stream()) //turns stream of adventurers into stream of skills//
                .collect(Collectors.groupingBy(Skills::name, Collectors.counting())); //groups by skill name, counts how many adventurers have said skill//

        System.out.println(skillCount); //displays skill count//
    }

    /**
     * Method that gives bonus gold to adventurers with less than 1000 gold.
     */

    public static void bonusGoldEvent(List<Guild> guilds)
    {
        guilds.stream() //list to stream//
                .flatMap(g -> g.getAdventurers().stream()) //guild stream to adventurer stream//
                .filter(a -> a.getGoldEarned() < 1000) //filters adventurers whose gold is less than 1000//
                .forEach(a -> {
                    a.setGoldEarned(a.getGoldEarned() * 1.2); //for each adventurer whose gold is less than 1000, adds 20% more gold//
                    System.out.println(a.getName() + " now has " + a.getGoldEarned() + " gold."); //displays updated list//
                });
    }

}
