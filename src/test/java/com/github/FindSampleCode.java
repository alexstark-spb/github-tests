package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FindSampleCode {


    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

    }

    @Test
    void findCodeForJunit() {
        open("https://github.com/");
        $("[placeholder='Search GitHub']").click();
        $("[data-test-selector='nav-search-input']").setValue("Selenide").pressEnter();
        $(".repo-list").$(byText("selenide/")).click();
        $("#wiki-tab").$(byText("Wiki")).click();
        $(".markdown-body ul").$(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));

    }
}
