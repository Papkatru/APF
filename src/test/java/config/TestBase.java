package config;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "2560x1440";
        Configuration.browserPosition = "0x0";
        Configuration.holdBrowserOpen = true;
    }
}



