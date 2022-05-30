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

public class TestAddBoom {
    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test_VoegToe_wordt_getoond_Als_je_naar_voegToe_navigeert(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("voeg toe")).click();
        Assert.assertEquals("VoegToe", driver.getTitle());

        driver.quit();
    }

    @Test
    public void test_Overzicht_wordt_getoont_Als_het_form_correct_is_ingevuld(){
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

        driver.quit();
    }

    @Test
    public void test_VoegToe_wordt_opnieuw_getoont_met_foutmelding_Indien_soortnaam_leeg_is(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("voeg toe")).click();

        WebElement familieInput = driver.findElement(By.id("familie boom"));
        familieInput.clear();
        familieInput.sendKeys("Rozenfamilie");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.click();
        aantalInput.sendKeys("3");

        driver.findElement(By.id("voeg toe form")).click();

        Assert.assertEquals("VoegToe", driver.getTitle());

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        Assert.assertTrue(containsWebElementsWithText(lis,"soortnaam mag niet leeg zijn"));

        driver.quit();
    }

    @Test
    public void test_VoegToe_wordt_opnieuw_getoont_met_foutmelding_Indien_familienaam_leeg_is(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Hoeben_Bruno_war_exploded/");
        driver.findElement(By.id("voeg toe")).click();

        WebElement soortInput = driver.findElement(By.id("soort boom"));
        soortInput.clear();
        soortInput.sendKeys("Perenboom");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.click();
        aantalInput.sendKeys("3");

        driver.findElement(By.id("voeg toe form")).click();

        Assert.assertEquals("VoegToe", driver.getTitle());

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        Assert.assertTrue(containsWebElementsWithText(lis,"familienaam mag niet leeg zijn"));

        driver.quit();
    }

    @Test
    public void test_VoegToe_wordt_opnieuw_getoont_met_foutmelding_Indien_aantal_leeg_is(){
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

        driver.findElement(By.id("voeg toe form")).click();

        Assert.assertEquals("VoegToe", driver.getTitle());

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        Assert.assertTrue(containsWebElementsWithText(lis,"aantal bomen mag niet kleiner dan 0 zijn"));

        driver.quit();
    }

    @Test
    public void test_VoegToe_wordt_opnieuw_getoont_met_foutmelding_Indien_aantal_negatief_is(){
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
        aantalInput.sendKeys("-3");

        driver.findElement(By.id("voeg toe form")).click();

        Assert.assertEquals("VoegToe", driver.getTitle());

        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        Assert.assertTrue(containsWebElementsWithText(lis,"For input string: \"\""));

        driver.quit();
    }

}
