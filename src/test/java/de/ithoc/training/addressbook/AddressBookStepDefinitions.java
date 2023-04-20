package de.ithoc.training.addressbook;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class AddressBookStepDefinitions {

    private Address address;


    /*
     *  Scenario: Add new address
     */

    @Given("a new address")
    public void a_new_address() {
        // Write code here that turns the phrase above into concrete actions
        address = new Address("Street", "42", "22334", "Hamburg");
    }

    @When("I save the given address")
    public void i_save_the_given_address() {
        // Write code here that turns the phrase above into concrete actions
        address.setId(new Random(System.currentTimeMillis()).nextLong());
    }

    @Then("I should get the ID of newly created address")
    public void i_should_get_the_id_of_newly_created_address() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertNotNull(address.getId());
    }


    /*
     *  Scenario: Change an existing address
     */

    @Given("an existing address with a street name")
    public void an_existing_address_with_a_street_name() {
        // Write code here that turns the phrase above into concrete actions
        address = new Address("Street", "42", "22334", "Hamburg");
    }

    @When("I change the street name and save it")
    public void i_change_the_street_name_and_save_it() {
        // Write code here that turns the phrase above into concrete actions
        address.setStreet("Straße");
    }

    @Then("I get the changed address which has the changed street name")
    public void i_get_the_changed_address_which_has_the_changed_street_name() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals("Straße", address.getStreet());
    }


    /*
     * Scenario Outline: Change the house number of an existing address
     */

    @Given("an existing address with house number {string}")
    public void an_existing_address_with_house_number(String string) {
        // Write code here that turns the phrase above into concrete actions
        address = new Address("Straße", string, "22334", "Hamburg");
    }

    @When("I change the houseNo and save it")
    public void i_change_the_house_no_and_save_it() {
        // Write code here that turns the phrase above into concrete actions
        String houseNo = address.getHouseNo();
        houseNo = houseNo.replace("-", "");
        houseNo = houseNo.replace(" ", "");
        houseNo = houseNo.replace(",", "");
        houseNo = houseNo.toLowerCase();
        address.setHouseNo(houseNo);
    }

    @Then("I get the changed address with houseNo {string}")
    public void i_get_the_changed_address_with_house_no(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(string, address.getHouseNo());
    }

}
