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

class Question1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.q1_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // オブジェクトを取得
        val title = findViewById<TextView>(R.id.q1_title)
        val et = findViewById<EditText>(R.id.q1_et)
        val checkButton = findViewById<Button>(R.id.q1_btn_check)
        val nextButton = findViewById<Button>(R.id.q1_btn_next)
        val correctImageView = findViewById<ImageView>(R.id.q1_correct)
        val failImageView = findViewById<ImageView>(R.id.q1_fail)

        // q1_titleのテキストを設定
        title.text = getString(R.string.question1) + "1" + getString(R.string.question2)

        // q1_btn_check, q1_btn_next:Buttonのクリックリスナーを設定
        checkButton.setOnClickListener {
            // ユーザーの入力を判定
            val userInput = et.text.toString().trim()
            if (userInput.equals(getString(R.string.q1_ans), ignoreCase = true)) {
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
            val intent = Intent(this, Question2Activity::class.java)
            intent.putExtra("num_correct", if (correctImageView.isVisible) 1 else 0)
            startActivity(intent)
            finish() // 現在のアクティビティを終了
        }

        // q1_correct, q1_fail:imageViewを非表示にする
        correctImageView.visibility = ImageView.GONE
        failImageView.visibility = ImageView.GONE

        // q1_btn_next:Buttonを非表示にする
        nextButton.visibility = Button.GONE
    }
}