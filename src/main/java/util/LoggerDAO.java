package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class LoggerDAO {

	private File _file;
	private FileOutputStream _fop;

	private static LoggerDAO Logger;
	
	public LoggerDAO getInstance() {
		if (Logger == null) {
			LoggerDAO.Logger = new LoggerDAO();
			init(MyStrings.LOGGER_SOURCE_FILE);
		}
		return LoggerDAO.Logger;
	}

	private void init(String path) {
		Logger._file = new File(path);
		try {
			Logger._fop = new FileOutputStream(Logger._file);

			if (!Logger._file.exists())
				Logger._file.createNewFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void log(String message) {
		byte[] contentInBytes = (this.formatDate(new Date()) + " - " + message + "\n").getBytes();

		try {
			Logger._fop.write(contentInBytes);
			Logger._fop.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public String formatDate(Date date) {
		String formatedDate = date.getDate() < 10 ? "0" + String.valueOf(date.getDate()) : String.valueOf(date.getDate()) + "/";
		formatedDate += String.valueOf(date.getMonth() + 1)		+ "/";
		formatedDate += String.valueOf(date.getYear() + 1900) 	+ " ";
		formatedDate += String.valueOf(date.getHours()) 		+ ":";
		formatedDate += String.valueOf(date.getMinutes()) 		+ ":";
		formatedDate += date.getSeconds() < 10 ? "0" + String.valueOf(date.getSeconds()) : String.valueOf(date.getSeconds());
		
		return formatedDate;
	}
}