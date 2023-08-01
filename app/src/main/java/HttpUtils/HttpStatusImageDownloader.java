package HttpUtils;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class HttpStatusImageDownloader {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpStatusImageDownloader.class);

    public void downloadStatusImage(int code) {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(code + ".jpg"))) {
            String urlImage = new HttpStatusChecker().getStatusImage(code);
            byte[] bytes = Jsoup.connect(urlImage)
                    .ignoreContentType(true)
                    .execute()
                    .bodyAsBytes();
            out.write(bytes);
            LOGGER.info("Image downloaded");
        } catch (IllegalArgumentException | IOException ex) {
            LOGGER.error("There is not image for HTTP status " + code, ex);
        }
    }
}