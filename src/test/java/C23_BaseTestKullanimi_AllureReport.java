import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


    /**
    * Allure Report Kullanim Notlari:
    * 1. allure-results klasorunun olusmasi icin once testin kosulmus (run) olmasi gerekir.
    * 2. Raporu goruntulemek icin Terminale: 'allure serve allure-results' yazilmalidir.
    */
public class C23_BaseTestKullanimi_AllureReport extends BaseTest {

    @Test
    @Description("Kullanıcı anasayfa başlık kontrolü testi")
    @Severity(SeverityLevel.CRITICAL) // Testin onem derecesi
    public void test() {
        allureStep("Test Otomasyonu sitesine gidiliyor");
        page.navigate("http://www.testotomasyonu.com");

        allureStep("Sayfa başlığının doğruluğu kontrol ediliyor");
        assertThat(page).hasTitle("Test Otomasyonu - Test Otomasyonu");
    }

    @Step("{message}")
    public void allureStep(String message) {
        // Bos olsa bile raporda adim olarak gorunur
        // Bu method : Allure interceptor'ini tetikleyerek parametreyi rapor adimi olarak isler
        // Yani Allure sistemine bir Hook atar. Ben metodu çagirdigimda o kancaya takilir ve Allure'un mekanizmasini calistirip raporu gunceller
    }
}
