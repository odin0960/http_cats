package HttpUtils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class Utilities {

    public static Connection.Response getConnect(String url) throws IOException {

        return Jsoup.connect(url)
                .ignoreContentType(true)
                .execute();
    }
}