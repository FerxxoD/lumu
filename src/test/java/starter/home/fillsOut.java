package starter.home;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class fillsOut {

    public static Performable in(String text) {
        return Task.where("{0} fills out {1} in word counter",
            WaitUntil.the(homePage.INPUT_TEXT, WebElementStateMatchers.isPresent()), 
            Enter.theValue(text).into(homePage.INPUT_TEXT)
        );
    }

}
