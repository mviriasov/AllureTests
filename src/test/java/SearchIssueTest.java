import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SearchIssueTest {
    @Test
    @Feature("Pull Request in Repository")
    @Story("Pull Request")
    @Owner("mviriasov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test", url = "https://github.com/mviriasov/AllureTests")
    @DisplayName("Поиск Pull Request in Repository")
    void searchIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-button").click();
        $(".QueryBuilder-InputWrapper input").setValue("eroshenkoam/allure-example").pressEnter();
        $("a[href='/eroshenkoam/allure-example']").click();
        $("#pull-requests-tab").click();
        $(withText("Fix")).should(Condition.exist);


        sleep(5000);
    }
}
