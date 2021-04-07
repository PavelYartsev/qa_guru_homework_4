package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Map;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;

public class StudentRegistrationFormPage {

    public void openPageAndCheckHeader(String siteUrl, SelenideElement pageHeaderLocator, String headerText) {
        open(siteUrl);
        checkHeader(pageHeaderLocator, headerText);
    }

    public void fillForm(Map<String, String> studentData) {
        fillTextInput(firstNameInputLocator, studentData.get("First Name"));
        fillTextInput(lastNameInputLocator, studentData.get("Last Name"));
        fillTextInput(emailInputLocator, studentData.get("Email"));
        clickElementWithText(parentElementLocatorGender, studentData.get("Gender"));
        fillTextInput(phoneLocator, studentData.get("Mobile Phone"));
        setDate(dateOfBirthInputLocator, birthYearLocator, birthMonthLocator, studentData.get("Year of Birth"), studentData.get("Month of Birth"), studentData.get("Day of Birth"));
        fillAutocompleteInput(subjectInputLocator, studentData.get("Short Subject 1"), studentData.get("Subject 1"));
        fillAutocompleteInput(subjectInputLocator, studentData.get("Short Subject 2"), studentData.get("Subject 2"));
        clickElementWithText(parentElementLocatorHobby, studentData.get("Hobby 1"));
        clickElementWithText(parentElementLocatorHobby, studentData.get("Hobby 2"));
        uploadFile(uploadButtonLocator, studentData.get("File Name"));
        fillTextInput(addressInputLocator, studentData.get("Address"));
        fillSelectInput(stateInputLocator, studentData.get("State"));
        fillSelectInput(cityInputLocator, studentData.get("City"));
        buttonClick(submitButtonLocator);
    }

    public void checkFilledData(SelenideElement modalForCheckingLocator, Map<String, String> studentData, SelenideElement closeLargeModalLocator) {
        modalForCheckingLocator.shouldHave(text(studentData.get("First Name")), text(studentData.get("Last Name")),
                text(studentData.get("Email")), text(studentData.get("Gender")), text(studentData.get("Mobile Phone")),
                text(studentData.get("Subject 1")), text(studentData.get("Subject 2")), text(studentData.get("Hobby 1")),
                text(studentData.get("Hobby 2")), text(studentData.get("File Name")), text(studentData.get("Address")),
                text(studentData.get("State")), text(studentData.get("City")), text(studentData.get("Day of Birth") + " " + getMonthName(studentData.get("Month of Birth")) + "," + studentData.get("Year of Birth")));
        closeLargeModalLocator.click();
    }

    public void setDate(SelenideElement dateOfBirthInputLocator, SelenideElement birthYearLocator, SelenideElement birthMonthLocator, String year, String month, String day) {
        dateOfBirthInputLocator.click();
        birthYearLocator.selectOptionByValue(year);
        birthMonthLocator.selectOptionByValue(month);
        $(byText(day)).click();
    }

    public void checkHeader(SelenideElement pageHeaderLocator, String headerText) {
        pageHeaderLocator.shouldHave(text(headerText));
    }

    public void buttonClick(SelenideElement buttonLocator) {
        buttonLocator.click();
    }

    public void fillTextInput(SelenideElement textInputLocator, String value) {
        textInputLocator.setValue(value);
    }

    public void fillAutocompleteInput(SelenideElement subjectInputLocator, String shortSubject, String subject) {
        subjectInputLocator.setValue(shortSubject);
        $(byText(subject)).click();
    }

    public void uploadFile(SelenideElement uploadButtonLocator, String fileName) {
        uploadButtonLocator.uploadFromClasspath(fileName);
    }

    public void clickElementWithText(SelenideElement parentElementLocator, String elementText) {
        parentElementLocator.$(byText(elementText)).click();
    }

    public void fillSelectInput(SelenideElement selectInputLocator, String selectInputValue) {
        selectInputLocator.setValue(selectInputValue).pressEnter();
    }

}