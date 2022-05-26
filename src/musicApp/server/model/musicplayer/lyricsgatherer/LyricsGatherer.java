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


    public static String getSongLyrics(String band, String songTitle) throws IOException {
        return "doesnt work";
//        StringBuilder lyrics = new StringBuilder();
//        try {
//            Document doc = Jsoup.connect(songLyricsURL + "/" + band.replace(" ", "-").toLowerCase() + "/" + songTitle.replace(" ", "-").toLowerCase() + "-lyrics/").get();
//            System.out.println(doc);
//            Element p = doc.select("p.songLyricsV14").get(0);
//            for (Node e : p.childNodes()) {
//                if (e instanceof TextNode) {
//                    lyrics.append(((TextNode) e).getWholeText());
//                }
//            }
//            return lyrics.toString();
//        } catch (HttpStatusException exception) {
//            System.out.println("Songs lyric not found");
//            return null;
//        }
    }

}
