Feature: Crear orden en PetStore

  @testOrden
  Scenario Outline: Crear una orden en PetStore
    #Given que el usuario quiere realizar una orden en la tienda
    When crea una orden con el pet <petId>, la cantidad <quantity>, el estado "<status>"
    Then el codigo respuesta es <statusCode>
    And el id del pet en la respuesta es <petId>
    And la cantidad en la respuesta es <quantity>
    And el estado en la respuesta es "<status>"

    Examples:
      | petId | quantity | status   | statusCode |
      | 1     | 10       | placed   | 200        |
      | 3     | 7        | approved | 200        |



  @testConsultaOrden
  Scenario Outline: Consultar la orden recién creada en PetStore
    When consulto la orden creada
    Then el codigo respuesta es <statusCode>
    And el id del pet en la orden es <petId>
    And la cantidad en la orden es <quantity>
    And el estado en la orden es "<status>"

    Examples:
      | petId | quantity | status   | statusCode |
      | 1     | 10       | placed   | 200        |
      | 3     | 7        | approved | 200        |

