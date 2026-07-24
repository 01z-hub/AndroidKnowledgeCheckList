package com.example.androidknowledgechecklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class KnowledgeDetailFragment : Fragment() {

    companion object {
        private const val ARG_ITEM = "item"
        fun newInstance(item: KnowledgeItem): KnowledgeDetailFragment {
            return KnowledgeDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_ITEM, item)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_knowledge_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = arguments?.getParcelable<KnowledgeItem>(ARG_ITEM)
        if (item != null) {
            view.findViewById<TextView>(R.id.tvDetailTitle).text = item.title
            view.findViewById<TextView>(R.id.tvDetailDescription).text = item.description
        }
    }
}