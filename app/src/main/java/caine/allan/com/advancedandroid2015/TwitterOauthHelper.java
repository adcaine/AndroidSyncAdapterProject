package caine.allan.com.advancedandroid2015;

/**
 * Created by allancaine on 2015-10-22.
 */
public class TwitterOauthHelper {
    private static TwitterOauthHelper sTwitterOauthHelper;

    public static TwitterOauthHelper get() {
        if(sTwitterOauthHelper == null){
            sTwitterOauthHelper = new TwitterOauthHelper();
        }
        return sTwitterOauthHelper;
    }

    private TwitterOauthHelper() {
    }

    private String geOauthVersion(){
        return "1.0";
    }

    private String getOauthSignatureMethod() {
        return "HMAC-SHA1";
    }
}
