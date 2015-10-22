package caine.allan.com.advancedandroid2015;

import android.accounts.AccountAuthenticatorActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import retrofit.RestAdapter;

/**
 * Created by allancaine on 2015-10-22.
 */
public class AuthenticationActivity extends AccountAuthenticatorActivity {

    private static final String EXTRA_ACCOUNT_TYPE =
            "caine.allan.com.advancedandroid2015.ACCOUNT_TYPE";
    private static final String EXTRA_AUTH_TYPE =
            "caine.allan.com.advancedandroid2015.AUTH_TYPE";
    private static final String TWITTER_ENDPOINT = "https://api.twitter.com";

    private WebView mWebView;
    private RestAdapter mRestAdapter;


    public static Intent newIntent(Context context, String accountType, String authTokenType){
        Intent i = new Intent(context, AuthenticationActivity.class);
        i.putExtra(EXTRA_ACCOUNT_TYPE, accountType);
        i.putExtra(EXTRA_AUTH_TYPE, authTokenType);
        return i;
    }

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        mWebView = new WebView(this);

        setContentView(mWebView);

        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(TWITTER_ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }
}
