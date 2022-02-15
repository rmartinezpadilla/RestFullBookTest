Feature: consult restful-booker
  I as user need consult and verify responses from resfult booker api

  Scenario: create token
    When is created token with user: admin and password: password123
    Then should generate new token

  Scenario: update booking
    When is update booking firstname: James
    Then should booking update
