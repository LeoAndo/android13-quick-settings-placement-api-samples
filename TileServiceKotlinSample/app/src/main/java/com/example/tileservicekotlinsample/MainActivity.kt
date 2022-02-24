package com.example.tileservicekotlinsample

import android.app.StatusBarManager
import android.content.ComponentName
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.tileservicekotlinsample.MyQSTileService.Companion.TAG
import com.example.tileservicekotlinsample.databinding.ActivityMainBinding
import java.util.concurrent.Executor

internal class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val statusBarManager: StatusBarManager = getSystemService(StatusBarManager::class.java)
        Log.d(TAG, "onCreate: statusBarManager $statusBarManager")

        val resultSuccessExecutor = Executor {
            Log.d(TAG, "requestAddTileService result success")
            runOnUiThread {
                binding.txtResult.text = "requestAddTileService result success"
            }
        }

        binding.buttonStartService.setOnClickListener {
            Log.d(TAG, "onclick buttonStartService")
            startService(Intent(this, MyQSTileService::class.java))
        }
        binding.buttonRequestAddTileService.setOnClickListener {
            Log.d(TAG, "onclick buttonRequestAddTileService")
            statusBarManager.requestAddTileService(
                ComponentName(
                    this,
                    MyQSTileService::class.java
                ),
                getString(R.string.my_default_tile_label),
                Icon.createWithResource(this, R.drawable.my_default_icon_label),
                resultSuccessExecutor,
            ) { resultCodeFailure ->
                Log.d(TAG, "requestAddTileService failure: resultCodeFailure: $resultCodeFailure")
                val resultFailureText =
                    when (val ret = RequestResult.findByCode(resultCodeFailure)) {
                        RequestResult.TILE_ADD_REQUEST_ERROR_APP_NOT_IN_FOREGROUND,
                        RequestResult.TILE_ADD_REQUEST_ERROR_BAD_COMPONENT,
                        RequestResult.TILE_ADD_REQUEST_ERROR_MISMATCHED_PACKAGE,
                        RequestResult.TILE_ADD_REQUEST_ERROR_NOT_CURRENT_USER,
                        RequestResult.TILE_ADD_REQUEST_ERROR_NO_STATUS_BAR_SERVICE,
                        RequestResult.TILE_ADD_REQUEST_ERROR_REQUEST_IN_PROGRESS,
                        RequestResult.TILE_ADD_REQUEST_RESULT_TILE_ADDED,
                        RequestResult.TILE_ADD_REQUEST_RESULT_TILE_ALREADY_ADDED,
                        RequestResult.TILE_ADD_REQUEST_RESULT_TILE_NOT_ADDED -> {
                            ret.name
                        }
                        null -> {
                            "unknown resultCodeFailure: $resultCodeFailure"
                        }
                    }
                runOnUiThread {
                    binding.txtResult.text = resultFailureText
                }
            }
        }
    }
}