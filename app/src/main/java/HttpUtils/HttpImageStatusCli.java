package HttpUtils;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

@Data
public class HttpImageStatusCli {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpImageStatusCli.class);

    public void askStatus() {
        int code = enterCode();
        try {
            new HttpStatusImageDownloader().downloadStatusImage(code);
        } catch (Exception ex) {
            LOGGER.error("There is not image for HTTP status " + code, ex);
        }
    }

    public int enterCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code: ");
        while (true) {
            String code = scanner.nextLine();
            try {
                return Integer.parseInt(code.strip());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter valid number: ");
            }
        }
    }
}
