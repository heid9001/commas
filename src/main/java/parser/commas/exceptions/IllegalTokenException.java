package parser.commas.exceptions;

public class IllegalTokenException extends Exception {
	public IllegalTokenException(String token) {
		super(String.format("Token: %s is NaN", token));
	}
}
