package commons;

import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Globals {

    @Getter
    private static boolean headless;
    @Getter
    private static String urlDev;
    @Getter
    private static String jsonSchema;
    @Getter
    private static String redisHost;
    @Getter
    private static String redisPassword;
    @Getter
    private static Integer redisPort;
    @Getter
    private static String urlBrowserlessChrome;
    @Setter
    @Getter
    private static String jiraUsername;
    @Setter
    @Getter
    private static String jiraUrl;
    @Setter
    @Getter
    private static String jiraAPIToken;
    @Setter
    @Getter
    private static String spotApiKey;
    @Setter
    @Getter
    private static String spotSecretKey;
    @Setter
    @Getter
    private static String spotRestUrl;
    @Setter
    @Getter
    private static String spotWssUrl;


    public static void setEnvironment(String configYaml) {
        try {
            YamlUtil yaml = new YamlUtil(new FileInputStream(configYaml));
            // file paths
            jsonSchema = String.valueOf(yaml.fetchObject("paths.jsonSchema"));
            //set selenium options
//            browser = String.valueOf(yaml.fetchObject("selenium.browser"));
            headless = Boolean.parseBoolean(String.valueOf(yaml.fetchObject("selenium.headless")));
            // redis
            redisHost = String.valueOf(yaml.fetchObject("redis.host"));
            redisPort = (Integer) yaml.fetchObject("redis.port");
            redisPassword = String.valueOf(yaml.fetchObject("redis.password"));
            // urls
            urlBrowserlessChrome = String.valueOf(yaml.fetchObject("urls.browserlessChrome"));
            urlDev = String.valueOf(yaml.fetchObject("urls.dev"));
            //jira
            jiraUrl = String.valueOf(yaml.fetchObject("jira.url"));
            jiraUsername = String.valueOf(yaml.fetchObject("jira.username"));
            jiraAPIToken = String.valueOf(yaml.fetchObject("jira.token"));
            spotApiKey = String.valueOf(yaml.fetchObject("spot.apiKey"));
            spotSecretKey = String.valueOf(yaml.fetchObject("spot.apiSecret"));
            spotRestUrl= String.valueOf(yaml.fetchObject("spot.restUrl"));
            spotWssUrl = String.valueOf(yaml.fetchObject("spot.wssUrl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new PreconditionException("[CONFIG_FILE_ISSUE]" + e.getMessage());
        }
    }


}
