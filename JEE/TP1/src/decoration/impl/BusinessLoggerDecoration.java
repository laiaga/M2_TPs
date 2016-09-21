package decoration.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import business.IBusiness;
import decoration.IDecoration;
import log.ILogger;

@Service
public class BusinessLoggerDecoration implements IDecoration{
	private ILogger logger;
	private IBusiness business;

	@PostConstruct
	public void init() {
		if (logger == null) {
			throw new IllegalStateException("null logger");
		} else if (business == null) {
			throw new IllegalStateException("null business");
		}
		logger.log("Start " + this);
	}

	@PreDestroy
	public void close() {
		logger.log("Stop " + this);
	}

	public synchronized void callAddition(int a, int b) {
		logger.log("doAddition(" + a + "," + b + ")");
		business.doAddition(a, b);
	}

	public synchronized void callLogin(String name, String pass) {
		logger.log("doLogin(\"" + name + "\",\"" + pass + "\")");
		business.doLogin(name,pass);
	}

	public ILogger getLogger() {
		return logger;
	}
	
	@Autowired
	@Qualifier("stdout")
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Autowired
	@Qualifier("noLog")
	public void setBusiness(IBusiness business) {
		this.business = business;
	}
}
