** Approach to test script **

@Given("^I have opened Google search$") 

This step navigates to Google UK.

*********************************************************

@When("^I search for iPhone and click the Amazon link$")

This searches for iPhone in Google UK. It then searches through the available links on the current page to find an Amazon link. If not, it will loop through pages of search until finally breaking the test. I have not put in an infinate loop as I wanted the test to stop at a certain point.

*********************************************************

@Then("^iPhone details are retrieved$") 

This step will find details required of the iPhone. It also includes the price comparison; I had to include a split to remove '.' and '£'.

*********************************************************

I have used a TDD and BDD approach, as I would script part of the  test and at instances of failure; I would refactor the code. BDD was used as I am using Gherkin language.