package jp.hazuki.yuzubrowser.browser.dynamiclink.livemodel;

import androidx.lifecycle.MutableLiveData;



public class LiveLink {


    private static volatile LiveLink Instance;
    private MutableLiveData<String> liveLink;
    LiveLink() {

    }

    public MutableLiveData<String> getLiveLink() {
        if (liveLink == null) {
            liveLink = new MutableLiveData<>();
        }
        return liveLink;
    }

    public static LiveLink getInstance() {
        if (Instance == null) {
            Instance = new LiveLink();
        }
        return Instance;
    }
}
