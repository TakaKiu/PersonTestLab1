import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> personRecords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
            int YOB = SafeInput.getRangedInt(scanner, "Enter Year of Birth (1940-2000)", 1940, 2000);

            Person person = new Person(firstName, lastName, id, title, YOB);
            personRecords.add(person);

            boolean continueInput = SafeInput.getYNConfirm(scanner, "Do you want to add another person? (Y/N)");
            if (!continueInput) {
                break;
            }
        }

        String fileName = "PersonTestData.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : personRecords) {
                writer.write(person.toCSVDataRecord());
                writer.newLine();
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the records.");
            e.printStackTrace();
        }

        scanner.close();
    }
}