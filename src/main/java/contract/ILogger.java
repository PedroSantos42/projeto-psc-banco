package contract;

public interface ILogger {

	void init(String path);
	void log(String message);
}
