Feature: Create Client

  Background:
    * url 'http://localhost:8080'

  Scenario: Create a new client
    Given url '/clientes'
    And request {
      "name": "Luna Joe",
      "gender": "Femenino",
      "age": 36,
      "identification": "10157814244",
      "address": "Amaranto",
      "phone": "0842487115",
      "password": "5412",
      "status": true
    }
    When method post
    Then status 200
    And match response == { id: '#number', name: "Jose Lema", gender: "Masculino", age: 30, identification: "1234567890", address: "Otavalo sn y principal", phone: "098254785", password: "1234", status: true }