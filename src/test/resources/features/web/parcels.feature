Feature: Parcels

  Scenario Outline: Search for a parcel
    Given InPost page is open
    When I enter parcel number "<parcel_number>"
    And I click Find button
    Then parcel's last status is equal to "<expected_status>"

    Examples:
      | parcel_number            | expected_status     |
      | 520113014230722029585646 | Delivered           |
      | 520107010449991105638120 | Passed for delivery |
      | 523000016696115042036670 | Label nullified     |
      | 520000011395200025754311 | Delivered           |
