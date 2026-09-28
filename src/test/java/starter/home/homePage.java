package starter.home;

import net.serenitybdd.screenplay.targets.Target;

public class homePage {
    public static final Target INPUT_TEXT = Target.the("textarea counter field")
        .locatedBy("//textarea[@id='box']");
    public static final Target SPAN_COUNTED = Target.the("Span counted")
        .locatedBy("//div[@class='pull-left']//span[@class='counted']");
    public static final Target SPAN_FOOTER_COUNTED = Target.the("Span counted in footer")
        .locatedBy("//div[@class='panel-footer']//div//span[@class='counted']");

    //////////////////////////////// KEYWORD DENSITY /////////////////////////////////////////////////
    public static final Target KEYWORD_DENSITY_CONTAINER = Target.the("Container text density")
        .locatedBy("(//div[@id='kwd-density']//div[@id='kwd-accordion-data']{0}");
    
}
