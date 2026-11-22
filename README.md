# Selenium + Cucumber + JUnit 5 Test Framework (Java)

A UI test automation framework for [saucedemo.com](https://www.saucedemo.com), built with Selenium WebDriver for Java, Cucumber (BDD), and JUnit 5, using the Page Object Model.

## What it covers
- Login: valid user and locked-out user
- Inventory: adding a product to the cart and checking the cart badge
- The same checks written both as plain JUnit 5 tests and as Cucumber scenarios

## Tech stack
- Java 17+, Maven
- Selenium 4 (ChromeDriver is managed automatically by Selenium Manager)
- Cucumber 7 with the JUnit Platform engine
- JUnit 5
- Explicit waits with `WebDriverWait`

## Project structure
- `src/test/resources/features`: Gherkin feature files
- `src/test/java/steps`: step definitions
- `src/test/java/pages`: page objects (`LoginPage`, `InventoryPage`)
- `src/test/java/hooks`: opens and closes Chrome for each scenario, and attaches a screenshot when a scenario fails
- `src/test/java/runners`: the Cucumber test runner
- `src/test/java/tests`: plain Selenium + JUnit 5 tests

## How to run
Chrome must be installed. Then run:

    mvn test

Or run `RunCucumberTest` from your IDE as a JUnit test.

## Related projects
The same framework layers are also built with Playwright and with Appium:
- [playwright-cucumber-demo](https://github.com/rishitha7756/playwright-cucumber-demo)
- [appium-demo](https://github.com/rishitha7756/appium-demo)
