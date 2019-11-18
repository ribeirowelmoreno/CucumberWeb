@Purchase-Simulator--UserStory01
Feature: Add product on cart

  @Add-First-Product-On-Cart
  Scenario Outline: Login with username  and password correctly and search for a product

    Given user click in Faca seu Login

    When insert the correct "<email>" and "<password>"

      And search for some "<product>"
      And click on first found product
      And add the product to cart
      And proceed to checkout

    Then I should see the product on the cart
    Then close browser


    Examples:
      | email | password | product |
      |conta.wel.teste.web@gmail.com | 421563 | iphone 11 pro 64gb |

  @Add-Second-Product-On-Cart
  Scenario Outline: Login with username and password and add a new product on cart

    Given user click in Faca seu Login

    When insert the correct "<email>" and "<password>"

      And search for some "<product>"
      And click on second found product
      And add the product to cart
      And proceed to checkout
      And change the quantity

    Then I should see the quantity was been changed
    Then close browser


    Examples:
      | email | password | product |
      | conta.wel.teste.web@gmail.com | 421563 | mouse sem fio gamer pro m5 |

    @Delete-Product
    Scenario Outline: Delete the product from cart

      Given user click in Faca seu Login

      When insert the correct "<email>" and "<password>"

        And click on cart icon
        And delete the product

      Then I make sure the product was been deleted
      Then close browser

      Examples:
        | email | password |
        | conta.wel.teste.web@gmail.com | 421563 |


