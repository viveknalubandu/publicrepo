package demo.test.com.devopsmaniac.mania;




import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import org.apache.commons.io.FileUtils;


import java.net.MalformedURLException;
import java.net.URL;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;


// trying to get screenshot, but not working for me (locally or remotely)

public class ScreenshotTest {
	private static WebDriver driver;

	@Rule
	public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();

	@Test
	public void checkRandomSitePass() throws InterruptedException, MalformedURLException {

//		driver = new RemoteWebDriver(
//                new URL("http://selenium.sndevops.xyz:4444/wd/hub"),
//                DesiredCapabilities.firefox());
		//driver = new FirefoxDriver();

        //Launch the Online Store Website
		driver.get("http://www.google.com");

        // Print a Log In message to the screen
        System.out.println("Successfully opened the website google.com");
        assertEquals(driver.getTitle(), "Google");

		//Wait for 5 Sec
		Thread.sleep(5000);

        // Close the driver
        driver.quit();
	}

	/*@Test
	public void checkRandomSiteFail() throws InterruptedException, MalformedURLException {

		RemoteWebDriver driver = new RemoteWebDriver(
                new URL("http://selenium.sndevops.xyz:4444/wd/hub"),
                DesiredCapabilities.firefox());

        //Launch the Online Store Website
		driver.get("http://www.google.com");

        // Print a Log In message to the screen
        System.out.println("Successfully opened the website google.com");
        assertEquals(driver.getTitle(), "Yahoo");

		//Wait for 5 Sec
		Thread.sleep(5000);

        // Close the driver
        driver.quit();
	}*/

class ScreenshotTestRule implements MethodRule {
    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    captureScreenshot(frameworkMethod.getName());
                    throw t; // rethrow to allow the failure to be reported to JUnit
                }
            }

            public void captureScreenshot(String fileName) {
                try {
					if (driver != null) {
	                    new File("target/surefire-reports/").mkdirs(); // Ensure directory is there
	                    FileOutputStream out = new FileOutputStream("target/surefire-reports/screenshot-" + fileName + ".png");
	                    out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
	                    out.close();
					}



                } catch (Exception e) {
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					e.printStackTrace(pw);
					String sStackTrace = sw.toString(); // stack trace as a string
					System.out.println(sStackTrace);
					System.out.println("failed on screenshot: " + e);
                }
            }
        };
    }
}
}
