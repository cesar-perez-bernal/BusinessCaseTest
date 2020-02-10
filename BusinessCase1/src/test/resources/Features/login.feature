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
@tag
Feature: Login Page
    As a user I should be able to login to the page.
    so I can buy the product

  @tag1 @ignore
  Scenario: The user should be able to log in
    Given The user enter to login page
    When The user enter username as "test800@hotmail.com"
    And The user enter password as "test123"
    And The user clicks on sign in button
    Then The user should be logged correctly
	@ignore
  Scenario: Entering wrong user and wrong password should display error message
	  Given The user enter to login page
    When The user enter username as "hello@mai.com"
    And The user enter password as "sjdhasldh"
    And The user clicks on sign in button
    Then The page should display authentication failed
	@ignore
	Scenario: Entering correct user and wrong password should display error message
	  Given The user enter to login page
    When The user enter username as "test800@hotmail.com"
    And The user enter password as "test"
    And The user clicks on sign in button
    Then The page should display invalid password
 	@ignore
  Scenario: Entering wrong user and correct password should display error message
	  Given The user enter to login page
    When The user enter username as "hello@mai.com"
    And The user enter password as "test1234"
    And The user clicks on sign in button
    Then The page should display authentication failed
	@ignore
  Scenario: Entering empty user and empty password should display error message
	  Given The user enter to login page
    When Now the user clicks on sign in button
    Then The page should display email address required
	@ignore
  Scenario: Entering correct user and empty password should display error message
	  Given The user enter to login page
    When The user enter username as "test800@hotmail.com"
    And The user clicks on sign in button
    Then The page should display password required
	@ignore
  Scenario: Entering empty user and correct password should display error message
	  Given The user enter to login page
    When Now the user enter password as "test123"
    And The user clicks on sign in button
    Then The page should display email address required

	Scenario: Purchase anything
		Given The user enter to login page
		When The user enter username as "test800@hotmail.com"
    And The user enter password as "test123"
    And The user clicks on sign in button
    Then The user should be logged correctly
    And The user clicks on Women
    And The user clicks on any product
    Then Click on proceed to checkout
    And Click on proceed to checkout Again
    And Click on proceed to checkout once again
    And Click agree terms and proceed
    And Pay product
    And Confirm the order
    Then Confirm success message

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
