package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    // Raporlama Nesneleri: Statik yapi sayesinde tum test siniflari ayni rapor objesini kullanir
    protected static ExtentReports extent = ExtentManager.getInstance();
    protected static ExtentTest test;



    @BeforeAll
    static void setupReport() {
        // Global rapor hazirliklari buraya gelebilir
    }
    @BeforeEach
    void setup(TestInfo testInfo) {

        logger.info(">>> Test başlıyor: {}", testInfo.getDisplayName());


        // Extent Report: Her test metodu icin raporda yeni bir "Test Case" alani olusturur
        test = extent.createTest(testInfo.getDisplayName());

        // Grafikleri tetiklemek icin en az bir INFO logu dusmeliyiz
        test = extent.createTest(testInfo.getDisplayName());
        test.info("Test hazırlıkları tamamlanıyor...");

        // Dinamik Ekran Cozunurlugu: Testlerin çalışacagi pencere boyutunu sistem çozunurlugune gore ayarlar
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.setViewportSize(screenSize.width, screenSize.height);

        // Timeout'u 60 yapmak yerine 30'da bırakip, navigate ederken strateji belirlemek daha profesyoneldir
        page.setDefaultNavigationTimeout(50000);
        test.pass("Tarayıcı ve Playwright hazır.");    }

    @AfterEach
    void teardown(TestInfo testInfo) {
        try {
            // Allure & Extent: Test sonunda tam sayfa ekran goruntusu alip raporlara ekler
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            saveScreenshot(testInfo.getDisplayName(), screenshot);
            test.info("Ekran görüntüsü alındı.");
        } catch (Exception e) {
            logger.error("Ekran görüntüsü alınırken hata oluştu: " + e.getMessage());
        }

        // Tarayıcı ve Playwright kaynaklarini guvenli bir sekilde kapatir
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

        // Extent Report: Verileri fiziksel HTML dosyasina yazar (Flush)
        extent.flush();
        logger.info("Test tamamlandı, kaynaklar kapatıldı.");
    }

    // Allure Attachment: Alinan byte dizisi halindeki ekran goruntusunu Allure raporuna baglar
    @Attachment(value = "{name}", type = "image/png")
    public byte[] saveScreenshot(String name, byte[] screenshot) {
        return screenshot;
    }

}