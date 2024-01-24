
Feature: Capstone Project
  
  Scenario: herokuapp testing 
    Given Launch a  URL 
    And verify the title of the Page 
    When Click on A/B Testing link 
    And verify the text on the page as “A/B Test Variation 1” using TestNG Assertions
    And Navigate back to Home page and click on dropdown link
    And Select Option1 value form drop down and confirm if its selected or not
    Then Navigate back to Home Page and Click on Frames
    And Verify the hyperlinks are presented on the Frames Page i.e. Nested Frames and iFrame

  