@Tag
Feature: Adding Personal Care Products to Cart on Apollo Pharmacy Website

  Background: 
    Given User is on the Apollo Pharmacy website

  #@AddToCart
  #Scenario: Add Personal Care Products to Cart
    #Given User is on the Apollo Pharmacy website
    #When User navigate to the "Personal Care" section under product categories
    #And User click on the desired personal care product
    #And User add the selected products to the cart
    #Then The products should be successfully added to the cart
#
  #@Search
  #Scenario Outline: Search for Any Product
    #Given User is on the Apollo Pharmacy website
    #When User navigate to the "Medicines" section
    #And User click on the search bar to search the medicine
    #And User enters <Medicine> name
    #Then The desired products should be displayed
#
    #Examples: 
      #| Medicine |
      #| Dolo     |
#
  #@FindPharmacy
  #Scenario: Find nearby Apollo Pharmacy Store
    #Given User is on the Apollo Pharmacy website
    #When User navigate to the "Buy Medicines and Essentials"
    #And User click on "Pharmacy near me" button
    #And User enters Pincode of the localityPincode
      #| 400079 |
    #Then the User should see nearby Apollo Pharmacy stores location and other details

  @ApolloProduct
  Scenario: Search for Any Product
    #Given User is on the Apollo Pharmacy website
    When User navigate to the Medicines section
    And User clicks on Apollo Products under Shop By Category
    And User selects Category Filter
    And User selects the Baby Care Category from the given list
    And User Sort the products in ascending price range
    Then the User should see all the products

  @InvalidSortFunction
  Scenario: Invalid Sort functionality
    #Given User is on the Apollo Pharmacy website
    When User navigate to the View All Brands section
    And User selects "L" alphabet to search the brand name
    And User selects "Lakme" brand to view the products
    And User click on sort button dropdown
    And User selects the "Price: High to Low" sorting option
    Then the products should be displayed in descending price range
