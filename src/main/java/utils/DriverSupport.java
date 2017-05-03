package utils;


import org.im4java.core.CompareCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverSupport {
    private static WebDriver driver;

    public static WebDriver initDriver(String browser) {
        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equals("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equals("safari")) {

            driver = new SafariDriver();

        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

//    public static File takeScreenshot() throws IOException {
//        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File dst = new File("/Users/Tarik/Desktop/new-screenshot.png");
//        FileUtils.copyFile(src, dst);
//
//        return dst;
//    }
//
//    public static void generatePdiff(File refImg, File newImg) throws InterruptedException, IOException, IM4JavaException {
//        CompareCmd compare = new CompareCmd();
//
//        IMOperation imOperation = new IMOperation();
//
//        imOperation.metric("mae");
//
//        imOperation.addImage(refImg.getAbsolutePath());
//        imOperation.addImage(newImg.getAbsolutePath());
//        imOperation.addImage("/Users/Tarik/Desktop/diff.png");
//
//        compare.run(imOperation);
//    }
}
