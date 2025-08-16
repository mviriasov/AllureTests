import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class StepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String PullReq = "Fix";

    @Test
    @Feature("Pull Request in Repository")
    @Story("Pull Request")
    @Owner("mviriasov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test", url = "https://github.com/mviriasov/AllureTests")
    @DisplayName("Поиск Pull Request in Repository")
    void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $(".QueryBuilder-InputWrapper input").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $("a[href='/eroshenkoam/allure-example']").click();
        });
        step("открываем таб пулл реквестов", () ->{
            $("#pull-requests-tab").click();
        });
        step("Проверяем наличие пулл реквеста с текстом  " + PullReq, () ->{
                    $(withText(PullReq)).should(Condition.exist);
                });
        
        sleep(5000);
    }

    @Test
    @Feature("Pull Request in Repository")
    @Story("Pull Request")
    @Owner("mviriasov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test", url = "https://github.com/mviriasov/AllureTests")
    @DisplayName("Поиск Pull Request in Repository")
    void annotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink();
        steps.openTabPullRequests();
        steps.proverkaPullRequest(PullReq);
    }
}
