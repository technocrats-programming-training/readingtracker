package readingtracker;

import java.util.LinkedList;

public class ReadingTracker {
    private LinkedList<String> wantToReadTitles; // The titles of the books you want to read
    private LinkedList<String> wantToReadAuthors; // The authors of the books you want to read
    private LinkedList<Integer> wantToReadPages; // The number of pages in each book you want to read.

    private LinkedList<String> readingTitles;
    private LinkedList<String> readingAuthors;
    private LinkedList<Integer> readingPages; 
    private LinkedList<Integer> readingProgress; // The number of pages you have already read in the books you are reading

    private LinkedList<String> readTitles;
    private LinkedList<String> readAuthors;
    private LinkedList<Integer> readPages;

    public ReadingTracker() {
        wantToReadTitles = new LinkedList<String>();
        wantToReadAuthors = new LinkedList<String>();
        wantToReadPages = new LinkedList<Integer>();

        readingTitles = new LinkedList<String>();
        readingAuthors = new LinkedList<String>();
        readingPages = new LinkedList<Integer>();
        readingProgress = new LinkedList<Integer>();

        readTitles = new LinkedList<String>();
        readAuthors = new LinkedList<String>();
        readPages = new LinkedList<Integer>();
    }

    public void addToWantToRead(String title, String author, Integer pages) {
        wantToReadTitles.add(title);
        wantToReadAuthors.add(author);
        wantToReadPages.add(pages);
    }

    public void beginReading(String title) {
        Integer index = wantToReadTitles.indexOf(title); // index = 0
        readingTitles.add(wantToReadTitles.get(index));
        readingAuthors.add(wantToReadAuthors.get(index));
        readingPages.add(wantToReadPages.get(index));
        readingProgress.add(0);

        wantToReadTitles.remove(index);
        wantToReadAuthors.remove(index);
        wantToReadPages.remove(index);
    }

    public void updateProgress(String title, Integer newProgress)
    {
        Integer index = readingTitles.indexOf(title);
        readingProgress.set(index, newProgress);
        if (newProgress == readingPages.get(index)) {
            finishReading(title);
        }
    }

    public void finishReading(String title) {
        Integer index = readingTitles.indexOf(title);
        readTitles.add(readingTitles.get(index));
        readAuthors.add(readingAuthors.get(index));
        readPages.add(readingPages.get(index));

        readingTitles.remove(index);
        readingAuthors.remove(index);
        readingPages.remove(index);
    }

    public String getWantToReadList() {
        String returnString = "Your current Want to Read list: \n";
        for (int i = 0; i < wantToReadTitles.size(); i++) {
            returnString += wantToReadTitles.get(i) + " by " + wantToReadAuthors.get(i) + ", \n";
        }
        return returnString;
    }

    public String getProgress() {
        String returnString = "Your current reading progress: \n";
        for (int i = 0; i < readingTitles.size(); i++) {
            returnString += readingTitles.get(i) + " by " + readingAuthors.get(i) + ", Progress:  " + readingProgress.get(i) + "/"+ readingPages.get(i) +", \n";
        }
        return returnString;
    }

    public String getReadList() {
        String returnString = "Books you have read: \n";
        for (int i = 0; i < readTitles.size(); i++) {
            returnString += readTitles.get(i) + " by " + readAuthors.get(i) + ", \n";
        }
        return returnString;
    }
    
}
