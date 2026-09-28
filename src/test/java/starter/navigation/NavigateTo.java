package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable wordCounterPage(){
        return Task.where("{0} opens word counter page",
            Open.browserOn().the(WordCounterPage.class)
        );
    }
}
