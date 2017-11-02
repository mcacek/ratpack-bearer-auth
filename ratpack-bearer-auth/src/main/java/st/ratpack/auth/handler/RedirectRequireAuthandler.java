package st.ratpack.auth.handler;

import java.net.URI;

import io.netty.handler.codec.http.HttpResponseStatus;
import ratpack.handling.Context;

public class RedirectRequireAuthandler extends AbstractRequireAuthHandler {
	private final URI redirectUri;
	public RedirectRequireAuthandler(URI redirectUri) {
		this.redirectUri = redirectUri;
	}
    public void respondToError(Context ctx) {
		ctx.redirect(HttpResponseStatus.TEMPORARY_REDIRECT.code(), redirectUri);
    }
}
