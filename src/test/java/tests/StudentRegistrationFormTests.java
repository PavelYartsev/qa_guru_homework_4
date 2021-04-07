package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static data.TestData.*;

public class StudentRegistrationFormTests {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillStudentRegistrationForm() {
        studentRegistrationFormPage.openPageAndCheckHeader(siteUrl, pageHeaderLocator, headerText);
        studentRegistrationFormPage.fillForm(studentData);
        studentRegistrationFormPage.checkFilledData(modalForCheckingLocator,studentData,closeLargeModalLocator);
    }
}
