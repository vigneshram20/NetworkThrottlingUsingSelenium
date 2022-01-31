package NetworkThrottlingTestingUsingSelenium.NetworkThrottlingTestingUsingSelenium;

import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.Response;
import org.testng.annotations.DataProvider;

public class NetworkThrottle {
	@Test
	public void throughputTest() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"********Your Chromedriver Path********");
		ChromeDriver driver = new ChromeDriver();

		CommandExecutor executor = driver.getCommandExecutor();

		HashMap<String, Object> innermap = new HashMap<String, Object>();
		innermap.put("offline", false);
		innermap.put("latency", 5);
		innermap.put("download_throughput", 5000);
		innermap.put("upload_throughput", 5000);

		HashMap<String, Object> outermap = new HashMap<String, Object>();
		outermap.put("network_conditions", innermap);

		Command cmd = new Command(driver.getSessionId(), "setNetworkConditions", outermap);

		executor.execute(cmd);

		driver.get("http://youtube.com");
		
		driver.quit();
	}

}