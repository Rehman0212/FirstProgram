import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoTest1 {

    public Logger logger;


    @Test
    public void login() throws InterruptedException {

        logger = LogManager.getLogger(this.getClass());
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\IdeaProjects\\Demo1Test\\Webdrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // search for Apple Iphone
        WebElement searchBox = driver.findElement(By.name("field-keywords"));
        searchBox.click();
        searchBox.sendKeys("Apple Iphone");
        Thread.sleep(1000);

        // choose the 3rd options
        Actions newAction = new Actions(driver);
        newAction.keyDown(searchBox, Keys.ARROW_DOWN).perform();
        newAction.keyDown(searchBox, Keys.ARROW_DOWN).perform();
        newAction.keyDown(searchBox, Keys.ARROW_DOWN).perform();
        newAction.keyDown(searchBox, Keys.ENTER).perform();
        Thread.sleep(3000);

        // get the title of the Page
        driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//img")).click();
        String titleName = driver.getTitle();
        System.out.println("Title of the page is " + titleName);
        Thread.sleep(3000);

        driver.quit();
    }


}

