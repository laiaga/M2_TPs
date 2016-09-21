package appli;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import decoration.IDecoration;
import log.ILogger;

public class MyApp1 {
	private AbstractApplicationContext context;

	// Utilisation du service "logger"
	void use(ILogger logger) {
		logger.log("result = $1", "hello");
	}

	// integration par Spring
	void run() {
		String conf = "spring.xml";
		context = new ClassPathXmlApplicationContext(conf);
		context.registerShutdownHook();
		IDecoration decoration = context.getBean(IDecoration.class);
		decoration.callAddition(1, 2);
	}

	public static void main(String[] args) {
		MyApp1 app = new MyApp1();
		app.run();
	}
}
