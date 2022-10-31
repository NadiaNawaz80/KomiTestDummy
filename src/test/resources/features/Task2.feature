Feature: Testing the Komi Dummy URL
Background:
Given User is on the Dummy Test page

@Nadia
  Scenario: User checks if all the thumbnail images are loaded and visible
    Then i can see all the thumbnail images and they are loaded

  Scenario Outline: Clicking on the section title at the top takes you to the right module
    When i click on <"section"> title
    Then it takes me to correct module
    Examples:
      | "section"        |
      | "Single Music"   |
      | "Music Tracks"   |
      | "Pre-Save Music" |
      | "Subscribe"      |
      | "Latest Singles" |
      | "New Video"      |

  Scenario: User clicks on the side navigation arrow on the ”Music Tracks” module and validates the paging and data
    When i click on side navigation arrow on the Music Tracks module
    Then i verify i can see pages and data

  Scenario: User clicks on “Pre-Save” button and validates the button changes to “Pre-saved”
    When i click on Pre-Save button
    Then i verify i changes to Pre-Save button

  Scenario: User clicks on a Youtube video and asserts that it redirects successfully
    When i click on the youtube video
    Then i verify it redirects successfully

  Scenario: Clicks on the “More” button in the “Single Music” module: validates and redirects to all relevant links.
    When i click on More button in the Single Music module
    Then i verify it redirects to the correct link

  Scenario: User clicks on a “Subscription” module and fills the form successfully.
    When i click the subscription module
    Then i can fill in the form

