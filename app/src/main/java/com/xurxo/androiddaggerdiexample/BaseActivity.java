package com.xurxo.androiddaggerdiexample;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getApplication()).getObjectGraph().inject(this);
    }
}
