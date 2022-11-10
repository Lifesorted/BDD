Feature: Login

@Smoke
Scenario: Validate login test with valid credentials
Given User launch the brower
And Enter app url and hit enter
And click on sign in link
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
Given User launch the brower
And Enter app url and hit enter
And click on sign in link
And Enter invalid username as "mailmeshail01@rediffmail.com" and password as "Test@1234"
When Click on login button
Then Validate validation message should be "Wrong username and password combination."
And close browser