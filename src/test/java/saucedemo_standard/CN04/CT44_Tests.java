package saucedemo_standard.CN04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.List;

@DisplayName("CT4.4 - Remoção de itens do carrinho ( Tela do carrinho )")
public class CT44_Tests {
    @Test
    @DisplayName("Remoção de itens do carrinho (Tela do carrinho)")
    public void testRemocaoCarrinho(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.get("https://www.saucedemo.com/v1/");

        navegador.findElement(By.id("user-name")).sendKeys("standard_user");
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        navegador.findElement(By.id("login-button")).click();

        List<WebElement> addBotao = navegador.findElements(By.className("btn_primary"));

        for (WebElement add : addBotao){
            add.click();
        }

        navegador.findElement(By.className("svg-inline--fa")).click();

        List<WebElement> removeBotao = navegador.findElements(By.className("btn_secondary"));

        for (WebElement remove : removeBotao){
            remove.click();
        }

        try {
            boolean selo = navegador.findElement(By.className("fa-layers-counter")).isDisplayed();
        } catch (NoSuchElementException e) {
            boolean selo = false;
            Assertions.assertFalse(selo);
        }

        navegador.quit();
    }
}
