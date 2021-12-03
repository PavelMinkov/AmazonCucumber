Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks logo visibility
    And User checks location visibility
    And User checks search field visibility
    And User checks language field visibility
    And User checks orders visibility
    And User checks cart visibility
    And User checks main navigation visibility
    And User checks 'Menu Hamburger' visibility
    When User click 'Menu Hamburger' button
    And User checks menu popup visibility
    When User close 'Main Navigation' button
    And User checks footer visibility
    And User checks account list visibility
    When User click account List
    And User checks email or mobile field visibility
    And User click 'Continue' button
    Then User checks that sign in form have '<warning>'

    Examples:
      | homePage               | warning                                 |
      | https://www.amazon.com | Enter your email or mobile phone number |

  Scenario Outline: Check url contains keyword
    Given User opens '<homePage>' page
    And User input '<keyword>' in search field
    When User click search button
    Then User checks that current url contains'<search>'

    Examples:
      | homePage               | keyword | search |
      | https://www.amazon.com | jeans   | jeans  |
      | https://www.amazon.com | cap     | cap    |

  Scenario Outline: Check language site change
    Given User opens '<homePage>' page
    And User checks language field visibility
    When User click language button
    And User click language radio <keyword> button
    And User click 'Save changes' button
    Then User checks that current url contains '<search>' language

    Examples:
      | homePage               | keyword | search |
      | https://www.amazon.com | 1       | es     |
      | https://www.amazon.com | 3       | de     |

  Scenario Outline: Check change currency product
    Given User opens '<homePage>' page
    And User input '<keyword>' in search field
    When User click search button
    And User click language button
    And User click currency button
    And User choose currency <keywordCurrency> and click button
    And User click 'Save changes' button
    Then User checks that currency product contains'<search>'

    Examples:
      | homePage               | keyword | keywordCurrency | search |
      | https://www.amazon.com | belt    | 23              | EUR    |
      | https://www.amazon.com | cap     | 51              | GBP    |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks main navigation visibility
    When User click 'Menu Hamburger' button
    And User checks menu popup visibility
    And User click 'Computers' button
    And User checks menu popup visibility
    And User click 'ComputersAndTablets' button
    And User choose product and click
    And User click 'Add to Cart' button on product
    And User click 'Cart' button
    And User checks cart visibility
    Then User checks that amount in cart correct'<amount>'

    Examples:
      | homePage               | amount |
      | https://www.amazon.com | 1      |

  Scenario Outline: Check add more one product to cart
    Given User opens '<homePage>' page
    And User checks main navigation visibility
    When User click 'Menu Hamburger' button
    And User checks menu popup visibility
    And User click 'Computers' button
    And User checks menu popup visibility
    And User click 'ComputersAndTablets' button
    And User choose product and click
    And User click 'Add to Cart' button on product
    And User click 'Cart' button
    And User checks cart visibility
    Then User click 'logo' button
    When User click 'Menu Hamburger' button
    And User checks menu popup visibility
    And User click 'Computers' button
    And User checks menu popup visibility
    And User click 'ComputersAndTablets' button
    And User choose product and click
    And User click 'Add to Cart' button on product
    And User click 'Cart' button
    And User checks cart visibility
    Then User checks that amount in cart correct'<amount>'

    Examples:
      | homePage               | amount |
      | https://www.amazon.com | 2      |

  Scenario Outline: Check remove product from cart
    Given User opens '<homePage>' page
    And User checks main navigation visibility
    When User click 'Menu Hamburger' button
    And User checks menu popup visibility
    And User click 'Computers' button
    And User click 'ComputersAndTablets' button
    And User choose product and click
    And User click 'Add to Cart' button on product
    And User click 'Cart' button
    When User click 'Delete' button on product
    And User checks cart visibility
    Then User checks that amount in cart correct'<amount>'

    Examples:
      | homePage               | amount |
      | https://www.amazon.com | 0      |

  Scenario Outline: Check add product to cart to different location
    Given User opens '<homePage>' page
    And User checks main navigation visibility
    And User click search button
    When User click 'Gift Cards' button
    And User click Greeting Card checkbox
    And User choose product from 'Greeting Card' and click
    Then User click 'Delivery' button
    And User click delivery radio group
    And User click different location
    Then User click 'Continue Delivery' button
    And User click 'Add to Cart' button on product
    And User click 'Cart' button
    And User checks cart visibility
    Then User checks that amount in cart correct'<amount>'

    Examples:
      | homePage               | amount |
      | https://www.amazon.com | 1      |

  Scenario Outline: Check registration form contain data is incorrect
    Given User opens '<homePage>' page
    And User checks account list visibility
    And User click account List
    And User click 'Create account' button
    And User put email field '<email>'
    And User put password field '<password>'
    When User click 'Create your account' button
    Then User checks that password field contain data is incorrect '<warningPassword>'
    Then User checks that email field contain data is incorrect '<warningEmail>'

    Examples:
      | homePage               | email     | password | warningEmail                | warningPassword                          |
      | https://www.amazon.com | incorrect | 12       | Enter a valid email address | Passwords must be at least 6 characters. |

  Scenario Outline: Check add product to 'Wish List'
    Given User opens '<homePage>' page
    And User checks dropdown 'All' visibility
    When User click dropdown 'All'
    And User choose and click category 'Girls' Fashion'
    And User input '<keyword>' in search field
    When User click search button
    And User choose shoes and click
    And User choose and click size shoes
    And User choose and click <quantity>
    And User click 'Add to Cart' button on product
    And User click 'Cart' button
    And User checks cart visibility
    And User click 'Save For Later' button on product
    Then User checks that 'Wish List' contain '<search>'
    Then User checks that amount in cart correct'<amount>'

    Examples:
      | homePage               | keyword | quantity | search |amount|
      | https://www.amazon.com | shoes   |     1    | 1 item | 0    |


  Scenario Outline: Check contain brand in descriptions product
    Given User opens '<homePage>' page
    And User input '<keyword>' in search field
    When User click search button
    And User click 'See more Brand'
    And User click '<Brand>' checkbox
    Then User checks brand'<search>'

    Examples:
      | homePage               | keyword | Brand    | search   |
      | https://www.amazon.com | shoes   | adidas   | adidas   |
      | https://www.amazon.com | shoes   | Skechers | Skechers |
      | https://www.amazon.com | shoes   | PUMA     | PUMA     |
      | https://www.amazon.com | shoes   | Crocs    | Crocs    |

  Scenario Outline: Check filter price product
    Given User opens '<homePage>' page
    And User input '<keyword>' in search field
    When User click search button
    And User click 'Filter Price' checkbox <number>
    Then User checks price

    Examples:
      | homePage               | keyword | number |
      | https://www.amazon.com | shoes   |   3    |

  Scenario Outline: Check summa price product
    Given User opens '<homePage>' page
    And User checks main navigation visibility
    When User click 'Menu Hamburger' button
    And User checks menu popup visibility
    And User click 'Computers' button
    And User checks menu popup visibility
    And User click 'ComputersAndTablets' button
    And User choose product and click
    And User choose and click <quantity>
    And User click 'Add to Cart' button on product
    And User click 'Cart' button
    And User checks cart visibility
    Then User checks summa price <quantity>

    Examples:
      | homePage               |quantity|
      | https://www.amazon.com |    2   |
      | https://www.amazon.com |    3   |
