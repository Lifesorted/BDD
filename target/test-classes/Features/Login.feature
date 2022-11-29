Feature: Login

Background: Steps common for all scenarios
Given User launch the brower
And Enter app url and hit enter
And click on sign in link

Scenario: Validate login test with valid credentials
And Enter valid username as "mailmeshail01@rediffmail.com" and password as "Test@123"
When Click on login button
Then Validate page url should contains "ajaxprism"
And close browser

Scenario Outline: Validate login test with valid credentials DDT
Given User launch the brower
And Enter app url and hit enter
And click on sign in link
And Enter valid username as "<username>" and password as "<password>"
When Click on login button
Then Validate page url should contains "ajaxprism"
And close browser

Examples:
|username|password|
|mailmeshail01@rediffmail.com|Test@123|
|mailmeshail01@rediffmail.com|Test@1234|

Scenario: Validate login test with Invalid credentials
And Enter valid username as "mailmeshail01@rediffmail.com" and password as "Test@123"
When Click on login button
Then Validate validation message
And close browser

@Smoke
Scenario: Validate blank username and password behaviour
When Click on login button
Then Validate popup validation message
And Close the popup
And close browser