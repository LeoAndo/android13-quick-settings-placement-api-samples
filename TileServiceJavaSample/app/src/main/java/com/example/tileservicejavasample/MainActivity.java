package com.example.tileservicejavasample;

import android.app.StatusBarManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tileservicejavasample.databinding.ActivityMainBinding;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        var statusBarManager = getSystemService(StatusBarManager.class);
        Log.d(MyQSTileService.TAG, "onCreate: statusBarManager $statusBarManager");

        var resultSuccessExecutor = new Executor() {
            @Override
            public void execute(Runnable runnable) {
                Log.d(MyQSTileService.TAG, "requestAddTileService result success");
                runOnUiThread(() -> binding.txtResult.setText("requestAddTileService result success"));
            }
        };

        binding.buttonStartService.setOnClickListener(view -> {
            Log.d(MyQSTileService.TAG, "onclick buttonStartService");
            startService(new Intent(MainActivity.this, MyQSTileService.class));
        });
        binding.buttonRequestAddTileService.setOnClickListener(view -> {
            Log.d(MyQSTileService.TAG, "onclick buttonRequestAddTileService");
            if (statusBarManager == null) return;
            statusBarManager.requestAddTileService(
                    new ComponentName(MainActivity.this, MyQSTileService.class),
                    getString(R.string.my_default_tile_label),
                    Icon.createWithResource(MainActivity.this, R.drawable.my_default_icon_label),
                    resultSuccessExecutor,
                    (resultCodeFailure) -> {
                        Log.d(MyQSTileService.TAG, "requestAddTileService failure: resultCodeFailure: " + resultCodeFailure);
                        RequestResult.findByCode(resultCodeFailure).ifPresentOrElse(ret -> {
                            runOnUiThread(() -> binding.txtResult.setText(ret.name()));

                        }, () -> {
                            runOnUiThread(() -> binding.txtResult.setText("unknown resultCodeFailure: " + resultCodeFailure));
                        });
                    }
            );
        });
    }
}