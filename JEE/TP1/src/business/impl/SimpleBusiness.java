package business.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.IBusiness;
import log.ILogger;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class SimpleBusiness implements IBusiness {

	private ILogger logger;

	@PostConstruct
	public void init() {
		if (logger == null) {
			throw new IllegalStateException("null logger");
		}
		logger.log("Start " + this);
	}

	@PreDestroy
	public void close() {
		logger.log("Stop " + this);
	}

	public int doAddition(int a, int b) {
		logger.log("doAddition(" + a + "," + b + ")");
		return (a + b);
	}

	public boolean doLogin(String name, String pass) {
		logger.log("doLogin(\"" + name + "\",\"" + pass + "\")");
		return (name.equals(pass));
	}

	public ILogger getLogger() {
		return logger;
	}

	
	
	@Autowired
	@Qualifier("stdout")
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

}
