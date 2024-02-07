package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestotomasyonStepdefinitions {

    TestOtomasyonPage testOtomasyonPage=new TestOtomasyonPage();

    @Given("kullanici TestOtomasyon sayfasina gider")
    public void kullanici_test_otomasyon_sayfasina_gider() {


        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    }
    @Given("phone icin arama yapar")
    public void phone_icin_arama_yapar() {

        testOtomasyonPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

    }
    @Then("aradigi urunun bulundugunu test eder")
    public void aradigi_urunun_bulundugunu_test_eder() {

        Assert.assertTrue(testOtomasyonPage.bulunanUrunElementleriList.size()>0);

    }

    @And("sayfayi kapatir")
    public void sayfayi_Kapatir() {
        Driver.quitDriver();
    }

    @And("dress icin arama yapar")
    public void dressIcinAramaYapar() {
        testOtomasyonPage.aramaKutusu.sendKeys("dress"+ Keys.ENTER);
    }

    @And("java icin arama yapar")
    public void javaIcinAramaYapar() {

        testOtomasyonPage.aramaKutusu.sendKeys("java"+Keys.ENTER);

    }

    @Then("aradigi urunun bulunmadigini test eder")
    public void aradigiUrununBulunmadiginiTestEder() {

       String unExpectedSonucYazisi=ConfigReader.getProperty("toUrunBulunamadiYazisi");
       String actualSunuzYazisi=testOtomasyonPage.bulunanUrunSayisiElementi.getText();

       Assert.assertEquals(unExpectedSonucYazisi,actualSunuzYazisi);
    }

    @And("{string} icin arama yapar")
    public void icinAramaYapar(String aranacakUrun) {
        testOtomasyonPage.aramaKutusu.sendKeys(aranacakUrun+Keys.ENTER);
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int beklenecekSure) {
        try {
            Thread.sleep(beklenecekSure*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String configdenIstenenUrl) {

        Driver.getDriver().get(ConfigReader.getProperty(configdenIstenenUrl));

    }
    @Then("account butonuna basar")
    public void account_butonuna_basar() {
      testOtomasyonPage.accountLinki.click();
    }
    @Then("email olarak {string} girer")
    public void email_olarak_girer(String configdenIstenenEmail) {
       testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty(configdenIstenenEmail));
    }
    @Then("password olarak {string} girer")
    public void password_olarak_girer(String configdenIstenenPassword) {
      testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty(configdenIstenenPassword));
    }
    @Then("signIn butonuna basar")
    public void sign_in_butonuna_basar() {
        testOtomasyonPage.loginButonu.click();
    }
    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {

        Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());
    }

    @Then("sisteme giris yapamadigini test eder")
    public void sisteme_giris_yapamadigini_test_eder() {
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
    }


    @When("email olarak listeden {string} girer")
    public void emailOlarakListedenGirer(String siradakiEmail) {
        testOtomasyonPage.emailKutusu.sendKeys(siradakiEmail);
    }

    @And("password olarak listeden {string} girer")
    public void passwordOlarakListedenGirer(String siradakiPassword) {
        testOtomasyonPage.passwordKutusu.sendKeys(siradakiPassword);
    }
}
