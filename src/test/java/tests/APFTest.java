package tests;

import config.TestBase;
import methods.APFPage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static methods.APFPage.parseDate;

public class APFTest extends TestBase {

    private static final String MAIN_URL = "https://demoqa.com/automation-practice-form";
    private static String
            firstName = "Дмитрий",
            lastName = "Эксперимент",
            email = "Test@mail.ru",
            gender = "Male",
            mobile = "8919123456",
            date = "01.01.1994",
            subject = "Biology",
            hobby1 = "Reading",
            hobby2 = "Music",
            file = "test upload.jpg",
            address = "Уфа",
            state = "Uttar Pradesh",
            city = "Lucknow";

    APFPage testAPF = new APFPage();
    static Map<String, String> attributeList = new HashMap<>();

    public static Map<String, String> createMap() {
        attributeList.put("Student Name", firstName + " " + lastName);
        attributeList.put("Student Email", email);
        attributeList.put("Gender", gender);
        attributeList.put("Mobile", mobile);
        attributeList.put("Date of Birth", parseDate(date));
        attributeList.put("Subjects", subject);
        attributeList.put("Hobbies", hobby1 + ", " + hobby2);
        attributeList.put("Picture", file);
        attributeList.put("Address", address);
        attributeList.put("State and City", state + " " + city);
        return attributeList;
    }

    @Test
    void automationPracticeForm() {
        testAPF.openUrl(MAIN_URL)
                .enterText("First Name", firstName)
                .enterText("Last Name", lastName)
                .enterText("name@example.com", email)
                .selectGender(gender)
                .enterText("Mobile Number", mobile)
                .enterDate(date)
                .enterSubject(subject)
                .selectHobby(hobby1)
                .selectHobby(hobby2)
                .uploadFile(new File("src/test/resources/" + file))
                .currentAddress(address)
                .selectState("Select State", state)
                .selectState("Select City", city)
                .submit()
                .equalAttribute(createMap());
    }
}

