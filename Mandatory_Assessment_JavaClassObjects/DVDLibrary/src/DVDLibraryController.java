import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class DVDLibraryController {
    private DVDLibrary model;
    private DVDLibraryView view;

    public DVDLibraryController(DVDLibrary model, DVDLibraryView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        int choice;
        do {
            view.displayMenu();
            choice = getUserChoice();
            executeChoice(choice);
        } while (choice != 9);
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        try {
            return Integer.parseInt(view.getScanner().nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    private void executeChoice(int choice) {
        switch (choice) {
            case 1:
                DVD newDVD = view.createDVD();
                model.addDVD(newDVD);
                break;
            case 2:
                String titleToRemove = view.promptForTitle();
                DVD dvdToRemove = model.searchByTitle(titleToRemove);
                if (dvdToRemove != null) {
                    model.removeDVD(dvdToRemove);
                } else {
                    System.out.println("DVD not found.");
                }
                break;
            case 3:
                String titleToEdit = view.promptForTitle();
                DVD dvdToEdit = model.searchByTitle(titleToEdit);
                if (dvdToEdit != null) {
                    DVD editDVD = view.createDVD();
                    model.editDVD(dvdToEdit, editDVD);
                } else {
                    System.out.println("DVD not found.");
                }
                break;
            case 4:
                List<DVD> dvdCollection = model.getDVDs();
                view.displayDVDs(dvdCollection);
                break;
            case 5:
                String titleToDisplay = view.promptForTitle();
                DVD dvdToDisplay = model.searchByTitle(titleToDisplay);
                if (dvdToDisplay != null) {
                    view.displayDVDDetails(dvdToDisplay);
                } else {
                    System.out.println("DVD not found.");
                }
                break;
            case 6:
                String titleToSearch = view.promptForTitle();
                DVD dvdFound = model.searchByTitle(titleToSearch);
                if (dvdFound != null) {
                    view.displayDVDDetails(dvdFound);
                } else {
                    System.out.println("DVD not found.");
                }
                break;
            case 7:
                saveDVDCollection();
                break;
            case 8:
                loadDVDCollection();
                break;
            case 9:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }
    private void saveDVDCollection() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("dvds.ser")))) {
            oos.writeObject(model.getDVDs());
            System.out.println("DVD collection saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving DVD collection to file.");
        }
    }

    private void loadDVDCollection() {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("dvds.ser")))) {
            List<DVD> dvds = (List<DVD>) ois.readObject();
            model.setDVDs(dvds);
            System.out.println("DVD collection loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading DVD collection from file.");
        }
    }
}


