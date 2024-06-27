// Tara Greene
// PA 11

/*
 23.15 (Summarizing the Words in a File) Reimplement Fig. 17.22 using parallel streams.
 Use the Date/Time API timing techniques you learned in Section 23.12
 to compare the time required for the sequential and parallel versions of the program.

 In addition to keeping track of the overall time,
 you should keep track of the time it takes to do the mapping and displaying.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines {
    public static void main(String[] args) throws IOException {

        Pattern pattern = Pattern.compile("\\s+");


        //Sequential Stream Section!!

        // Start clock for Overall time taken and mapping of sequential version
        Instant startOverallSeq = Instant.now();
        Instant startMapSeq = Instant.now();

        Map<String, Long> wordCounts =
                Files.lines(Paths.get("Chapter2Paragraph.txt"))
                        .flatMap(line -> pattern.splitAsStream(line))
                        .collect(Collectors.groupingBy(String::toLowerCase,
                                TreeMap::new, Collectors.counting()));
        // End mapping clock
        Instant endMapSeq = Instant.now();

        // Start clock for Displaying counts for sequential version
        Instant startDisplaySeq = Instant.now();

        wordCounts.entrySet()
                .stream()
                .collect(
                        Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                                TreeMap::new, Collectors.toList()))
                .forEach((letter, wordList) -> {
                    System.out.printf("%n%C%n", letter);
                    wordList.stream().forEach(word -> System.out.printf(
                            "%13s: %d%n", word.getKey(), word.getValue()));
                });
        // End Display and Overall clock for sequential method
        Instant endDisplaySeq = Instant.now();
        Instant endOverallSeq = Instant.now();


        // Parallel Stream Section!!

        // Star clock for Overall and mapping clock for Parallel Streams version
        Instant startOverallPara = Instant.now();
        Instant startMapPara = Instant.now();

        Map<String, Long> wordCountsParallel =
                Files.lines(Paths.get("Chapter2Paragraph.txt"))
                        // switching to parallel here
                        .parallel()
                        .flatMap(line -> pattern.splitAsStream(line))
                        .collect(Collectors.groupingBy(String::toLowerCase,
                                TreeMap::new, Collectors.counting()));
        // End the mapping parallel clock
        Instant endMapPara = Instant.now();

        // Start the Display clock for parallel version
        Instant startDisplayPara = Instant.now();
        // changed name for the parallel version
        wordCountsParallel.entrySet()
                // Changed to parallel stream
                .parallelStream()
                .collect(
                        Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                                TreeMap::new, Collectors.toList()))
                .forEach((letter, wordList) -> {
                    System.out.printf("%n%C%n", letter);
                    wordList.stream().forEach(word -> System.out.printf(
                            "%13s: %d%n", word.getKey(), word.getValue()));
                });

        // End the display and the overall clock for parallel version
        Instant endDisplayPara = Instant.now();
        Instant endOverallPara = Instant.now();

        // Printing out the requested information in the requested format,
        // using the Duration class to calculate the time for each.
        System.out.println("Map sequential processing time: " +
                String.format("%.6f", Duration.between(startMapSeq, endMapSeq).toMillis() / 1_000.0) +
                " seconds");
        System.out.println("Display sequential processing time: " +
                String.format("%.6f", Duration.between(startDisplaySeq, endDisplaySeq).toMillis() / 1_000.0) +
                " seconds");
        System.out.println("Overall sequential processing time: " +
                String.format("%.6f", Duration.between(startOverallSeq, endOverallSeq).toMillis() / 1000.0) +
                " seconds");

        System.out.println("Map parallel processing time: " +
                String.format("%.6f", Duration.between(startMapPara, endMapPara).toMillis() / 1000.0) +
                " seconds");
        System.out.println("Display parallel processing time: " +
                String.format("%.6f", Duration.between(startDisplayPara, endDisplayPara).toMillis() / 1000.0) +
                " seconds");
        System.out.println("Overall parallel processing time: " +
                String.format("%.6f", Duration.between(startOverallPara, endOverallPara).toMillis() / 1000.0) +
                " seconds");


    }
}
// My times when run on my computer
// Map sequential processing time: 2.972000 seconds
// Display sequential processing time: 0.010000 seconds
// Overall sequential processing time: 2.982000 seconds
// Map parallel processing time: 0.580000 seconds
// Display parallel processing time: 0.003000 seconds
// Overall parallel processing time: 0.584000 seconds