package com.websarva.wings.android.aichiquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.result_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 前画面から渡された正解数を取得
        val num_correct = intent.getIntExtra("num_correct", 0)
        // オブジェクトを取得
        val resultTextView = findViewById<TextView>(R.id.result_view)
        val resultButton = findViewById<Button>(R.id.result_btn)
        // 正解数を表示
        resultTextView.text = getString(R.string.resultText1) + num_correct + getString(R.string.resultText2)
        // result_btn:Buttonのクリックリスナーを設定
        resultButton.setOnClickListener {
            // MainActivityに戻る
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}