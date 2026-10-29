import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // Test Case 1: Homepage Loads
            driver.get("http://localhost:5000/");

            String heading = driver.findElement(By.tagName("h1")).getText();
            assert heading.equals("Event Registration");
            System.out.println("Test 1: Homepage Loads - PASSED");

            // Test Case 2: Submit Form
            driver.findElement(By.name("name")).sendKeys("John Doe");
            driver.findElement(By.name("email"))
                  .sendKeys("john.doe@example.com");

            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Check the response after submitting
            String result = driver.findElement(By.tagName("body")).getText();
            System.out.println("Form response: " + result);

            assert !result.isBlank() : "Empty form response";
            System.out.println("Test 2: Form Submission - PASSED");

        } finally {
            driver.quit();
        }
    }
}