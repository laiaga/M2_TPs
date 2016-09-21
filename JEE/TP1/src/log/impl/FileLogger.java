package log.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import log.ILogger;

public class FileLogger implements ILogger {

	// format des dates
	private final DateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss | ");
	// parametre du nom de fichier
	private String fileName;
	private PrintWriter file;

	// initialisation du service
	@PostConstruct
	public void init() {
		if (fileName == null) {
			throw new IllegalStateException("no fileName");
		}
		try {
			OutputStream os = new FileOutputStream(fileName, true);
			this.file = new PrintWriter(os);
		} catch (FileNotFoundException e) {
			throw new IllegalStateException("bad fileName");
		}
	}

	// fermeture du service
	@PreDestroy
	public void close() {
		file.close();
	}

	public void log(String message) {
		file.print(format.format(new Date()));
		file.println(message);
	}

	public void log(String message, String arg1) {
		log(message.replaceAll("\\$1", arg1));
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
