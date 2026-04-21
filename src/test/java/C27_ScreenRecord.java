import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Allure Report & Video Recording Notlari:
 * 1. setRecordVideoDir: Videolarin kaydedilecegi klasoru belirler.
 * 2. Video kaydi ancak context.close() yapildiginda dosyaya tam olarak yazilir.
 */

@Epic("Görsel Kayıt Sistemleri") // En ust seviye baslik
@Feature("Video Kayıt Özelliği") // Ozellik basligi
public class C27_ScreenRecord extends BaseTest {

    @Test
    @Story("Kullanıcı tarayıcı işlemlerini videoya alabilmeli") // Spesifik senaryo
    @Description("Kullanıcı işlemlerinin video kaydına alınması testi")
    @Severity(SeverityLevel.MINOR)
    @Issue("QA-456") // Eger bir bug report linkin varsa buraya
    public void videoRecordTest() {

        // Video kaydi icin ozel bir context olusturuyoruz
        allureStep("Video kayıt ayarları yapılandırılıyor ve yeni context açılıyor");
        String dosyaYolu = "target/videos";

        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get(dosyaYolu))
                .setRecordVideoSize(1280, 720)); // Standart HD boyut daha net olur

        // ONEMLİ: BaseTest'ten gelen 'page' yerine bu context'e bagli yeni bir 'page' olusturmalıyız
        Page recordPage = context.newPage();

        allureStep("Test Otomasyonu sitesine gidiliyor");
        recordPage.navigate("https://www.testotomasyonu.com");

        allureStep("Menü ikonuna tıklanıyor");
        recordPage.locator(".menu-icon-text").first().click();

        allureStep("Sayfa başlığı doğrulanıyor");
        assertThat(recordPage).hasTitle("Test Otomasyonu");

        allureStep("Video kaydı sonlandırılıyor ve dosya kaydediliyor");
        // Video dosyasinin tam olusmasi icin context'in kapanmasi sarttir!
        context.close();

        // Kaydedilen videonun yolunu konsola yazdiralim (opsiyonel)
        System.out.println("Video kaydedildi: " + recordPage.video().path());
    }
    @Step("{message}")
    public void allureStep(String message) {
        // Bu method : Allure interceptor'ını tetikleyerek parametreyi rapor adimi olarak isler.
        // Yani Allure sistemine bir Hook atar. Ben metodu çagirdigimda o kancaya takilir ve Allure'un mekanizmasını calistirip raporu gunceller.
    }

}