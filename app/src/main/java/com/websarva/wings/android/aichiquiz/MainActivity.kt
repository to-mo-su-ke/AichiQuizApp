package com.websarva.wings.android.aichiquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // home_btnボタンのクリックリスナーを設定
        val homeBtn = findViewById<Button>(R.id.home_btn)
        homeBtn.setOnClickListener {
            val intent = Intent(this, Question1Activity::class.java)
            startActivity(intent)
            // MainActivityを終了して、戻れないようにする
            finish()
        }
    }
}