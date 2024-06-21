package starter.pageobjects;

import org.openqa.selenium.By;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;


@DefaultUrl("https://www.google.com/travel/flights")
public class FlightHomepage extends PageObject {
    public static final Target SEARCH_BOX_FROM = InputField.withAriaLabel("Where from?");
    public static final By SEARCH_BOX_FROM_SELECT_1ST = By.xpath("//div[@aria-label='Enter your origin']//ul//li[1]");
    public static final Target SEARCH_BOX_TO = InputField.withPlaceholder("Where to?");
    public static final By SEARCH_BOX_TO_SELECT_1ST = By.xpath("//div[@aria-label='Enter your destination']//ul//li[1]");
    public static final Target DEPART_DATE = InputField.withAriaLabel("Departure");
    public static final By DATE_PICKER_DONE = By.xpath("//div[@class='WXaAwc']//button");
    
    public static final By get_date_picker_date(String date){
        String xpath_string = String.format("//div[@class='SJyhnc']//div[@role='rowgroup']//div[@role='row']//div[@role='gridcell']//div[@role='button']//div[@aria-label=\"%s\"]", date);
        return By.xpath(xpath_string);
    }
    public static final Target SEARCH = Button.withAriaLabel("Search");
    
}

