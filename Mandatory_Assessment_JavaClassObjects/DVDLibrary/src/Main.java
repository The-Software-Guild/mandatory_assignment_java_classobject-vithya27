public class Main {
        public static void main(String[] args) {
            DVDLibrary model = new DVDLibrary();
            DVDLibraryView view = new DVDLibraryView();
            DVDLibraryController controller = new DVDLibraryController(model, view);

            controller.run();
        }
}
