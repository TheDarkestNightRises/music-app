package musicApp.client.views.addAlbum;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.addAlbum.AddAlbumManager;
import musicApp.client.model.login.LogInManager;
import musicApp.database.album.AlbumDAOImpl;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddAlbumViewModel
{

  private final StringProperty albumName;
  private LogInManager logInManager;
  private AddAlbumManager addAlbumManager;
  private ObjectProperty<Image> albumPicture;
  private FileInputStream tempImgStream;
  private File imgFile;

  public AddAlbumViewModel(AddAlbumManager addAlbumManager, LogInManager loginManager) {
    this.addAlbumManager = addAlbumManager;
    this.logInManager = loginManager;
    albumName = new SimpleStringProperty("");
    albumPicture = new SimpleObjectProperty<Image>();
  }

  public void choosePicture(File pictureFile)
  {
    try
    {
      tempImgStream = new FileInputStream(pictureFile);
      albumPicture.setValue(new Image(tempImgStream));
      imgFile = pictureFile;
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public boolean Validate()
  {
    return tempImgStream != null && !albumName.getValue().isEmpty();
  }

  public void bindImage(ObjectProperty<Image> property)
  {
    albumPicture.bindBidirectional(property);
  }

  public void bindAlbumName(StringProperty property)

  {
    albumName.bindBidirectional(property);
  }

  public void submit()
  {
    if(tempImgStream != null && !albumName.getValue().isEmpty())
    {
      try
      {
        BufferedImage image = ImageIO.read(imgFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) image, "png", byteArrayOutputStream);
        User user = logInManager.getUser();
        LocalDate current_date = LocalDate.now();
        String uploaded = addAlbumManager.uploadAlbumImage(user.getUsername(), byteArrayOutputStream.toByteArray());
        try
        {
          Artist artist = addAlbumManager.getArtist(user);
          AlbumDAOImpl.getInstance().createAlbum(albumName.getValue(),current_date.getYear(),uploaded,artist);
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

    }
  }

}
