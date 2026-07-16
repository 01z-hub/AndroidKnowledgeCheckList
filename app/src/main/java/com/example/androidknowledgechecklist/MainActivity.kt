package com.example.androidknowledgechecklist

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 获取视图
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val actionButton = findViewById<Button>(R.id.actionButton)
        val statusTextView = findViewById<TextView>(R.id.statusTextView)

        // 点击按钮
        actionButton.setOnClickListener {
            // 修改标题文字（添加 ✅）
            titleTextView.text = "✅ Android 学习清单"

            // 显示状态并更新内容
            statusTextView.visibility = android.view.View.VISIBLE
            statusTextView.text = "状态：已开始学习！"

            // 修改按钮文字
            actionButton.text = "继续学习"

            // Logcat 输出一条日志
            Log.i(TAG, "按钮被点击，界面已更新")
        }
    }
}