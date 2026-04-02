import com.microsoft.playwright.*;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class C17_Iframe {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        page.setViewportSize(width,height);

        page.navigate("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_textarea");

        // iframe icine girelim
        FrameLocator iframe = page.frameLocator("#iframeResult");

        Locator textarea = iframe.locator("textarea");
        assertThat(textarea).isVisible();
        Thread.sleep(1000);

        textarea.clear();
        Thread.sleep(1000);

        textarea.fill("Merhaba!");
        Thread.sleep(1000);


        page.close();
        browser.close();
        playwright.close();

    }
}
