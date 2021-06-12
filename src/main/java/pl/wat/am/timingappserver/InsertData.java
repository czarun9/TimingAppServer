package pl.wat.am.timingappserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class InsertData implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(InsertData.class);


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        logger.info("Initializing data");
        try {
            initializeDataFromFile("src/main/resources/static/Big Bang Theory_IMDB.csv");
        } catch (Exception ex) {

        }
    }

    private void initializeDataFromFile(String resourcePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(resourcePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
