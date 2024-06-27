// Tara Greene
// PA 4

// Song.java
// Song class that stores the artist, song name, album name, genre, song length, song price and if the lyrics are explicit
public class Song {
  // Fields for storing data pulled into the Song object.
   private String artist;
   private String songName;
   private String albumName;
   private String genre;
   private long duration;
   private double songPrice;
   private boolean isExplicit;
   

   // Constructs the new Song instance
   public Song(String artist, String songName, String albumName, String genre, long durationMillis, double songPrice, boolean isExplicit)
   {
      
      this.artist = artist;
      this.songName = songName;
      this.albumName = albumName;
      this.genre = genre; 
      this.duration = durationMillis;
      this.songPrice = songPrice;
      this.isExplicit = isExplicit;
   } 

  // Getter and setter methods provide access to the song's properties
  // They allow reading and modifying the Song object's state from outside the class

  // Returns the artist's name
   public String getArtist() {
    return artist;
  } 

  // Returns the song's name
  public String getSongName() {
    return songName;
  }
  
  // Returns the album's name
  public String getAlbumName() {
    return albumName;
  }
  
  // Returns the song's genre
  public String getGenre() {
    return genre;
  }
   
   // Returns the song's duration
   // Converts and displays the song duration in  minutes and seconds
   public String getDuration() 
   {
    long minutes = duration / 60000;
    long seconds = (duration % 60000) / 1000;
    return String.format("%d:%02d", minutes, seconds);
   }
   
   // Returns the song's price
   public double getSongPrice() 
   {
     return songPrice;
   }
   
   // Reutrns Yes/No on if the song is explicit
   public String isExplicit() 
   {
    return isExplicit ? "Yes" : "No";
     
   }


   // Setters methods for allowing updating of properties of the Song object being created.

   public void setArtist(String artist) 
   {
     this.artist = artist;
   }

   public void setSongName(String songName) 
   {
     this.songName = songName;
   }
   
   public void setAlbumName(String albumName) 
   {
     this.albumName = albumName;
   }   
   
   public void setGenre(String genre) 
   {
      this.genre = genre;
   } 
     
   public void setDuration(long duration) 
   {
     this.duration = duration;
   }
   
   public void setIsExplicit(boolean isExplicit) 
   {
     this.isExplicit = isExplicit;
   }    
   

   // toString to format and present data pulled into Song object in a clear and readable format.
   @Override
   public String toString() 
   {
    return "Artist: " + artist + "\n" +
           "Song: " + songName + "\n" +
           "Album: " + albumName + "\n" +
           "Genre: " + genre + "\n" +
           "Duration: " + getDuration() + "\n" +
           "Song Price: $" + String.format("%.2f", songPrice) + "\n" +
           "Is Explicit: " + isExplicit();
   }

  }


