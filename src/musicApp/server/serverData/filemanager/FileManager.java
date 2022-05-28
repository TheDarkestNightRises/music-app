package musicApp.server.serverData.filemanager;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class FileManager
{
  public static FileManager instance;

  private FileManager()
  {
  }

  public synchronized static FileManager getInstance()
  {
    if (instance == null)
    {
      return new FileManager();
    }
    return instance;
  }

  public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist)
  {
    ArrayList<File> songsFiles = new ArrayList<>();
    for (Song song : playlist.getSongs())
    {
      String songFilePath = song.getFile_path();
      if (songFilePath != null)
      {
        File file = new File("src/musicApp/server/serverData/Music/" + songFilePath);
        songsFiles.add(file);
      }
    }
    return songsFiles;
  }

  public byte[] fetchPhotoFromProfile(String picturePath)
  {
    if (picturePath == null || picturePath.equals(""))
      picturePath = "default_pfp.jpg";
    String path = "../ProfilePictures/" + picturePath;
    System.out.println(path);
    return extractPhoto(path);
  }

  public byte[] fetchPhotoFromAlbum(String picturePath)
  {
    if (picturePath == null || picturePath.equals(""))
      picturePath = "default_album.png";
    String path = "../AlbumPictures/" + picturePath;
    System.out.println(path);
    return extractPhoto(path);
  }

  public byte[] extractPhoto(String picturePath)
  {
    System.out.println(picturePath);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    URL url = getClass().getResource(picturePath);
    BufferedImage image = null;
    try
    {
      image = ImageIO.read(url);
      ImageIO.write((RenderedImage) image, "png", byteArrayOutputStream);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return byteArrayOutputStream.toByteArray();
  }

  public void writePhoto(byte[] bytes, String path)
  {

    try
    {
      ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
      BufferedImage bImage2 = ImageIO.read(bis);
      ImageIO.write(bImage2, "png", new File(path));
    }
    catch (IOException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not write file");
    }
  }

  public void uploadProfilePicture(String pictureName, byte[] bytes)
  {
    String path = "src/musicApp/server/serverData/ProfilePictures/" + pictureName;
    writePhoto(bytes, path);
  }

  public void uploadAlbumPicture(String pictureName, byte[] toByteArray)
  {
    String path = "src/musicApp/server/serverData/AlbumPictures/" + pictureName;
    writePhoto(toByteArray, path);
  }

  public void uploadAlbumPictureInOut(String pictureName, byte[] toByteArray)
  {
    String path = "out/production/music-app/musicApp/server/serverData/AlbumPictures/" + pictureName;
    writePhoto(toByteArray, path);
  }

  public void uploadProfilePictureInOut(String pictureName, byte[] bytes)
  {
    String path = "out/production/music-app/musicApp/server/serverData/ProfilePictures/" + pictureName;
    writePhoto(bytes, path);
  }

  public void uploadSong(String songName, byte[] songBytes) throws Exception
  {
    String path = "src/musicApp/server/serverData/Music/" + songName;
    String outPath = "out/production/music-app/musicApp/server/serverData/Music/" + songName;
    writeFile(songBytes, path);
    writeFile(songBytes, outPath);
  }

  private void writeFile(byte[] songBytes, String path) throws Exception
  {
    try
    {
      File file = new File(path);
      FileOutputStream out = new FileOutputStream(file);
      byte[] data = songBytes;

      out.write(data);
      out.flush();
      out.close();

    }
    catch (IOException e)
    {

      e.printStackTrace();
      throw new Exception("Could not upload song file");
    }
  }
}
