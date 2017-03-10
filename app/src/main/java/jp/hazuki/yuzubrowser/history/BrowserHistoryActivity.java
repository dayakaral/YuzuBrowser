package jp.hazuki.yuzubrowser.history;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import jp.hazuki.yuzubrowser.R;

public class BrowserHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_base);

        boolean pickMode = false;
        if (getIntent() != null && Intent.ACTION_PICK.equals(getIntent().getAction())) {
            pickMode = true;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, BrowserHistoryFragment.newInstance(pickMode))
                .commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (!(fragment instanceof BrowserHistoryFragment) || !((BrowserHistoryFragment) fragment).onBackPressed()) {
            finish();
        }
    }
}
