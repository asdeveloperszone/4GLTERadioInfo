package com.as_dev.lteinfo

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnContinue = findViewById<Button>(R.id.btnContinue)

        btnContinue.setOnClickListener {
            // Opens the hidden Radio Info / Network settings
            try {
                // Try to open Radio Info (works on most Android devices)
                val intent = Intent(Intent.ACTION_MAIN)
                intent.setClassName("com.android.phone", "com.android.phone.settings.RadioInfo")
                startActivity(intent)
            } catch (e: Exception) {
                try {
                    // Fallback: open mobile network settings
                    startActivity(Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS))
                } catch (e2: Exception) {
                    // Last fallback: wireless settings
                    startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
                }
            }
        }
    }
}
