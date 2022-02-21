package com.example.tileservicekotlinsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.tileservicekotlinsample.MyQSTileService.Companion.TAG
import com.example.tileservicekotlinsample.databinding.ActivityMainBinding

internal class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStartService.setOnClickListener {
            Log.d(TAG, "onclick buttonStartService")
            startService(Intent(this, MyQSTileService::class.java))
        }
        binding.buttonRequestAddTileService.setOnClickListener {
            Log.d(TAG, "onclick buttonRequestAddTileService")
        }
    }
}