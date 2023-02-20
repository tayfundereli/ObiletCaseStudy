Feature: Obilet Case Study

  Background:
    Given Ana sayfayi acilir
    And   Sayfanin dogru sekilde acildigi kontrol edilir

  Scenario: 1. Yeni Üyelik Oluşturulması
    When  Uye giris butonuna tiklanir
    And   Uyelik Pop-Up'inin acildigi gorulur
    And   Uye ol sayfasina gidilir
    And   Mail ve Password alani girilir
      | email                | password       |
      | mesaci2289@aosod.com | SuperPassword1 |
    And   Uye ol butonuna tiklanir
    Then  Yeni kullanicinin basarili sekilde olusturuldugu kontrol edilir


  Scenario: 2. Uçak Bileti Arama
    When  Ucak tabine tiklanir
    And   "Uçak" bileti arama sayfasinin acildigi gorulur
    And   Bir gidis ili ve  donus ili secilir
      | origin | destination |
      | İzmir  | İstanbul    |
    And   Bir gidis tarihi ve donus tarihi secilir
    And   Ucuslardan herhangi bir gidis ucusu secilir
    And   Ucuslardan herhangi bir donus ucusu secilir
    Then  Odeme sayfasinin basarili sekilde acildigi kontrol edilir
    And   Odeme sayfasindaki gidis ve donus ucusunun secilen gidis ve donus ucusu oldugu kontrol edilir