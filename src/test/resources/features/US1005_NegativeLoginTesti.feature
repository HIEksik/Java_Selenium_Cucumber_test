Feature: US1005  Gecersiz bilgilerle sisteme giris yapilamamali

  @wip
  Scenario: TC11 Gecerli email, gecersiz password ile sisteme giris yapilamaz

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecersizPassword" girer
    Then signIn butonuna basar
    And sisteme giris yapamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir