package com.example.androidknowledgechecklist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "Lifecycle_Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate 执行")

        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val btnGoToDetail = findViewById<Button>(R.id.btnGoToDetail)
        val btnImplicitWeb = findViewById<Button>(R.id.btnImplicitWeb)

        // 1. 显式 Intent：跳转到 DetailActivity 并传参
        btnGoToDetail.setOnClickListener {
            val inputText = editTextInput.text.toString()
            if (inputText.isNotEmpty()) {
                // 显式 Intent：明确指定要跳转的组件类名
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("KEY_DATA", inputText) // 携带文本
                startActivity(intent)
            } else {
                // 简单提醒（或者 Toast，这里为了不引入新知识，改状态文字）
                findViewById<TextView>(R.id.statusTextView).text = "不要点我了，好痛"
            }
        }

        // 2. 隐式 Intent：打开网页（ACTION_VIEW）
        btnImplicitWeb.setOnClickListener {
            val webpage = Uri.parse("https://developer.android.com")
            // 隐式 Intent：只声明动作和数据类型，由系统匹配能响应的应用（如浏览器）
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart 执行")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume 执行")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause 执行")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop 执行")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy 执行")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart 执行")
    }
}