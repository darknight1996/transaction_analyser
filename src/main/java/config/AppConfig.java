package config;

import lombok.Getter;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Getter
public class AppConfig {

    private final String INPUT_FILE_NAME_PROPERTY = "inputFileName";
    private final String MERCHANT_PROPERTY = "merchant";
    private final String FROM_DATE_PROPERTY = "fromDate";
    private final String TO_DATE_PROPERTY = "toDate";
    private final String PROPERTIES_FILE_NAME = "config.properties";
    private final String CONFIG_FILE_NOT_FOUND = "config file not found";
    private final String INVALID_DATE_FORMAT = "invalid date format";

    private static AppConfig appConfig;

    private String inputFileName;

    private String merchant;

    private Date fromDate;

    private Date toDate;

    private AppConfig() {
        this.init();
    }

    private void init() {

        FileInputStream fis;
        Properties property = new Properties();

        try {

            fis = new FileInputStream(Constants.RESOURCES_PATH + PROPERTIES_FILE_NAME);
            property.load(fis);

            inputFileName = property.getProperty(INPUT_FILE_NAME_PROPERTY);
            merchant = property.getProperty(MERCHANT_PROPERTY);
            fromDate = new SimpleDateFormat(Constants.DATE_FORMAT).parse(property.getProperty(FROM_DATE_PROPERTY));
            toDate = new SimpleDateFormat(Constants.DATE_FORMAT).parse(property.getProperty(TO_DATE_PROPERTY));

        } catch (IOException e) {
            System.err.println(CONFIG_FILE_NOT_FOUND);
        } catch (ParseException e) {
            System.err.println(INVALID_DATE_FORMAT);
        }

    }

    public static AppConfig getInstance() {
        if (appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }

}
