package in.akshay.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "plan-api")
@EnableConfigurationProperties
public class AppProperties {
	
	Map<String, String> messages = new HashMap<>();

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "AppProperties [messages=" + messages + "]";
	}
	

	
	
	
	
	

}
