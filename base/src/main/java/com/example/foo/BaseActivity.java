package com.example.foo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * This just loads a {@link android.widget.Button} on screen that
 * launches {@code com.example.something.BazActivity}.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        findViewById(R.id.link_to_something).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://example.com/something"));
                        startActivity(intent);
                    }
                }
        );
    }
}