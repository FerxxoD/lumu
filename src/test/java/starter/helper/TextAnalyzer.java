package starter.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TextAnalyzer {

    private final String text;

    public TextAnalyzer(String text) {
        this.text = (text == null) ? "" : text;
    }


    public int wordCount() {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    public int characterCount() {
        return text.length();
    }

    public Map<String, Integer> wordFrequency() {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return Collections.emptyMap();
        }

        return Arrays.stream(trimmed.split("\\s+"))
                .map(word -> word.toLowerCase().replaceAll("[^a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ]", ""))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }


    /* /
     * Example: { "word" -> "3 (60%)", "world" -> "2 (40%)" }
     */
    public Map<String, String> wordFrequencyFormatted() {
        Map<String, Integer> frequency = wordFrequency();
        int total = frequency.values().stream().mapToInt(Integer::intValue).sum();

        Map<String, String> formatted = new LinkedHashMap<>();
        frequency.forEach((word, count) -> {
            int percentage = (int) Math.round((count * 100.0) / total);
            formatted.put(word, count + " (" + percentage + "%)");
        });
        return formatted;
    }

}
