package methods;


import org.openqa.selenium.Keys;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class APFPage {


    public APFPage openUrl(String url) {
        open(url);
        return this;
    }

    public APFPage enterText(String placeHolder, String value) {
        String field = "//input[@placeholder='%s']";
        String selector = String.format(field, placeHolder);
        $x(selector).setValue(value);
        return this;
    }

    public APFPage selectGender(String gender) {
        String field = "//input[@value='%s']/../label";
        String selector = String.format(field, gender);
        $x(selector).click();
        return this;
    }

    public APFPage enterDate(String data) {
        Date date = new Date();
        SimpleDateFormat nowDate = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        String field = "//input[@value='%s']";
        String selector = String.format(field, nowDate.format(date));
        $x(selector).sendKeys(Keys.CONTROL + "a");
        $x(selector).sendKeys(data + Keys.ENTER);
        return this;
    }

    public static String parseDate(String s) {
        LocalDate date = LocalDate.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String actualDate = date.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", new Locale("en")));
        return actualDate;
    }

    public APFPage enterSubject(String subject) {
        $x("//input[@id='subjectsInput']").setValue(subject).pressEnter();
        return this;
    }

    public APFPage selectHobby(String hobby) {
        $x("//label[text()='" + hobby + "']").click();
        return this;
    }

    public APFPage uploadFile(File fileName) {
        $x("//input[@type=\"file\"]").uploadFile(fileName);
        return this;
    }

    public APFPage currentAddress(String address) {
        $x("//textarea[@placeholder='Current Address']").setValue(address);
        return this;
    }

    public APFPage selectState(String stateField, String state) {
        String selector = String.format("//div[text()='%s']", stateField);
        String value = String.format("//div[text()='%s']", state);
        $x(selector).click();
        $x(value).click();
        return this;
    }

    public APFPage submit() {
        $("#submit").click();  // CSS
        return this;
    }

    public APFPage equalAttribute(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String field = "//td[text()='%s']/../td[text()='%s']";
            String selector = String.format(field, entry.getKey(), entry.getValue());
            $x(selector).shouldBe(exist);
        }
        return this;
    }
}
