package musicApp.server.model.musicplayer.lyricsgatherer;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.io.IOException;
import java.util.ArrayList;

public class LyricsGatherer {

    private final static String songLyricsURL = "http://www.songlyrics.com";


    public static ArrayList<String> getSongLyrics(String band, String songTitle) throws IOException {
        ArrayList<String> lyrics = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(songLyricsURL + "/" + band.replace(" ", "-").toLowerCase() + "/" + songTitle.replace(" ", "-").toLowerCase() + "-lyrics/").get();
            Element p = doc.select("p.songLyricsV14").get(0);
            for (Node e : p.childNodes()) {
                if (e instanceof TextNode) {
                    lyrics.add(((TextNode) e).getWholeText());
                }
            }
            return lyrics;
        } catch (HttpStatusException exception) {
            System.out.println("Songs lyric not found");
            return null;
        }
    }

}
