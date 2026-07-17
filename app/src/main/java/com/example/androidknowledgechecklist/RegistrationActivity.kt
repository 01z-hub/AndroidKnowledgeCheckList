package com.example.androidknowledgechecklist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val etName = findViewById<EditText>(R.id.etMaterialName)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        // ⚠️ 故意写错 ID：下面这行的 R.id.btn_register 是错误的（xml 里是 btnRegister）
        val btnSubmit = findViewById<Button>(R.id.btnRegister)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                // 弹出 Toast
                Toast.makeText(this, "✅ 已登记资料：$name", Toast.LENGTH_SHORT).show()
                // 更新进度条（每次加 20%，最多 100%）
                var currentProgress = progressBar.progress
                if (currentProgress < 100) {
                    progressBar.progress = (currentProgress + 10).coerceAtMost(100)
                } else {
                    Toast.makeText(this, "进度已满！", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "⚠️ 请先输入资料名称", Toast.LENGTH_SHORT).show()
            }
        }
    }
}