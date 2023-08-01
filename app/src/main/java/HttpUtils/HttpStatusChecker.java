package HttpUtils;

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
            Jsoup.connect(urlImage)
                    .ignoreContentType(true)
                    .execute();
        } catch (IOException ex) {
            LOGGER.error("NOT FOUND", ex);
        }
        return urlImage;
    }
}
