package com.github.smkjke.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RevolutMainPageTests extends BaseTest {

    @Test
    @DisplayName("Open main page and see cookie agreement")
    void cookieFormIsAppeared() {
        step("Opened Revolut main page", () ->
                open("/"));

        step("Cookie agreement is appeared", () ->
                $x(".//div/h5[contains(@class,'Box')]")
                        .shouldHave(text("Cookies give you a personalised experience")));
    }

    @Test
    @DisplayName("Open main page and agree with cookie")
    void cookieFormClickedAgree() {
        step("Opened Revolut main page", () ->
                open("/"));

        step("Cookie agreement is appeared", () ->
                $x(".//div/h5[contains(@class,'Box')]")
                        .shouldBe(visible));
        step("Agree with all cookies", () ->
                $x(".//button/span[contains(text(), 'Allow all cookies')]").click());
    }

    @Test
    @DisplayName("Open main page and check header")
    void checkMainPageHeader() {
        step("Opened Revolut main page", () ->
                open("/"));

        step("Cookie agreement is appeared", () ->
                $x(".//div/h5[contains(@class,'Box')]")
                        .shouldBe(visible));
        step("Agree with all cookies", () ->
                $x(".//button/span[contains(text(), 'Allow all cookies')]").click());

        step("Check header logo is REVOLUT", () ->
                $x(".//header//a")
                        .shouldBe(visible)
                        .shouldHave(attribute("aria-label", "Revolut")));
    }

    @Test
    @DisplayName("Open main page and check how many menus are visible")
    void checkMainMenusSize() {
        step("Opened Revolut main page", () ->
                open("/"));

        step("Cookie agreement is appeared", () ->
                $x(".//div/h5[contains(@class,'Box')]")
                        .shouldBe(visible));
        step("Agree with all cookies", () ->
                $x(".//button/span[contains(text(), 'Allow all cookies')]").click());

        step("Check menus size", () ->
                $$x(".//div[contains(@class,'Box-sc-1g1k12l-0 Flex-sc-p3ay74-0 sc-24f3aec9-0 tbXfU iTYVxy')]/button")
                        .shouldHave(CollectionCondition.size(4)));
    }

    @Test
    @DisplayName("Open main page and check first menu button is 'Personal'")
    void checkMainMenuPersonalButton() {
        step("Opened Revolut main page", () ->
                open("/"));

        step("Cookie agreement is appeared", () ->
                $x(".//div/h5[contains(@class,'Box')]")
                        .shouldBe(visible));
        step("Agree with all cookies", () ->
                $x(".//button/span[contains(text(), 'Allow all cookies')]").click());

        step("Check first menu is Personal", () ->
                $x(".//div[contains(@class,'Box-sc-1g1k12l-0 Flex-sc-p3ay74-0 sc-24f3aec9-0 tbXfU iTYVxy')]/button[1]/span")
                        .shouldHave(text("Personal")));
    }

    @Test
    @DisplayName("Open main page and check second menu button is 'Company' - [NEGATIVE]")
    void checkMainMenuSecondButton() {
        step("Opened Revolut main page", () ->
                open("/"));

        step("Cookie agreement is appeared", () ->
                $x(".//div/h5[contains(@class,'Box')]")
                        .shouldBe(visible));
        step("Agree with all cookies", () ->
                $x(".//button/span[contains(text(), 'Allow all cookies')]").click());

        step("Check first menu is Personal", () ->
                $x(".//div[contains(@class,'Box-sc-1g1k12l-0 Flex-sc-p3ay74-0 sc-24f3aec9-0 tbXfU iTYVxy')]/button[2]/span")
                        .shouldHave(text("Company")));
    }

}
