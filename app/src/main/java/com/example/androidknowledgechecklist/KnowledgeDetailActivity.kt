package com.example.androidknowledgechecklist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class KnowledgeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge_detail_container)

        val item = intent.getParcelableExtra<KnowledgeItem>("item")
        if (item != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, KnowledgeDetailFragment.newInstance(item))
                .commit()
        }
    }
}