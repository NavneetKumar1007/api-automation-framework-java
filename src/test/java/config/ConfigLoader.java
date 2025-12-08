package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;

public class ConfigLoader {

    private static ConfigLoader instance;
    private ConfigModel config;

    private ConfigLoader() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            config = mapper.readValue(new File("src/test/resources/config.yaml"), ConfigModel.class);
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to load config.yaml", e);
        }
    }

    public static ConfigLoader getInstance() {
        if (instance == null)
            instance = new ConfigLoader();
        return instance;
    }

    public String getBaseUrl() {
        return config.getBase_url();
    }
}

