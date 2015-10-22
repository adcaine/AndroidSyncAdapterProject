package caine.allan.com.advancedandroid2015;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by allancaine on 2015-10-22.
 */
public class AuthenticatorService extends Service {

    private Authenticator mAuthenticator;

    public AuthenticatorService(){
        mAuthenticator = new Authenticator(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
