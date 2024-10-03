@Carrito
Feature: Validar la funcionalidad del carrito de compras
  Scenario Outline: Agregar productos al carrito
    Given estoy en la aplicación MyDemoApp
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido que el carrito de compra actualice correctamente
    Examples:
      | PRODUCTO                  | UNIDADES |
      | Sauce Labs Backpack       | 1        |
      | Sauce Labs Bolt - T-shirt | 1        |
      | Sauce Labs Bike Light     | 2        |