package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MyLogger {

	private File _file;
	private FileOutputStream _fop;

	private static MyLogger Logger;

	public MyLogger getInstance(String sourcePath) {
		if (Logger == null) {
			MyLogger.Logger = new MyLogger();
			init(sourcePath);
		}
		return MyLogger.Logger;
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
		String formatedDate = String.valueOf(date.getDay()) + "/";
		formatedDate += String.valueOf(date.getMonth()) + "/";
		formatedDate += String.valueOf(date.getYear() + 1900) + " ";
		formatedDate += String.valueOf(date.getHours()) + ":";
		formatedDate += String.valueOf(date.getMinutes()) + ":";
		formatedDate += String.valueOf(date.getSeconds());
		
		return formatedDate;
	}
}