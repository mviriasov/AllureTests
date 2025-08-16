import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("открываем главную страницу")
    public void openMainPage () {
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepository (String repo) {
        $(".header-search-button").click();
        $(".QueryBuilder-InputWrapper input").setValue(repo).pressEnter();
    }
    @Step("Кликаем по ссылке репозитория ")
    public void clickOnRepositoryLink () {
        $("a[href='/eroshenkoam/allure-example']").click();
    }
    @Step("открываем таб пулл реквестов")
    public void openTabPullRequests () {
        $("#pull-requests-tab").click();
    }
    @Step("Проверяем наличие пулл реквеста с текстом {pullreq}" )
    public void proverkaPullRequest (String pullreq) {
        $(withText(pullreq)).should(Condition.exist);
    }
}
