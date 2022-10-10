Feature: Automation WebServices Challenge on petstore.swagger.io

  @CreatePet
  Scenario: Create a Pet
    Given a user with a pet info in json format
    When send a post to service path
    Then server response is ok and with a post valid schema

  @GetPet
  Scenario: Get a Pet
    Given a user with a pet id
    When send a get to service path
    Then server response is ok and with a get valid schema

  @UpdatePet
  Scenario: Update a Pet
    Given a user with a previous pet created
    When send a put to update service path
    Then server response is ok and with put valid schema