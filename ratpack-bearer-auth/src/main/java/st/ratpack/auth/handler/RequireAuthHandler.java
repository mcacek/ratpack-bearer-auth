package st.ratpack.auth.handler;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import st.ratpack.auth.OAuthToken;

import java.util.Optional;

/**
 * @deprecated Use {@link ResponseCodeAuthErrorHandler.class} or an extension of
 * 						 {@link AbstractRequireAuthHandler.class} instead.
 */
@Deprecated
public class RequireAuthHandler implements Handler {
	@Override
	public void handle(Context ctx) throws Exception {
		Optional<OAuthToken> token = ctx.maybeGet(OAuthToken.class);
		if (token.isPresent()) {
			ctx.next();
		} else {
			ctx.getResponse().status(401).send();
		}
	}
}
