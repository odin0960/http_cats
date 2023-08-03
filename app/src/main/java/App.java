import HttpUtils.HttpImageStatusCli;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

@Slf4j
public class App {

    public static void main(String[] args){
        BasicConfigurator.configure();

        new HttpImageStatusCli().askStatus();
    }
}