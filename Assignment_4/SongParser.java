// Tara Greene
// PA4

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SongParser {
    public static void main(String[] args) {
        // Starts the scanner for reading input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path and name of the json file:");
        String jsonPath = scanner.nextLine();

        // Create an instance of JSONParser to parse the JSON data
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(jsonPath)) {
            // Parse the JSON file into a JSONObject
            JSONObject songJson = (JSONObject) parser.parse(reader);

            // Extract data from the JSONObject. Added a try block to catch potential ClassCastException as per rubric notes?
            try {
                String artist = (String) songJson.get("artistName");
                String songName = (String) songJson.get("trackName");
                String albumName = (String) songJson.get("collectionName");
                String genre = (String) songJson.get("primaryGenreName");
                long durationMillis = (Long) songJson.get("trackTimeMillis"); // switched to long
                double songPrice = ((Number) songJson.get("trackPrice")).doubleValue();
                String trackExplicitness = (String) songJson.get("trackExplicitness");
                boolean isExplicit = "explicit".equalsIgnoreCase(trackExplicitness);
            
                // Variable for displaying the info now pulled from the JSON
                Song song = new Song(artist, songName, albumName, genre, durationMillis, songPrice, isExplicit);
            
                // Displaying the Song object using its toString method.
                System.out.println(song.toString());
            } catch (ClassCastException e) {
                System.out.println("Error: A type mismatch occurred while processing the JSON data.");
            }
            
        } catch (FileNotFoundException e) {
            // Catch for exceptions of file not being found.
            System.out.println("File not found: " + jsonPath);
        } catch (ParseException e) {
            // Catch for exceptions errors in parsing the JSON data.
            System.out.println("Error parsing the file.");
        } catch (IOException e) {
            // Catch for exceptions related to IO errors during file reading.
            System.out.println("An error occurred while reading the file.");
        } 
        scanner.close();
    }
}

