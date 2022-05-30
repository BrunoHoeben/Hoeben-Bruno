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

public class TestZoekBoom {
    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test_ZoekConfirmatie_is_shown_Als_zoek_is_ingevuld(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("zoek")).click();

        Assert.assertEquals("Zoek", driver.getTitle());

        WebElement zoekInput = driver.findElement(By.id("zoek form"));
        zoekInput.clear();
        zoekInput.sendKeys("appelboom");

        driver.findElement(By.id("zoek form submit")).click();

        Assert.assertEquals("ZoekConfirmatie", driver.getTitle());

        driver.quit();
    }

    @Test
    public void test_BekijkSoort_wordt_getoond_met_correcte_boom_Als_zoek_is_ingevuld_met_een_soortnaam_in_de_lijst(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("zoek")).click();

        Assert.assertEquals("Zoek", driver.getTitle());

        WebElement zoekInput = driver.findElement(By.id("zoek form"));
        zoekInput.clear();
        zoekInput.sendKeys("appelboom");

        driver.findElement(By.id("zoek form submit")).click();

        Assert.assertEquals("ZoekConfirmatie", driver.getTitle());

        driver.findElement(By.id("gevondenSoort")).click();

        Assert.assertEquals("BekijkSoort", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds,"appelboom"));

        driver.quit();
    }

    @Test
    public void test_BekijkFamilie_wordt_getoond_met_correcte_boom_Als_zoek_is_ingevuld_met_een_familienaam_in_de_lijst(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("zoek")).click();

        Assert.assertEquals("Zoek", driver.getTitle());

        WebElement zoekInput = driver.findElement(By.id("zoek form"));
        zoekInput.clear();
        zoekInput.sendKeys("rozenfamilie");

        driver.findElement(By.id("zoek form submit")).click();

        Assert.assertEquals("ZoekConfirmatie", driver.getTitle());

        driver.findElement(By.id("gevondenFamilie")).click();

        Assert.assertEquals("BekijkFamilie", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds,"rozenfamilie"));

        driver.quit();
    }

    @Test
    public void test_We_vinden_een_nieuw_toegevoegde_boom_zowel_bij_soort_als_bij_familie_Als_we_deze_toevoegen_en_dan_zoeken_op_soort_en_familie(){
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
        
        driver.findElement(By.id("zoek")).click();

        Assert.assertEquals("Zoek", driver.getTitle());

        WebElement zoekInput = driver.findElement(By.id("zoek form"));
        zoekInput.clear();
        zoekInput.sendKeys("Perenboom");

        driver.findElement(By.id("zoek form submit")).click();

        Assert.assertEquals("ZoekConfirmatie", driver.getTitle());

        driver.findElement(By.id("gevondenSoort")).click();

        Assert.assertEquals("BekijkSoort", driver.getTitle());

        ArrayList<WebElement> tds2 = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds2,"Perenboom"));

        driver.findElement(By.id("zoek")).click();

        Assert.assertEquals("Zoek", driver.getTitle());

        WebElement zoekInput2 = driver.findElement(By.id("zoek form"));
        zoekInput2.clear();
        zoekInput2.sendKeys("Rozenfamilie");

        driver.findElement(By.id("zoek form submit")).click();

        Assert.assertEquals("ZoekConfirmatie", driver.getTitle());

        driver.findElement(By.id("gevondenFamilie")).click();

        Assert.assertEquals("BekijkFamilie", driver.getTitle());

        ArrayList<WebElement> tds3 = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        Assert.assertTrue(containsWebElementsWithText(tds3,"Rozenfamilie"));

        driver.quit();
    }
}

