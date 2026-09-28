package starter.home;

import java.util.LinkedHashMap;
import java.util.Map;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import starter.helper.Await;
import starter.helper.TextAnalyzer;

/**
 * ChecksCounted
 */
public class ChecksCounted {
    public static TextAnalyzer textAnalyzer;
    public static Performable is() {
        return Task.where("{0} checks words and characters counted",
            actor -> {
                Await.until(4);
                String text = actor.recall("text").toString().trim();
                StringBuilder countedText = new StringBuilder();
                textAnalyzer = new TextAnalyzer(text);
                actor.remember("wordCount", textAnalyzer.wordCount());
                countedText.append(textAnalyzer.wordCount() + " words " + textAnalyzer.characterCount()+ " characters");
                String textCounted = actor.asksFor(Text.of(homePage.SPAN_COUNTED)).trim();
                actor.attemptsTo(Ensure.that(textCounted).isEqualToIgnoringCase(countedText));
            }
        );
    }

    public static Performable density() {
        return Task.where(
            "{0} checks text density",
            actor -> {
                int wordCount = new TextAnalyzer(actor.recall("text")).wordCount();
                Map<String, String> density = new LinkedHashMap<>();
                for (int i=0; i < wordCount; i++){
                    density.put(
                        actor.asksFor(Text.of(homePage.KEYWORD_DENSITY_CONTAINER.of("//span[@class='word'])["+(i+1)+"]"))).trim(), 
                        actor.asksFor(Text.of(homePage.KEYWORD_DENSITY_CONTAINER.of("//span[@class='badge'])["+(i+1)+"]"))).trim() 
                    );
                }
                String text = actor.recall("text").toString().trim();
                Map<String,String> expected = new TextAnalyzer(text).wordFrequencyFormatted();
                density.forEach((word,count) -> 
                    actor.attemptsTo(
                        Ensure.that(count).isEqualTo(expected.getOrDefault(word, "0 (0%)"))
                    )
                );
            }
        );
    }

}
