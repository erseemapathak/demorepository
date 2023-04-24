#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@smoke
Feature: demoblaze Project automation cart page

  @positive @integration
  Scenario: user can place order for product
    Given user is on the home page
    Then user open Login Page																																																																																										+
    When I enter username as "seema123@gmail.com" ans password as "test123"
    Then I should successfully login
    And user click on phones category and check item display
    When user click on random item and add it to cart
    Then alert of item added is displayed and user accept that
    And user navigate to cart page
    Then user click on place order button
    And user fill Detail to place order then click on purchase button
    Then order Confirmation  Message is displayed and user click on ok button

  Scenario: user can place order for product with only name and card detail
    Given user is on the home page
    Then user open Login Page																																																																																										+
    When I enter username as "seema123@gmail.com" ans password as "test123"
    Then I should successfully login
    And user click on phones category and check item display
    When user click on random item and add it to cart
    Then alert of item added is displayed and user accept that
    And user navigate to cart page
    Then user click on place order button
    And user fill Detail name and card to place order then click on purchase button
    Then order Confirmation  Message is displayed and user click on ok button

  Scenario: user try to place order for product without giving name detail
    Given user is on the home page
    Then user open Login Page																																																																																										+
    When I enter username as "seema123@gmail.com" ans password as "test123"
    Then I should successfully login
    And user click on phones category and check item display
    When user click on random item and add it to cart
    Then alert of item added is displayed and user accept that
    And user navigate to cart page
    Then user click on place order button
    And user try to place order for product without giving name detail then click on purchase button
    Then alert message for incomplete detail is displayed and user accept that

  Scenario: user add items to cart then delete item from cart
    Given user is on the home page
    Then user open Login Page																																																																																										+
    When I enter username as "seema123@gmail.com" ans password as "test123"
    Then I should successfully login
    And user click on phones category and check item display
    When user click on random item and add it to cart
    Then alert of item added is displayed and user accept that
    And user navigate to cart page
    And user delete item from cart