Feature: Create Client

  Scenario: Create a new client
    Given url 'http://localhost:8080/clients'
    And request { name: 'Luna Joe', gender: 'Femenino', age: 36, identification: "10157814244", address: "Amaranto", phone: "0842487115", password: "5412", status: true }
    When method post
    Then status 200
    And match response == { id: '#number', name: "Luna Joe", gender: "Femenino", age: 36, identification: "10157814244", address: "Amaranto", phone: "0842487115", password: "5412", status: true }