import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LMS {

    private ArrayList<Patron> patrons = new ArrayList<>();

    public void loadFromFile(String filePath) {

        try {
            Scanner fileScanner = new Scanner(new File(filePath));

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] parts = line.split("-");

                if (parts.length == 4) {

                    String id = parts[0];
                    String name = parts[1];
                    String address = parts[2];
                    double fine = Double.parseDouble(parts[3]);

                    patrons.add(new Patron(id, name, address, fine));
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void addPatron(Patron patron) {

        for (Patron p : patrons) {
            if (p.getId().equals(patron.getId())) {
                System.out.println("Duplicate ID.");
                return;
            }
        }

        patrons.add(patron);
        System.out.println("Patron added.");
    }

    public void removePatron(String id) {

        for (Patron p : patrons) {
            if (p.getId().equals(id)) {
                patrons.remove(p);
                System.out.println("Patron removed.");
                return;
            }
        }

        System.out.println("Patron not found.");
    }

    public void printPatrons() {

        if (patrons.isEmpty()) {
            System.out.println("No patrons in system.");
            return;
        }

        for (Patron p : patrons) {
            System.out.println(p);
        }
    }
}