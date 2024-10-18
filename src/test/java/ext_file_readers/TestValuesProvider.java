package ext_file_readers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public interface TestValuesProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("test_values.conf");
    }

    String URL = readConfig().getString("url");
}
