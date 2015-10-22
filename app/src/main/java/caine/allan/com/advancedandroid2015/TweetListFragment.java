package caine.allan.com.advancedandroid2015;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by allancaine on 2015-10-22.
 */
public class TweetListFragment extends Fragment {

    private TextView mAuthTokenTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet_list, container, false);
        mAuthTokenTextView = (TextView)view.findViewById(R.id.fragment_tweet_list_auth_token_text_view);
        return view;
    }
}
