package caine.allan.com.advancedandroid2015;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by allancaine on 2015-10-22.
 */
public interface AuthenticationInterface {
    @POST("/oauth/request_token")
    void fetchRequestToken(@Body String body, Callback<Response> callback);

    @FormUrlEncoded
    @POST("/oauth/access_token")
    void fetchAccessToken(@Field("oauth_verifier") String verifier, Callback<Response> callback);
}
