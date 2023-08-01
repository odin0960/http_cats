import HttpUtils.HttpImageStatusCli;
import HttpUtils.HttpStatusChecker;
import HttpUtils.HttpStatusImageDownloader;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

@Slf4j
public class App {

    public static void main(String[] args) {
        BasicConfigurator.configure();

//        System.out.println("Image URL: " + new HttpStatusChecker().getStatusImage(1111));
//        new HttpStatusImageDownloader().downloadStatusImage(1111);
        new HttpImageStatusCli().askStatus();
    }
}