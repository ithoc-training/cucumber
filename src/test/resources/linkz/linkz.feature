Feature: Posts
  Create and delete links on the Linkz platform

  Scenario: Post a new link
    Given I am on the Linkz start page
    When I post a new link by clicking the according menu item
    Then the start page is opened with the new post on it
