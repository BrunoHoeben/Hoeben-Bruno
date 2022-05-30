package view;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPasAan {
    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test_Pas_aan_gaat_naar_aanpaspagina_Als_je_erop_drukt_in_overzicht() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("overzicht")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        driver.findElement(By.id("pasAan0")).click();

        Assert.assertEquals("PasAan", driver.getTitle());

        driver.quit();
    }

    @Test
    public void test_Pas_aan_past_soortnaam_aan_Indien_de_soortnaam_verandert_werd() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("overzicht")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds, "appelboom"));

        driver.findElement(By.id("pasAan0")).click();

        WebElement soortInput = driver.findElement(By.id("soort boom"));
        soortInput.clear();
        soortInput.sendKeys("perenboom");

        driver.findElement(By.id("pas aan form")).click();

        ArrayList<WebElement> tds2 = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertFalse(containsWebElementsWithText(tds2, "appelboom"));
        Assert.assertTrue(containsWebElementsWithText(tds2, "perenboom"));

        driver.quit();
    }

    @Test
    public void test_Pas_aan_past_familienaam_aan_Indien_de_familienaam_verandert_werd() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("overzicht")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds, "berkenfamilie"));

        driver.findElement(By.id("pasAan1")).click();

        WebElement soortInput = driver.findElement(By.id("familie boom"));
        soortInput.clear();
        soortInput.sendKeys("niet de berkenfamilie");

        driver.findElement(By.id("pas aan form")).click();

        ArrayList<WebElement> tds2 = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertFalse(containsWebElementsWithText(tds2, "berkenfamilie"));
        Assert.assertTrue(containsWebElementsWithText(tds2, "niet de berkenfamilie"));

        driver.quit();
    }

    @Test
    public void test_Pas_aan_past_aantal_aan_Indien_het_aantal_verandert_werd() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("overzicht")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds, "3"));

        driver.findElement(By.id("pasAan2")).click();

        WebElement soortInput = driver.findElement(By.id("aantal"));
        soortInput.clear();
        soortInput.sendKeys("18");

        driver.findElement(By.id("pas aan form")).click();

        ArrayList<WebElement> tds2 = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertFalse(containsWebElementsWithText(tds2, "3"));
        Assert.assertTrue(containsWebElementsWithText(tds2, "18"));

        driver.quit();
    }
}