package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {
	public String getPropertyData(String key) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}

