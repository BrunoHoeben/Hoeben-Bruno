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

public class TestVerwijderBoom {
    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test_Verwijder_gaat_naar_verwijderbevestiging_Als_je_erop_drukt_in_overzicht() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("overzicht")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        driver.findElement(By.id("verwijder1")).click();

        Assert.assertEquals("Verwijderbevestiging", driver.getTitle());

        driver.quit();
    }

    @Test
    public void test_Verwijder_verwijdert_niet_Indien_geannuleerd() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("overzicht")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds, "appelboom"));

        driver.findElement(By.id("verwijder0")).click();

        Assert.assertEquals("Verwijderbevestiging", driver.getTitle());

        driver.findElement(By.id("annuleer")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds2 = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds2, "appelboom"));

        driver.quit();
    }

    @Test
    public void test_Verwijder_verwijdert_Indien_bevestigd() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("overzicht")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds, "appelboom"));

        driver.findElement(By.id("verwijder0")).click();

        Assert.assertEquals("Verwijderbevestiging", driver.getTitle());

        driver.findElement(By.id("verwijderbevestiging")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds2 = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertFalse(containsWebElementsWithText(tds2, "appelboom"));

        driver.quit();
    }

    @Test
    public void test_Verwijder_toegevoegde_boom_verwijdert_die_boom() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("voeg toe")).click();
        WebElement soortInput = driver.findElement(By.id("soort boom"));
        soortInput.clear();
        soortInput.sendKeys("Perenboom");

        WebElement familieInput = driver.findElement(By.id("familie boom"));
        familieInput.clear();
        familieInput.sendKeys("Rozenfamilie");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.click();
        aantalInput.sendKeys("3");

        driver.findElement(By.id("voeg toe form")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds,"Perenboom"));

        driver.findElement(By.id("verwijder4")).click();

        Assert.assertEquals("Verwijderbevestiging", driver.getTitle());

        driver.findElement(By.id("verwijderbevestiging")).click();

        Assert.assertEquals("Overzicht", driver.getTitle());

        ArrayList<WebElement> tds2 = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertFalse(containsWebElementsWithText(tds2, "Perenboom"));

        driver.quit();
    }
}