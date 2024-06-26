package starter.pageobjects;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;


public class SelectFlightpage extends PageObject {
    public static final By SUB_HEADER = By.xpath("//div[@role='main']//*[self::h2 or self::h3]");
    public static final By FIRST_FLIGHT = By.xpath("(//ul[@class='Rk10dc'])[1]/li[1]");   
    public static final By DEP_RET_FLIGHT_TIMES = By.xpath("(//ul[@class='Rk10dc'])[1]/li[1]//div[@class='Ir0Voe']//span[@role='text']");
    public static final By SEL_DEP_RET_FLIGHT_TIMES = By.xpath("//div[@class='Ir0Voe']//span[@role='text']");
    public static final String BEST_DEPART_FLIGHT = "//h3[contains(text(), 'departing flights')]";
    public static final String BEST_RETURN_FLIGHT = "//h3[contains(translate(text(), 'R', 'r'), 'returning flights')]";
    public static final String BEST_BOOKING_OPTION = "//h2[text()='Booking options']";
    public static final By AVAILABLE_FLIGHT_TABLE = By.xpath("(//ul[@class='Rk10dc'])[1]//li");
   
}

