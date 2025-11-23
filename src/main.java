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

    /**
     * Main, runs the methods above
     * @param args
     */

    public static void main(String[] args)
    {
        /**
         * List of adventurers, as well as some random adventurer objects which are added to the array list
         */

        List<Adventurer> adventurers1 = new ArrayList<>();


        adventurers1.add(new Adventurer(
                "Thorin Ironfist",
                35,
                "Warrior",
                250.0,
                List.of(Skills.SWORDSMANSHIP, Skills.HORSEMANSHIP, Skills.BLACKSMITHING)
        ));

        adventurers1.add(new Adventurer(
                "Elira Moonwhisper",
                28,
                "Wizard",
                540.5,
                List.of(Skills.RUNECRAFTING, Skills.HEALING)
        ));

        adventurers1.add(new Adventurer(
                "Silas Quickstep",
                22,
                "Rogue",
                310.25,
                List.of(Skills.THIEVERY, Skills.STEALTH, Skills.ARCHERY)
        ));

        adventurers1.add(new Adventurer(
                "Marwyn Starseer",
                41,
                "Wizard",
                890.0,
                List.of(Skills.NECROMANCY, Skills.RUNECRAFTING)
        ));

        adventurers1.add(new Adventurer(
                "Rowan Hawkeye",
                30,
                "Ranger",
                415.75,
                List.of(Skills.ARCHERY, Skills.STEALTH, Skills.HORSEMANSHIP)
        ));

        adventurers1.add(new Adventurer(
                "Brakka Stoneforge",
                50,
                "Blacksmith",
                150.0,
                List.of(Skills.BLACKSMITHING, Skills.SWORDSMANSHIP)
        ));

        adventurers1.add(new Adventurer(
                "Liora Dawnsong",
                33,
                "Cleric",
                605.80,
                List.of(Skills.HEALING, Skills.RUNECRAFTING)
        ));

        adventurers1.add(new Adventurer(
                "Vex the Meme Lord",
                19,
                "Bard",
                9999.99,
                List.of(Skills.MEMECRAFTING, Skills.STEALTH)
        ));

        adventurers1.add(new Adventurer(
                "Drazhul the Pale",
                67,
                "Necromancer",
                1200.0,
                List.of(Skills.NECROMANCY, Skills.RUNECRAFTING)
        ));

        adventurers1.add(new Adventurer(
                "Kaela Swiftwind",
                26,
                "Rogue",
                455.40,
                List.of(Skills.STEALTH, Skills.THIEVERY, Skills.ARCHERY)
        ));

        /**
         * Adding the list of adventurers to the newly created Guild object
         */

        Guild g1 = new Guild("Astralis", adventurers1);

        /**
         * Creating a second list of adventurer objects
         */

        List<Adventurer> adventurers2 = new ArrayList<>();

        adventurers2.add(new Adventurer(
                "Garruk Bearbreaker",
                39,
                "Warrior",
                330.0,
                List.of(Skills.SWORDSMANSHIP, Skills.HORSEMANSHIP)
        ));

        adventurers2.add(new Adventurer(
                "Seraphine Willowglen",
                24,
                "Wizard",
                720.0,
                List.of(Skills.HEALING, Skills.RUNECRAFTING)
        ));

        adventurers2.add(new Adventurer(
                "Nox Shadowstep",
                29,
                "Rogue",
                498.2,
                List.of(Skills.STEALTH, Skills.THIEVERY)
        ));

        adventurers2.add(new Adventurer(
                "Alrik Stoneshield",
                45,
                "Guardian",
                275.5,
                List.of(Skills.SWORDSMANSHIP, Skills.BLACKSMITHING)
        ));

        adventurers2.add(new Adventurer(
                "Fayra Windpetal",
                31,
                "Ranger",
                610.75,
                List.of(Skills.ARCHERY, Skills.HORSEMANSHIP, Skills.STEALTH)
        ));

        adventurers2.add(new Adventurer(
                "Tiberius Graycloak",
                52,
                "Necromancer",
                1380.0,
                List.of(Skills.NECROMANCY, Skills.RUNECRAFTING)
        ));

        adventurers2.add(new Adventurer(
                "Merrin Brightbrew",
                36,
                "Cleric",
                480.4,
                List.of(Skills.HEALING)
        ));

        adventurers2.add(new Adventurer(
                "Orlo Sparksprocket",
                32,
                "Artificer",
                850.0,
                List.of(Skills.BLACKSMITHING, Skills.RUNECRAFTING)
        ));

        adventurers2.add(new Adventurer(
                "Krell Bloodtide",
                27,
                "Berserker",
                390.0,
                List.of(Skills.SWORDSMANSHIP)
        ));

        adventurers2.add(new Adventurer(
                "Zina Memeweaver",
                21,
                "Bard",
                7777.77,
                List.of(Skills.MEMECRAFTING, Skills.ARCHERY)
        ));

        /**
         * Adding second list of adventurer objects into a second Guild object
         */

        Guild g2 = new Guild("DreadSpire", adventurers2);

        /**
         * Making a list of Guild objects and adding the newly created guilds to it
         */

        List<Guild> guilds = new ArrayList<>();
        guilds.add(g1);
        guilds.add(g2);

        /**
         * Running the methods and displaying the output for those that need it
         */

        List<Adventurer> filtered = filterAdventurersBySkill(guilds, Skills.SWORDSMANSHIP);

        for (Adventurer a : filtered)
        {
            System.out.println(a);
        }

        groupAdventurersByRole(guilds);

        findAdventurerWithMostSkills(guilds)
                .ifPresent(a -> System.out.println("Most skilled adventurer: " + a));

        List<Guild> rankedGuilds = rankGuildsByAverageAdventurerAge(guilds);
        rankedGuilds.forEach(System.out::println);

        skillWiseAdventurerCountMap(guilds);

        bonusGoldEvent(guilds);
    }

}
