// Разработайте следующий автотест:
// - Откройте страницу Selenide в Github
// - Перейдите в раздел Wiki проекта
// - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
// - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchInGithub extends TestBase {

    @Test
    void searchRepoSelenide() {
        open("/");

        $("[name=q]").setValue("Selenide").pressEnter();
        $(byText("selenide/")).click();
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        sleep(1000);
        $("[data-filterable-for=wiki-pages-filter]").$$(".Box-row.wiki-more-pages").last()
                .$(".Truncate").shouldHave((text("SoftAssertions"))).click();
        $("[id=wiki-body]").shouldHave((text("Using JUnit5 extend test class")));

    }

}
