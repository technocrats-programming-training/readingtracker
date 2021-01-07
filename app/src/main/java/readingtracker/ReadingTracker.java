package readingtracker;

import java.util.LinkedList;

public class ReadingTracker {
    private LinkedList<Book> wantToRead; // The books you want to read

    private LinkedList<Book> reading;
    private LinkedList<Integer> readingProgress; // The number of pages you have already read in the books you are reading

    private LinkedList<Book> read;

    public ReadingTracker() {
        wantToRead = new LinkedList<Book>();

        reading = new LinkedList<Book>();
        readingProgress = new LinkedList<Integer>();

        read = new LinkedList<Book>();
    }

    public void addToWantToRead(String title, String author, Integer pages) {
        wantToRead.add(new Book(title, author, pages));
    }

    private int getIndex(LinkedList<Book> booklist, String title) {
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).title.equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public void beginReading(String title, Integer startingPoint) {
        Integer index = getIndex(wantToRead, title); // index = 0
        reading.add(wantToRead.get(index));
        readingProgress.add(startingPoint);

        wantToRead.remove(index);
    }

    public void updateProgress(String title, Integer newProgress)
    {
        Integer index = getIndex(reading, title);
        readingProgress.set(index, newProgress);
        if (newProgress == reading.get(index).pages) {
            finishReading(title);
        }
    }

    public void finishReading(String title) {
        Integer index = getIndex(reading, title);
        read.add(reading.get(index));

        reading.remove(index);
        readingProgress.remove(index);
    }

    public String getWantToReadList() {
        String returnString = "Your current Want to Read list: \n";
        for (int i = 0; i < wantToRead.size(); i++) {
            returnString += wantToRead.get(i).title + " by " + wantToRead.get(i).author + ", \n";
        }
        return returnString;
    }

    public String getProgress() {
        String returnString = "Your current reading progress: \n";
        for (int i = 0; i < reading.size(); i++) {
            returnString += reading.get(i).title + " by " + reading.get(i).author + ", Progress:  " + readingProgress.get(i) + "/"+ reading.get(i).pages +", \n";
        }
        return returnString;
    }

    public String getReadList() {
        String returnString = "Books you have read: \n";
        for (int i = 0; i < read.size(); i++) {
            returnString += read.get(i).title + " by " + read.get(i).author + ", \n";
        }
        return returnString;
    }
    
}
