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
 
Feature: DemoBlaze Automation Project
  

  @regression
  Scenario: User open DemoBlaze 
    Given user is on demoblaze.com
    Then  user move to the sign-up page
    When user enter username as "seema123@gmail.com" ans password as "test123"    
    Then user should successfully sign-up
    
  @regression
   Scenario: User try to sign-up with existing Id
    Given user is on demoblaze.com
    Then  user move to the sign-up page
    When user enter existing username as "ram123@gmail.com" ans password as "test123"    
    Then user should get an alert message
       
 @login @positive
  Scenario: Valid username and valid password test
    Given user is on the home page
    Then  user open Login Page																																																																																										+						
    When I enter username as "seema123@gmail.com" ans password as "test123"
    Then I should successfully login  

 
   
  
    
 
  
 