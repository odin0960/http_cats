package HttpUtils;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpStatusChecker {
    private final String url = "https://http.cat/";
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpStatusChecker.class);

    public String getStatusImage(int code) {
        String urlImage = url + code + ".jpg";

        try {
            int statusCode = Jsoup.connect(urlImage)
                    .ignoreContentType(true)
                    .execute()
                    .statusCode();
            if (statusCode == 404) {
                throw new IOException();
            } else {
                return urlImage;
            }
        } catch (IOException ex) {
            LOGGER.error("NOT FOUND", ex);
            return "";
        }
    }
}
