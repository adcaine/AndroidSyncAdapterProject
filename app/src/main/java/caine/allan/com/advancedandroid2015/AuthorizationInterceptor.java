package caine.allan.com.advancedandroid2015;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by allancaine on 2015-10-22.
 */
public class AuthorizationInterceptor implements Interceptor {

    private static final String TAG = "AuthorizationInterceptor";
    private static final String AUTH_HEADER = "Authorization";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        TwitterOauthHelper oauthHelper = TwitterOauthHelper.get();

        try{
            String authHeaderString =
                    oauthHelper.getAuthorizationHeaderString(request);
            request = request.newBuilder()
                    .addHeader(AUTH_HEADER, authHeaderString)
                    .build();
        }catch (InvalidKeyException | NoSuchAlgorithmException e){
            Log.e(TAG, "Failed to get auth header string", e);
        }
        return chain.proceed(request);
    }
}
