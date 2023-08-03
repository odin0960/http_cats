package HttpUtils;

import java.io.IOException;

public class HttpStatusChecker {
    public static final String URL_CATS = "https://http.cat/";

    public String getStatusImage(int code) throws IOException {
        String urlImage = URL_CATS + code + ".jpg";
        int statusCode = Utilities.getConnect(urlImage).statusCode();

        if (statusCode == 200) {
            return urlImage;
        } else {
            throw new IOException("HTTP error fetching URL " + urlImage);
        }
    }
}
