package starter.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import starter.pageobjects.FlightHomepage;

public class NavigateSteps extends UIInteractionSteps {

    FlightHomepage flightHomepage;


    @Step("Sally is on the google flights search website")
    public void openHomePage() {
        flightHomepage.open();
    }

}
