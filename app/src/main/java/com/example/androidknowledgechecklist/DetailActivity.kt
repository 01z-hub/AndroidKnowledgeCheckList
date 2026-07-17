package com.example.androidknowledgechecklist

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private val TAG = "Lifecycle_Detail"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d(TAG, "onCreate 执行")

        val tvReceived = findViewById<TextView>(R.id.tvReceivedText)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // 获取 MainActivity 传过来的数据
        val receivedData = intent.getStringExtra("KEY_DATA")
        if (!receivedData.isNullOrEmpty()) {
            tvReceived.text = "收到的内容：$receivedData"
        } else {
            tvReceived.text = "未收到数据"
        }

        // 点击返回按钮，销毁当前 Activity 回到上一页
        btnBack.setOnClickListener {
            finish() // 调用 finish 会触发 onDestroy
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