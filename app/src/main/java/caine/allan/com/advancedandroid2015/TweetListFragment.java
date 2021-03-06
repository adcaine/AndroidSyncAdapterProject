package caine.allan.com.advancedandroid2015;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by allancaine on 2015-10-22.
 */
public class TweetListFragment extends Fragment {

    private static final String TAG = "TweetListFragment";

    private String mAccessToken;
    private Account mAccount;
    private TextView mAuthTokenTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet_list, container, false);
        mAuthTokenTextView = (TextView)view.findViewById(R.id.fragment_tweet_list_auth_token_text_view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        fetchAccessToken();
    }

    private void fetchAccessToken(){
        AccountManager accountManager = AccountManager.get(getActivity());
        mAccount = new Account(Authenticator.ACCOUNT_NAME, Authenticator.ACCOUNT_TYPE);
        accountManager.getAuthToken(
                mAccount, Authenticator.AUTH_TOKEN_TYPE, null, getActivity(),
                new AccountManagerCallback<Bundle>() {

                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {
                        try {
                            Bundle bundle = future.getResult();
                            mAccessToken = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                            mAuthTokenTextView.setText("Have access token " + mAccessToken);
                        } catch (AuthenticatorException | OperationCanceledException | IOException e){
                            Log.e(TAG, "Got an exception "  + e);
                        }
                    }
                }
        , null);
    }
}
