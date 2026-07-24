package com.example.androidknowledgechecklist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KnowledgeItem(
    val id: Int,
    val title: String,
    val description: String
) : Parcelable
