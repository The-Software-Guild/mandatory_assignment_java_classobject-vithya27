import java.util.List;
import java.util.Scanner;

public class DVDLibraryView {
    private Scanner scanner;

    public DVDLibraryView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("DVD Collection Menu");
        System.out.println("1. Add DVD");
        System.out.println("2. Remove DVD");
        System.out.println("3. Edit DVD");
        System.out.println("4. List DVDs");
        System.out.println("5. Display DVD Details");
        System.out.println("6. Search DVD by Title");
        System.out.println("7. Save DVD Collection");
        System.out.println("8. Load DVD Collection");
        System.out.println("9. Exit");
    }

    public DVD createDVD() {
        System.out.print("Enter DVD title: ");
        String title = scanner.nextLine();
        System.out.print("Enter release date: ");
        String releaseDate = scanner.nextLine();
        System.out.print("Enter MPAA rating: ");
        String MPAARating = scanner.nextLine();
        System.out.print("Enter director's name: ");
        String directorName = scanner.nextLine();
        System.out.print("Enter studio: ");
        String studio = scanner.nextLine();
        System.out.print("Enter user rating/note: ");
        String userRatingNote = scanner.nextLine();

        return new DVD(title, releaseDate, MPAARating, directorName, studio, userRatingNote);
    }


    public void displayDVDs(List<DVD> DVDCollection) {
        if (DVDCollection.isEmpty()) {
            System.out.println("No DVDs in the collection.");
        } else {
            System.out.println("DVD Collection:");
            for (DVD dvd : DVDCollection) {
                System.out.println("Title: " + dvd.getTitle());
            }
        }
    }

    public void displayDVDDetails(DVD dvd) {
        System.out.println("DVD Details:");
        System.out.println("Title: " + dvd.getTitle());
        System.out.println("Release Date: " + dvd.getReleaseDate());
        System.out.println("MPAA Rating: " + dvd.getMPAARating());
        System.out.println("Director's Name: " + dvd.getDirectorName());
        System.out.println("Studio: " + dvd.getStudio());
        System.out.println("User Rating/Note: " + dvd.getUserRatingOrNote());
    }

    public String promptForTitle() {
        System.out.print("Enter DVD title: ");
        return scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
