Feature: Profile Identity and NoBroker Feature Validation
Background:
Given the user has successfully logged into the application

Scenario: Profile Name Persistence and Refresh Validation
When the user navigates to the Profile page
And the user updates the profile name to "Test User"
And the user refreshes the current page
Then the profile name should be displayed as "Test User"