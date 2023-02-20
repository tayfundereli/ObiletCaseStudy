package Obilet.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Helpers {

    public static WebElement waitElementClickable(By element) {
        WebDriverWait wait = new WebDriverWait(Drivers.get(), 30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitFor(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sendText(String value, double delay, WebElement element) {
        if (delay > 0) {
            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                element.sendKeys(Character.toString(c));
                waitFor(delay);
            }

        } else element.sendKeys(value);
    }

    public static int flightCount(By products) {
        List<WebElement> myElements = Drivers.get().findElements(products);
        return myElements.size();
    }
}
