package com.example.m3design_uns

// Post.kt
data class Post(
    val author: String,
    val date: String,
    val content: String,
    val likes: Int,
    val comments: Int
)
