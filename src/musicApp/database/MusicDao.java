package musicApp.database;

import java.util.ArrayList;

public interface MusicDao
{
  ArrayList<Music> getAllMusic();
  void insertMusic(Music music);
  void deleteMusic(Music music);
}
