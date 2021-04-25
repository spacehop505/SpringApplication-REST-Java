package run.client;
public class MyException extends Exception {

	String message;

	public MyException(String errMessage) {
		message = errMessage;
	}

	@Override
	public String getMessage() {
		return message;
	}

}