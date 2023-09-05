import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        ArrayList<Person> personRecords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the file to read: ");
        String fileName = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(", ");
                if (data.length == 5) {
                    String id = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String title = data[3];
                    int YOB = Integer.parseInt(data[4]);

                    Person person = new Person(firstName, lastName, id, title, YOB);
                    personRecords.add(person);
                } else {
                    System.out.println("Invalid record format: " + line);
                }
            }

            // Display the read records
            for (Person person : personRecords) {
                System.out.println(person);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        scanner.close();
    }
}