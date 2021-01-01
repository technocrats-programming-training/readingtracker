package readingtracker;

public class App {
    public static void main(String[] args) {
        ReadingTracker myReadingTracker = new ReadingTracker();
        myReadingTracker.addToWantToRead("The Three Body Problem", "Cixin Liu", 243);
        myReadingTracker.addToWantToRead("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 142);
        myReadingTracker.addToWantToRead("Les Miserables", "Victor Hugo", 1426);

        System.out.println(myReadingTracker.getWantToReadList());

        myReadingTracker.beginReading("The Three Body Problem");
        myReadingTracker.beginReading("Les Miserables");

        System.out.println(myReadingTracker.getProgress());

        myReadingTracker.updateProgress("The Three Body Problem", 223);

        System.out.println(myReadingTracker.getProgress());

        myReadingTracker.finishReading("The Three Body Problem");

        System.out.println(myReadingTracker.getReadList());

    }
}