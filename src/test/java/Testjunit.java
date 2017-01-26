import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class Testjunit {
    SafariDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new SafariDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }
    
    @Test
    public void Testjunit() {
        wd.get("https://yandex.ru/");
        wd.findElement(By.linkText("Маркет")).click();
        wd.findElement(By.linkText("Компьютеры")).click();
        wd.findElement(By.linkText("Жесткие диски, SSD и сетевые накопители")).click();
        if (!wd.findElement(By.id("glf-7893318-153061")).isSelected()) {
            wd.findElement(By.id("glf-7893318-153061")).click();
        }
        wd.findElement(By.linkText("Samsung MZ-75E250BW")).click();
        wd.findElement(By.xpath("//div[@class='main']/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div/h3/a/span")).click();
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
