$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('amazonTestJava\amazonTest.feature');
formatter.feature({
  "line": 1,
  "name": "CucumberJava",
  "description": "",
  "id": "cucumberjava",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login functionality exists",
  "description": "",
  "id": "cucumberjava;login-functionality-exists",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I have opened Google search",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I search for iPhone and click the Amazon link",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "iPhone details are retrieved",
  "keyword": "Then "
});
formatter.match({
  "location": "annotation.goToGoogle()"
});
formatter.result({
  "duration": 12242836505,
  "status": "passed"
});
formatter.match({
  "location": "annotation.searchiPhone()"
});
formatter.result({
  "duration": 23183993023,
  "status": "passed"
});
formatter.match({
  "location": "annotation.amazonPage()"
});
formatter.result({
  "duration": 917330964,
  "status": "passed"
});
});