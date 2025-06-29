package com.websarva.wings.android.aichiquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class Question5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.q5_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 前画面から渡された正解数を取得
        val num_correct = intent.getIntExtra("num_correct", 0)
        // オブジェクトを取得
        val title = findViewById<TextView>(R.id.q5_title)
        val et = findViewById<EditText>(R.id.q5_et)
        val checkButton = findViewById<Button>(R.id.q5_btn_check)
        val nextButton = findViewById<Button>(R.id.q5_btn_next)
        val correctImageView = findViewById<ImageView>(R.id.q5_correct)
        val failImageView = findViewById<ImageView>(R.id.q5_fail)

        // q5_titleのテキストを設定
        title.text = getString(R.string.question1) + "5" + getString(R.string.question2)

        // q5_btn_check, q5_btn_next:Buttonのクリックリスナーを設定
        checkButton.setOnClickListener {
            // ユーザーの入力を判定
            val userInput = et.text.toString().trim()
            if (userInput.equals(getString(R.string.q5_ans), ignoreCase = true)) {
                // 正解の場合
                correctImageView.visibility = ImageView.VISIBLE
                failImageView.visibility = ImageView.GONE
                checkButton.visibility = Button.GONE
                nextButton.visibility = Button.VISIBLE
            } else {
                // 不正解の場合
                correctImageView.visibility = ImageView.GONE
                failImageView.visibility = ImageView.VISIBLE
                checkButton.visibility = Button.GONE
                nextButton.visibility = Button.VISIBLE
            }

        }
        nextButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("num_correct", if (correctImageView.isVisible) num_correct+1 else num_correct)
            startActivity(intent)
            finish() // 現在のアクティビティを終了
        }

        // q5_correct, q5_fail:imageViewを非表示にする
        correctImageView.visibility = ImageView.GONE
        failImageView.visibility = ImageView.GONE

        // q5_btn_next:Buttonを非表示にする
        nextButton.visibility = Button.GONE
    }
}