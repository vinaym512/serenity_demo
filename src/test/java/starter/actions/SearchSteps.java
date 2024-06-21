package starter.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import starter.pageobjects.FlightHomepage;
import starter.pageobjects.SelectFlightpage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import static org.junit.Assert.fail;

public class SearchSteps extends UIInteractionSteps {
    
    @Step("User searches for round trip flight '{0} {1} {2} {3}'")
    public void searchForFlight(String origin, String dest, String departDate, String returnDate) {
        find(FlightHomepage.SEARCH_BOX_FROM).clear();
        find(FlightHomepage.SEARCH_BOX_FROM).sendKeys(origin);
        find(FlightHomepage.SEARCH_BOX_FROM_SELECT_1ST).click();

        find(FlightHomepage.SEARCH_BOX_TO).sendKeys(dest);
        find(FlightHomepage.SEARCH_BOX_TO_SELECT_1ST).click();

        waitABit(500);
        find(FlightHomepage.DEPART_DATE).click();
        waitABit(500);
        find(FlightHomepage.get_date_picker_date(departDate)).click();
        waitABit(500);
        find(FlightHomepage.get_date_picker_date(returnDate)).click();
        waitABit(500);
        find(FlightHomepage.DATE_PICKER_DONE).click();
        
        find(FlightHomepage.SEARCH).click();

        waitFor(findAll(SelectFlightpage.SUB_HEADER).get(0).getElement()).isEnabled();

    }

    @Step("User should see flights results page with '{0}'")
    public void assertForBestFlight(String term) {
        final Pattern pattern;
        
        if(term.toLowerCase().contains("departing flights")){
            waitFor("//h3[contains(text(), 'departing flights')]");
            pattern = Pattern.compile("(Best|Top) departing flights");
        } else {
            if(term.toLowerCase().contains("returning flights")) {
                waitFor("//h3[contains(text(), 'returning flights')]");
                pattern = Pattern.compile("(Best returning|Returning) flights");
            } else {
                waitFor("//h2[text()='Booking options']");
                pattern = Pattern.compile("Booking options");
            }
        }
        List<String> headings = findAll(SelectFlightpage.SUB_HEADER).texts();

        boolean flag_pass = false;
        for (String heading : headings){
            Matcher m = pattern.matcher(heading);
            if (m.matches()){
                flag_pass = true;
                break;
            }
        }
        if(flag_pass == false){
            fail("*****Failed for pattern***** "+pattern);
        } 

    }

    @Step("User select first flights")
    public void selectFirstFlight(String depart_return) {
        // record start and end time of flights to verify at last page
        String flight_time_start = findAll(SelectFlightpage.DEP_RET_FLIGHT_TIMES).get(0).getAccessibleName();
        String flight_time_end = findAll(SelectFlightpage.DEP_RET_FLIGHT_TIMES).get(1).getAccessibleName();
        if (depart_return.toLowerCase().contains("depart")){
            Serenity.setSessionVariable("Depart_Flight_Time_Start").to(flight_time_start);
            Serenity.setSessionVariable("Depart_Flight_Time_End").to(flight_time_end);
        }else{
            Serenity.setSessionVariable("Return_Flight_Time_Start").to(flight_time_start);
            Serenity.setSessionVariable("Return_Flight_Time_End").to(flight_time_end);
        }

        find(SelectFlightpage.FIRST_FLIGHT).click();

        waitFor(findAll(SelectFlightpage.SUB_HEADER).get(0).getElement()).isEnabled();
        
    }
    
    @Step("User select return flights")
    public void selectReturnFlight() {
        find(SelectFlightpage.FIRST_FLIGHT).click();
        waitFor(findAll(SelectFlightpage.SUB_HEADER).get(0).getElement()).isEnabled();
        
    }

    @Step("User verify flights info")
    public void verify_flight_info() {
        // Verify the selected flight depart and arival times
        // Other values can be verifed similarily
        String depart_flight_start = Serenity.sessionVariableCalled("Depart_Flight_Time_Start");
        String depart_flight_end = Serenity.sessionVariableCalled("Depart_Flight_Time_End");
        String return_flight_start = Serenity.sessionVariableCalled("Return_Flight_Time_Start");
        String return_flight_end = Serenity.sessionVariableCalled("Return_Flight_Time_End");
        String sel_depart_flight_start = findAll(SelectFlightpage.SEL_DEP_RET_FLIGHT_TIMES).get(0).getAccessibleName();
        String sel_depart_flight_end = findAll(SelectFlightpage.SEL_DEP_RET_FLIGHT_TIMES).get(1).getAccessibleName();
        String sel_return_flight_start = findAll(SelectFlightpage.SEL_DEP_RET_FLIGHT_TIMES).get(2).getAccessibleName();
        String sel_return_flight_end = findAll(SelectFlightpage.SEL_DEP_RET_FLIGHT_TIMES).get(3).getAccessibleName();

        Assert.assertEquals(depart_flight_start, sel_depart_flight_start);
        Assert.assertEquals(depart_flight_end, sel_depart_flight_end);
        Assert.assertEquals(return_flight_start, sel_return_flight_start);
        Assert.assertEquals(return_flight_end, sel_return_flight_end);
    }

}
