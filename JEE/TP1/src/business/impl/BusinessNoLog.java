package business.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import business.IBusiness;

@Service
@Qualifier("noLog")
public class BusinessNoLog implements IBusiness {

	@PostConstruct
	public void init() {
	}

	@PreDestroy
	public void close() {
	}

	public int doAddition(int a, int b) {
		return (a + b);
	}

	public boolean doLogin(String name, String pass) {
		return (name.equals(pass));
	}
}
