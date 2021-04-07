package data;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class TestData {

    static Faker faker = new Faker();

    public static final String
            siteUrl = "https://demoqa.com/automation-practice-form",
            headerText = "Student Registration Form";

    public static final SelenideElement
            pageHeaderLocator = $(".practice-form-wrapper"),
            submitButtonLocator = $("#submit"),
            firstNameInputLocator = $("#firstName"),
            lastNameInputLocator = $("#lastName"),
            emailInputLocator = $("#userEmail"),
            phoneLocator = $("#userNumber"),
            subjectInputLocator = $("#subjectsInput"),
            uploadButtonLocator = $("#uploadPicture"),
            parentElementLocatorGender = $("#genterWrapper"),
            parentElementLocatorHobby = $("#hobbiesWrapper"),
            addressInputLocator = $("#currentAddress"),
            stateInputLocator = $("#react-select-3-input"),
            cityInputLocator = $("#react-select-4-input"),
            dateOfBirthInputLocator = $("#dateOfBirthInput"),
            birthYearLocator = $(".react-datepicker__year-select"),
            birthMonthLocator = $(".react-datepicker__month-select"),
            modalForCheckingLocator = $(".table-responsive"),
            closeLargeModalLocator = $("#closeLargeModal");

    public static final Map<String, String> studentData = new HashMap<String, String>() {{

        put("First Name", faker.name().firstName());
        put("Last Name", faker.name().lastName());
        put("Email", faker.internet().emailAddress());
        put("Mobile Phone", faker.numerify("##########"));
        put("Short Subject 1", "Hi");
        put("Short Subject 2", "Co");
        put("Subject 1", "History");
        put("Subject 2", "Computer Science");
        put("Year of Birth", String.valueOf(faker.number().numberBetween(1990, 2003)));
        put("Day of Birth", String.valueOf(faker.number().numberBetween(1, 28)));
        put("Month of Birth", String.valueOf(faker.number().numberBetween(0, 11)));
        put("File Name", "picture.jpg");
        put("Hobby 1", "Sports");
        put("Hobby 2", "Reading");
        put("Gender", "Male");
        put("Address", faker.address().zipCode() + faker.address().country() + faker.address().city() + faker.address().streetName());
        put("State", "NCR");
        put("City", "Delhi");
    }};

    public static String getMonthName(String monthNumber) {
        int numberOfMonth = Integer.parseInt(monthNumber);
        String month = null;
        switch (numberOfMonth) {
            case 0:
                month = "January";
                break;
            case 1:
                month = "February";
                break;
            case 2:
                month = "March";
                break;
            case 3:
                month = "April";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "June";
                break;
            case 6:
                month = "July";
                break;
            case 7:
                month = "August";
                break;
            case 8:
                month = "September";
                break;
            case 9:
                month = "October";
                break;
            case 10:
                month = "November";
                break;
            case 11:
                month = "December";
                break;
        }
        return month;
    }
}
