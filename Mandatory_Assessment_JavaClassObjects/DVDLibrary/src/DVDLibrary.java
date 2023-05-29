import java.util.ArrayList;
import java.util.List;

public class DVDLibrary {
    private List<DVD> DVDCollection;

    public DVDLibrary() {
        DVDCollection = new ArrayList<>();
    }

    public void addDVD(DVD dvd) {
        DVDCollection.add(dvd);
    }

    public void removeDVD(DVD dvd) {
        DVDCollection.remove(dvd);
    }

    public void editDVD(DVD oldDVD, DVD newDVD) {
        int index = DVDCollection.indexOf(oldDVD);
        if (index != -1) {
            DVDCollection.set(index, newDVD);
        }
    }

    public List<DVD> getDVDs() {
        return DVDCollection;
    }

    public void setDVDs(List<DVD> dvds) {
        this.DVDCollection = dvds;
    }

    public DVD searchByTitle(String title) {
        for (DVD dvd: DVDCollection) {
            if (dvd.getTitle().equals(title)) {
                return dvd;
            }
        } return  null;
    }


}
