package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.home.ChecksCounted;
import starter.home.fillsOut;
import starter.navigation.NavigateTo;

public class WordCounterStepDefinitions {
    
@Given("{actor} is an user who wants to know words and characters quantity")
public void lumuIsAnUserWhoWantsToKnowWordsAndCharactersQuantity(Actor actor){
    actor.attemptsTo(
        NavigateTo.wordCounterPage()
    );
}

    @When("{actor} fills out {}")
    public void heFillsOutText(Actor actor, String text) {
        actor.remember("text", text);
        actor.attemptsTo(
            fillsOut.in(text)
        );
    }

    @Then("{actor} should see words and characters quantity")
    public void heShouldSeeWordsAndCharactersQuantity (Actor actor) {
        actor.attemptsTo(
            ChecksCounted.is()
        );
    }
    @And("{actor} should see keyword density")
    public void heShouldSeeKeywordDensity(Actor actor){
        actor.attemptsTo(
            ChecksCounted.density()
        );
    }
}
