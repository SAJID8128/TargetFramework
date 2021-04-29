package browser.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	public static Properties readConfigFile(String path) throws IOException {
		File file = new File(path);
		FileInputStream fileStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileStream);
		return properties;
	}

}
