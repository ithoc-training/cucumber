package de.ithoc.training.linkz;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.util.UUID.randomUUID;

public class LinkzStepDefinitions {

    private WebDriver webDriver;
    private String uuid;

    @Before
    public void openBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
    }

    @Given("I am on the Linkz start page")
    public void i_am_on_the_linkz_start_page() {

        webDriver.get("http://localhost:8080");
    }

    @When("I post a new link by clicking the according menu item")
    public void i_post_a_new_link_by_clicking_the_according_menu_item() {

        uuid = randomUUID().toString();

        WebElement element = webDriver.findElement(By.linkText("Post Link"));
        element.click();

        WebElement title = webDriver.findElement(By.id("title"));
        title.sendKeys(uuid);

        WebElement url = webDriver.findElement(By.id("url"));
        url.sendKeys("https://" + uuid + "." + uuid.substring(0, 2));

        WebElement buttonElement = webDriver.findElement(By.tagName("button"));
        buttonElement.click();
    }

    @Then("the start page is opened with the new post on it")
    public void the_start_page_is_opened_with_the_new_post_on_it() {

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until((ExpectedCondition<Boolean>) webDriver ->
                {
                    assert webDriver != null;
                    boolean currentUrl = webDriver.getCurrentUrl().equals("http://localhost:8080/?linkSubmitted=true");
                    boolean contains = webDriver.getPageSource().contains(uuid);

                    return currentUrl && contains;
                });
    }

    @After()
    public void closeBrowser() {

        webDriver.quit();
    }

}
