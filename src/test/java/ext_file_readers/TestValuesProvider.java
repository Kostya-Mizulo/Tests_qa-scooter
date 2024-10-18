package ext_file_readers;

import com.typesafe.config.*;

import java.util.Arrays;
import java.util.List;


public interface TestValuesProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("test_values.conf");
    }

    String URL = readConfig().getString("url");
    Object[][] PERSONAL_INFO_LIST_Array = getPersonalInfoArrayOfArray("PersonalInformationArray");




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
