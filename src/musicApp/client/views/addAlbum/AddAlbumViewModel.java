package musicApp.client.views.addAlbum;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import musicApp.client.model.MainModel;
import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class AddAlbumViewModel
{

  private final MainModel mainModel;
  private final StringProperty albumName;
  private ObjectProperty<Image> albumPicture;
  private FileInputStream tempImgStream;
  private File imgFile;


  public AddAlbumViewModel(MainModel mainModel)
  {
    this.mainModel = mainModel;
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
    if(tempImgStream != null)
    {
      try
      {
        BufferedImage image = ImageIO.read(imgFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) image, "png", byteArrayOutputStream);
        User user = mainModel.getLogInManager().getUser();
        LocalDate current_date = LocalDate.now();
        String uploaded = mainModel.getAddAlbumManager().uploadAlbumImage(user.getUsername(), byteArrayOutputStream.toByteArray());
        try
        {
          Artist artist = mainModel.getAddAlbumManager().getArtist(user);
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