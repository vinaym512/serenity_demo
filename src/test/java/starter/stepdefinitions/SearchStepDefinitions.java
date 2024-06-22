package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.util;
import starter.actions.NavigateSteps;
import starter.actions.SearchSteps;

import java.util.List;

public class SearchStepDefinitions {

    @Steps
    NavigateSteps navigate;

    @Steps
    SearchSteps search;

    @Given("^(?:.*) is on the google flights search website")
    public void sally_is_on_the_google_flights_search_website() {
        navigate.openHomePage();

    }
    
    @When("^(?:.*) searches for round trip flight")
    public void should_see_information_about_flight(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        String origin = rows.get(0).get(1) ;
        String dest = rows.get(1).get(1) ;
        String depart = util.get_date(rows.get(2).get(1)) ;
        String retrn = util.get_date(rows.get(3).get(1)) ;
        
        search.searchForFlight(origin, dest, depart, retrn);

    }

    @When("^(?:.*) should see flights results page with \"(.*)\"")
    public void should_see_next_page(String term) {
        search.assertForBestFlightAndBooking(term);

    }

    @When("^(?:.*) selects the first flight under best \"(.*)\" flights")
    public void select_first_flight(String depart_return) {
        search.selectFirstFlight(depart_return);

    }

    @And("^(?:.*) should see the corresponding flight information for flights selected")
    public void verify_flight_details() {
        search.verify_flight_info();

    }
    
}
