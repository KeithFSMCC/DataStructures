/**
 * File: Song.java
 * **********************************************************************
 *                     Revision History (newest first)
 ************************************************************************
 *
 * 8.2016 - Anne Applin - formatting and JavaDoc skeletons added   
 * 2015 -   Prof. Bob Boothe - Starting code and main for testing  
 ************************************************************************
 */
package student;

import java.util.*;

/**
 * Song class to hold strings for a song's artist, title, and lyrics
 * Do not add any methods for part 1, just implement the ones that are 
 * here.
 * @author boothe
 */
public class Song implements Comparable {
       // private fields

    //Author Keith added private fields artist, title, lyrics so each Song object can store its required information
    // Author keith These fields are required so the constructor and getters can function properly

private String artist;
private String title;
private String lyrics;
    /**
     * Parameterized constructor
     * @param artist the author of the song
     * @param title the title of the song
     * @param lyrics the lyrics as a string with linefeeds embedded
     */


//Author Keith Implemented to store provided values into private fields the null inputs replaced with empty strings to avoid possible crashes
// auhtor keith added constructor to initialize the Song object.

    public Song(String artist, String title, String lyrics) {
      
        this.artist = (artist == null) ? "" : artist;
        this.title  = (title  == null) ? "" : title;
        this.lyrics = (lyrics == null) ? "" : lyrics;
    }

    /**
     *
     * @return
     */
    
    //Author Keith Returns the artist field and Implemented so calling code can access the private value
    public String getArtist() {
               return artist;
 
    }

    /**
     *
     * @return
     */
    
    //author keith Returns the lyrics field so external classes can retrieve song lyrics.

    public String getLyrics() {
        return lyrics;
    }

    /**
     *
     * @return
     */
    
    //author keith added so calling code to access the private title field, 'return title'
    public String getTitle() {
         return title;
        
    }

    /**
     * returns name and title ONLY on one line in the form:
     * artist, "title"
     * @return a formatted string with comma and quotes added
     */
    
    //author keith, implemented song objects to print in a consistent, organized format for testing and the gui
    // author keith Implemented to return a formatted string in the form: artist, "title".
    public String toString() {
         return artist + ", \"" + title + "\"";
    }

    /**
     * the default comparison of songs
     * primary key: artist, secondary key: title
     * used for sorting and searching the song array
     * if two songs have the same artist and title they are considered the same
     * @param song2
     * @return a negative number, positive number or 0 depending on whether 
     *    this song should be  before, after or is the same.  Used for a
     *    "natural" sorting order.  In this case first by author then by 
     *    title so that the all of an artist's songs are together, 
     *    but in alpha order.  Follow the given example.
     */
    
    //author keith implemented to provide natural ordering so arrays of songs can be sorted
    //author keith  This ensures sorting groups songs by artist, then orders by title.
    @Override
    public int compareTo(Object that) {
      if (that == null) return -1;    
        Song other = (Song) that;
        int byArtist = this.artist.compareToIgnoreCase(other.artist);
        if (byArtist != 0) return byArtist;
        return this.title.compareToIgnoreCase(other.title);  
        
    }

 
    /**
     * testing method to unit test this class
     * @param args
     */
    public static void main(String[] args) {
        Song s1 = new Song("Professor B",
                "Small Steps",
                "Write your programs in small steps\n"
                + "small steps, small steps\n"
                + "Write your programs in small steps\n"
                + "Test and debug every step of the way.\n");

        Song s2 = new Song("Brian Dill",
                "Ode to Bobby B",
                "Professor Bobby B., can't you see,\n"
                + "sometimes your data structures mystify me,\n"
                + "the biggest algorithm pro since Donald Knuth,\n"
                + "here he is, he's Robert Boothe!\n");

        Song s3 = new Song("Professor B",
                "Debugger Love",
                "I didn't used to like her\n"
                + "I stuck with what I knew\n"
                + "She was waiting there to help me,\n"
                + "but I always thought print would do\n\n"
                + "Debugger love .........\n"
                + "Now I'm so in love with you\n");

        System.out.println("testing getArtist: " + s1.getArtist());
        System.out.println("testing getTitle: " + s1.getTitle());
        System.out.println("testing getLyrics:\n" + s1.getLyrics());

        System.out.println("testing toString:\n");
        System.out.println("Song 1: " + s1);
        System.out.println("Song 2: " + s2);
        System.out.println("Song 3: " + s3);

        System.out.println("testing compareTo:");
        System.out.println("Song1 vs Song2 = " + s1.compareTo(s2));
        System.out.println("Song2 vs Song1 = " + s2.compareTo(s1));
        System.out.println("Song1 vs Song3 = " + s1.compareTo(s3));
        System.out.println("Song3 vs Song1 = " + s3.compareTo(s1));
        System.out.println("Song1 vs Song1 = " + s1.compareTo(s1));
    }
}


