import com.microsoft.playwright.Locator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class C24_SingleFileUpload extends BaseTest {

  @Test
  @Description("Kullanıcı basit dosya yükleme testi")
  @Severity(SeverityLevel.CRITICAL) // Testin önem derecesi
  public void uploadTest() {

    allureStep("Dosya yükleme (Upload) sayfası ziyaret ediliyor");
    page.navigate("https://the-internet.herokuapp.com/upload");

    allureStep("Sisteme yüklenecek olan dosya yolu tanımlanıyor");
    Locator chooseFileButton = page.locator("input[id='file-upload']");
    chooseFileButton.setInputFiles(Paths.get("src/test/java/testInputAndOutput/P12_TestOtomasyonuFullPage.pdf"));

    allureStep("Yükleme işlemi başlatılıyor (Submit)");
    page.locator("input[id='file-submit']").click();

    allureStep("Dosyanın başarıyla yüklendiği doğrulanıyor");
    Locator fileUploadedMessage=page.getByText("File Uploaded!");
    assertThat(fileUploadedMessage).isVisible();

  }

  @Step("{message}")
  public void allureStep(String message) {
    // Bu method : Allure interceptor'ini tetikleyerek parametreyi rapor adimi olarak isler
    // Yani Allure sistemine bir Hook atar. Ben metodu çagirdigimda o kancaya takilir ve Allure'un mekanizmasini calistirip raporu gunceller
  }

}
