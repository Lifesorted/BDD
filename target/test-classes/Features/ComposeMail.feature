Feature: Compose Mail

@Smoke
Scenario: Validate user is able to create new mail and send
Given User launch the brower
And Enter app url and hit enter
And click on sign in link
And Enter valid username as "mailmeshail01@rediffmail.com" and password as "Test@123"
When Click on login button
And click on Write mail menu link
And Enter mail to send as "mailmeshailendrakumar@gmail.com"
And Enter subject in subject field as "Test Mail for Rediff"
Then Click on Send button
And close browser

Scenario: Validate close new mail tab
Given User launch the brower
And Enter app url and hit enter
And click on sign in link
And Enter valid username as "mailmeshail01@rediffmail.com" and password as "Test@123"
When Click on login button
And click on Write mail menu link
Then Click on cross icon of new mail tab
And close browser