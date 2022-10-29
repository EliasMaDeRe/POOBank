package utilities;

public class WrapperResponse<T> {
	private Boolean ok;
    private String message;
    private T body;

	public WrapperResponse(Boolean ok, String message, T body) {
		this.ok = ok;
		this.message = message;
		this.body = body;
	}
}
