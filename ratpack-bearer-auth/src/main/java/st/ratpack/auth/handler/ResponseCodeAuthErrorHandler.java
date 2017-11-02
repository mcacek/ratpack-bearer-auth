package st.ratpack.auth.handler;

import io.netty.handler.codec.http.HttpResponseStatus;
import ratpack.handling.Context;

public class ResponseCodeAuthErrorHandler extends AbstractRequireAuthHandler {
	private final HttpResponseStatus httpStatus;

	public ResponseCodeAuthErrorHandler() {
		this.httpStatus = HttpResponseStatus.UNAUTHORIZED;
	}

	public ResponseCodeAuthErrorHandler(HttpResponseStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public void respondToError(Context ctx) {
			ctx.getResponse().status(httpStatus.code()).send();
	}
}
