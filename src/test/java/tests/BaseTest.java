package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp(){
        driver = initChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }


    private WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
