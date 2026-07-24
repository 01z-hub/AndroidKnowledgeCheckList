package com.example.androidknowledgechecklist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KnowledgeListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: KnowledgeAdapter
    private val knowledgeList = mutableListOf<KnowledgeItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge_list)

        // 准备 10 个知识点数据
        knowledgeList.addAll(
            listOf(
                KnowledgeItem(1, "Activity 生命周期", "onCreate → onStart → onResume → onPause → onStop → onDestroy"),
                KnowledgeItem(2, "Intent 显式与隐式", "显式指定类名，隐式声明动作和数据"),
                KnowledgeItem(3, "RecyclerView 使用", "Adapter + ViewHolder + LayoutManager 三件套"),
                KnowledgeItem(4, "Fragment 设计", "模块化 UI，可复用，依赖 Activity"),
                KnowledgeItem(5, "布局优化", "减少嵌套，使用 ConstraintLayout 扁平化"),
                KnowledgeItem(6, "数据存储", "SharedPreferences 和 SQLite 数据库"),
                KnowledgeItem(7, "网络请求", "Retrofit + 协程实现异步请求"),
                KnowledgeItem(8, "权限管理", "动态申请危险权限（如相机、位置）"),
                KnowledgeItem(9, "通知与渠道", "Android 8.0 后需 NotificationChannel"),
                KnowledgeItem(10, "性能优化", "内存泄漏排查和卡顿检测")
            )
        )

        recyclerView = findViewById(R.id.recyclerViewKnowledge)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = KnowledgeAdapter(
            items = knowledgeList,
            onItemClick = { item ->
                // 点击跳转到详情
                val intent = Intent(this, KnowledgeDetailActivity::class.java)
                intent.putExtra("item", item)
                startActivity(intent)
            },
            onItemLongClick = { item ->
                // 长按弹出删除确认对话框
                showDeleteConfirmationDialog(item)
            }
        )
        recyclerView.adapter = adapter
    }

    private fun showDeleteConfirmationDialog(item: KnowledgeItem) {
        AlertDialog.Builder(this)
            .setTitle("删除确认")
            .setMessage("确定要删除“${item.title}”吗？")
            .setPositiveButton("删除") { _, _ ->
                knowledgeList.remove(item)
                adapter.updateData(knowledgeList)
                Toast.makeText(this, "已删除 ${item.title}", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("取消", null)
            .show()
    }
}