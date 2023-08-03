package HttpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.MessageFormat;

public class HttpStatusImageDownloader {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpStatusImageDownloader.class);

    public void downloadStatusImage(int code) throws IOException {

        String urlImage = new HttpStatusChecker().getStatusImage(code);
        if (urlImage == null) {
            throw new IOException("This " + code + " isn't exist and image can't be downloaded");
        } else {
            try (OutputStream out = new BufferedOutputStream(new FileOutputStream(code + ".jpg"))) {
                byte[] bytes = Utilities.getConnect(urlImage).bodyAsBytes();
                out.write(bytes);
                LOGGER.info(MessageFormat.format("Image {0}.jpg downloaded", code));
            } catch (IllegalArgumentException | IOException ex) {
                LOGGER.error("This image can't be downloaded", ex);
            }
        }
    }
}