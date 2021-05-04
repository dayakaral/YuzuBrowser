package jp.hazuki.yuzubrowser.browser.dynamiclink.createlink;


import android.net.Uri;

import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;

public class CreateDLinks {

    private static final String appPackageName = "jp.hazuki.yuzubrowser";
    private static final String domainUrlPrefix = "https://yuzzu.page.link";

    private static volatile CreateDLinks Instance;
    private DynamicLink dynamicLink;

    public CreateDLinks() {

    }

    public void createDynamicLink(String browserUrl, String title) {


        dynamicLink = FirebaseDynamicLinks.getInstance()
            .createDynamicLink()
            .setLink(Uri.parse(browserUrl))
            .setDomainUriPrefix(domainUrlPrefix)
            .setAndroidParameters(new DynamicLink.AndroidParameters.Builder(appPackageName).build())
            .setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder()
            .setTitle(title).build()    )
            .buildDynamicLink();

    }



    public String getCreatedDynamicLink() {
        return dynamicLink.getUri().toString();
    }

    public static CreateDLinks getSingleton() {
        if (Instance == null) {
            Instance = new CreateDLinks();
        }
        return Instance;
    }




}
