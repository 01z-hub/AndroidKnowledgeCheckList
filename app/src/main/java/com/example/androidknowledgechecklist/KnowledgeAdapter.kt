package com.example.androidknowledgechecklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KnowledgeAdapter(
    private var items: List<KnowledgeItem>,
    private val onItemClick: (KnowledgeItem) -> Unit,
    private val onItemLongClick: (KnowledgeItem) -> Unit   // 长按用于删除确认
) : RecyclerView.Adapter<KnowledgeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_knowledge, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvTitle.text = item.title
        holder.tvDescription.text = item.description

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
        holder.itemView.setOnLongClickListener {
            onItemLongClick(item)
            true  // 表示消费了长按事件
        }
    }

    override fun getItemCount(): Int = items.size

    // 供外部刷新数据
    fun updateData(newItems: List<KnowledgeItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}