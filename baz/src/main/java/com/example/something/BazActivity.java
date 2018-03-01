package com.example.something;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.AnyRes;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.util.Locale;

public class BazActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baz);

        TextView compileTime = findViewById(R.id.baz_compile_time);
        TextView runTimePackage = findViewById(R.id.baz_runtime_with_package);
        TextView runTimeModule = findViewById(R.id.baz_runtime_with_module);

        runTimePackage.setText(prettyPrint(
                "getResources().getIdentifier(\"config\",\"xml\",\"com.example.something\")",
                getConfigId("com.example.something")
        ));
        runTimeModule.setText(prettyPrint(
                "getResources().getIdentifier(\"config\",\"xml\",\"com.example.android.baz\")",
                getConfigId("com.example.android.baz")
        ));

        compileTime.setText(prettyPrint("R.xml.config at compile-time", R.xml.config));
    }

    @AnyRes
    private int getConfigId(String defPackage) {
        return getResources().getIdentifier("config", "xml", defPackage);
    }

    private String prettyPrint(@NonNull String methodOfFindingId, @AnyRes int configResId) {
        return String.format(
                Locale.ROOT,
                "Resource id for config was 0x%x when looked up via %s",
                configResId,
                methodOfFindingId
        );
    }
}
