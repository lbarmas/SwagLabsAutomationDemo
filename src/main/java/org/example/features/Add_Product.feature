@Feature_File_addProduct @addProduct
Feature: Add Product to Cart

  Scenario: Add a product to the cart
    Given the user is logged into the SwagLabs app
    When the user adds the product to the cart
    Then the product is added to the cart successfully


