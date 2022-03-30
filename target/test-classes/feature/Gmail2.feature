Feature: Gmail mail compose

  Scenario: 
    Given open "chrome" browser
    And launch site using "http://www.gmail.com"
    When do login using "rajeshwarivanam28" and "advika@18" credentials
    Then compose is displayed
    When click on compose and fill fields and send mail and check reponse
    
      | to                     | subject | body    | attachment                                                                       |
      | arunavanam28@gmail.com | hi      | hello   | C:\\Users\\rajiv\\OneDrive\\Pictures\\Camera Roll\\WIN_20220131_20_11_53_Pro.jpg |
      | rajivanam@gmail.com    | hello   | how r u | C:\\Users\\rajiv\\OneDrive\\Pictures\\Camera Roll\\WIN_20220131_20_11_53_Pro.jpg |
    When do logout
    Then login page should be redisplayed
    When close site
