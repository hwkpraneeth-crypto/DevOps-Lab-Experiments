import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get(new File("program.html").toURI().toString());

            driver.findElement(By.id("increment-button")).click();

            String result = driver.findElement(By.id("output")).getText();

            assert result.equals("1");

            System.out.println("Experiment 11: TEST PASSED");
        } finally {
            driver.quit();
        }
    }
}