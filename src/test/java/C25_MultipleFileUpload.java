import com.microsoft.playwright.Locator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class C25_MultipleFileUpload extends BaseTest {

    @Test
    @Description("Kullanıcı çoklu dosya yükleme testi")
    @Severity(SeverityLevel.NORMAL) // Testin önem derecesi
    public void uploadTest() throws InterruptedException {

        allureStep("Dosya yükleme (Upload) sayfası ziyaret ediliyor");
        page.navigate("https://demo.automationtesting.in/FileUpload.html");

        /*
        allureStep("Sisteme yuklenecek olan dosyalarin yolu tanimlaniyor")
        1. YOL :Dosya yollarini tanimliyoruz
        Locator browseButton= page.locator("input[id='input-4']");
        browseButton.setInputFiles(new Path[]{Paths.get("src/test/java/testInputAndOutput//P12_TestOtomasyonuFullPage.pdf"),
                                              Paths.get("src/test/java/testInputAndOutput//P12_1.png")});

         */

        // 2. YOL Dosya yollarini tanimliyoruz
        allureStep("Sisteme yüklenecek olan dosyaların yolu tanımlanıyor");
        Locator browseButton= page.locator("input[id='input-4']");

        Path file1 = Paths.get("src/test/java/testInputAndOutput//P12_TestOtomasyonuFullPage.pdf");
        Path file2 = Paths.get("src/test/java/testInputAndOutput//P12_1.png");

        browseButton.setInputFiles(new Path[]{file1, file2});


        allureStep("Seçilen dosyaların yükleme listesinde olduğu doğrulanıyor");
        Locator filePreview = page.locator(".file-preview-thumbnails");
        assertThat(filePreview).containsText("P12_TestOtomasyonuFullPage.pdf");
        assertThat(filePreview).containsText("P12_1.png");

        allureStep("Yükleme işlemi başlatılıyor.Butonun tıklanılabilir olduğu doğrulanıyor ");
        Locator uploadButton=page.getByTitle("Upload selected files");
        assertThat(uploadButton).isEnabled();
        uploadButton.click();

    }

    @Step("{message}")
    public void allureStep(String message) {
        // Bu method : Allure interceptor'ini tetikleyerek parametreyi rapor adimi olarak isler
        // Yani Allure sistemine bir Hook atar. Ben metodu çagirdigimda o kancaya takilir ve Allure'un mekanizmasini calistirip raporu gunceller
    }
}
