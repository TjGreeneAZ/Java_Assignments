// Tara Greene
// PA 6

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

    public static void main(String[] args) {
        // Created new HashMap for storing the roster,assigning the Jersey Number as an int and the name as a String
        HashMap<Integer, String> soccerRoster = new HashMap<>();
        // Storing all given players info
        soccerRoster.put(5, "Alice Rogers");
        soccerRoster.put(14, "Juan Gomez");
        soccerRoster.put(32, "Peter Piper");
        soccerRoster.put(18, "Penelope Cruz");
        soccerRoster.put(9, "John Peters");
        // Printing out the size, if any, of the roster stored in the map
        System.out.println("The roster contains " + soccerRoster.size() + " players");
        System.out.println("");
        // Uses the entrySet() to go through the maps entries and then prints them out in suggested format
        System.out.println("Current Roster");
        for (Map.Entry<Integer,String> entry : soccerRoster.entrySet()) {
            System.out.println(String.format("%-5s%s", entry.getKey(), entry.getValue()));
        }
        System.out.println("");
        // Updated the roster with removing a player, adding two more and adjusting the name of existing member
        soccerRoster.remove(18);
        soccerRoster.put(8, "Miguel Diaz");
        soccerRoster.put(17, "Isabella Bautista");
        soccerRoster.replace(5, "Alice Rogers-Jones");
        // Same format as before for displaying current roster
        System.out.println("Current Roster");
        for (Map.Entry<Integer,String> entry : soccerRoster.entrySet()) {
            System.out.println(String.format("%-5s%s", entry.getKey(), entry.getValue()));
        }
        System.out.println("");
        // Start of search function if-else statement to check if the given keys are in the roster or not and statements for such
        int[] rosterSearch = {14, 18};

        for (int key : rosterSearch) {
            if (soccerRoster.containsKey(key)) {
                System.out.println(soccerRoster.get(key) + "'s roster number is " + key);
            } else {
                System.out.println("A player with that number in not on the roster");
            }
        }
        System.out.println("");
        // Converts the HashMap to a TreeMap for sorting the roster numerically by it's keys
        TreeMap<Integer, String> sortedRoster = new TreeMap<>(soccerRoster);
        // Displays the now sorted roster in same format as before
        System.out.println("Current Roster");
        for (Map.Entry<Integer, String> entry : sortedRoster.entrySet()) {
            System.out.println(String.format("%-5s%s", entry.getKey(), entry.getValue()));
        }
    }
}