package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


@Listeners({AllureTestNg.class})
@Epic("For HomeWork test")
@Feature("HomeWork test")
public class LuminorTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
    }

    @Test(description = "Test for HomeWork")
    public void searchTest() {
        open("https://www.imdb.com/");
        $(byId("suggestion-search")).setValue("Black mirror").pressEnter();
        $$("li.ipc-inline-list__item").get(0).shouldBe(visible, Duration.ofSeconds(10));
        $$("li.ipc-inline-list__item").get(0).click();
        ElementsCollection castMembers = $$("[data-testid='title-cast-item__actor']");
        for(var i=0; i < Math.min(5, castMembers.size()); i++) {
            System.out.println(castMembers.get(i).getText());
        }

    }
}
