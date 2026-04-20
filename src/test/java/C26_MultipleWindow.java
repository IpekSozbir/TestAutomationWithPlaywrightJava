import com.microsoft.playwright.Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class C26_MultipleWindow extends BaseTest {

    @Test
    @Description("Kullanıcı çoklu pencere (Popup) yönetimini test eder")
    @Severity(SeverityLevel.NORMAL)
    public void multipleWindowTest() {

        allureStep("Browser Windows test sayfası ziyaret ediliyor");
        page.navigate("https://demoqa.com/browser-windows");

        allureStep("Yeni pencere açılması bekleniyor ve butona tıklanıyor");
        // waitForPopup, tiklama sonrasi acilacak olan pencereyi bir "popup" objesi olarak yakalar
        //NOT: tek bir yeni sayfa/tab aciliyorsa bu lambda kod yeterlidir.
        Page popup = page.waitForPopup(() -> {
            page.getByText("New Window").first().click();
        });

        /*
        Not:Eğer tikladigin buton bazen 2-3 pencereyi birden tetikliyorsa veya sayfanin acilmasi cok karmasik
         sartlara bagliysa bu Predicate (kosul) yapisini kullanabiliriz.

                Page popup = page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
                p->p.context().pages().size()==2),()->{page.getByText("New Window").first().click();}
        );
         */

        allureStep("Yeni açılan pencerenin URL'si doğrulanıyor");
        assertThat(popup).hasURL("https://demoqa.com/sample");
        System.out.println("Ana sayfanın URL'i: "+page.url());
        System.out.println("Açılan New window'un URL'i: "+popup.url());

        allureStep("Yeni pencere içindeki başlık metni doğrulanıyor");
        assertThat(popup.locator("#sampleHeading")).hasText("This is a sample page");

        allureStep("Toplam açık olan sayfa sayısı kontrol ediliyor");
        List<Page> allPages = popup.context().pages();
        System.out.println("Toplam sayfa sayısı: " + allPages.size());

        // Basit bir Java dogrulamasi (Opsiyonel)
        assert allPages.size() == 2 : "Sayfa sayısı beklenen (2) adet değil!";

        allureStep("Yeni pencere kapatılıyor ve ana sayfaya dönülüyor");
        popup.close();

        // Ana sayfanin hala orada oldugunu dogrulayalim
        assertThat(page).hasURL("https://demoqa.com/browser-windows");


    }

    @Step("{message}")
    public void allureStep(String message) {
        // Bu method : Allure interceptor'ini tetikleyerek parametreyi rapor adimi olarak isler
        // Yani Allure sistemine bir Hook atar. Ben metodu çagirdigimda o kancaya takilir ve Allure'un mekanizmasini calistirip raporu gunceller
    }

}
