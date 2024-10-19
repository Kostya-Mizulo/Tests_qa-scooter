package ext_file_readers;

import com.typesafe.config.*;
import java.util.List;


public interface TestValuesProvider {
    Config config = readConfig();
    static Config readConfig(){
        return ConfigFactory.load("test_values.conf");
    }


    String BROWSER = readConfig().getString("browser");
    String URL = readConfig().getString("url");
    Object[][] FAQ_VALUES = getPersonalInfoArrayOfArray("FAQ_Values");
    String COMMENT_FOR_COURIER = readConfig().getString("commentForCourier");


    private static Object[][] getPersonalInfoArrayOfArray(String keyFromConf) {
        ConfigList configList = readConfig().getList(keyFromConf);
        Object[][] arrayOfArrays = new Object[configList.size()][];
        int i = 0;
        for (ConfigValue value : configList) {
            List<Object> personalInfo = (List<Object>) value.unwrapped();
            arrayOfArrays[i] = personalInfo.toArray();
            i++;
        }
        return arrayOfArrays;
    }


}
