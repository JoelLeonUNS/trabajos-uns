package com.example.m3design_uns

data class Post(
    val id: Int,
    val author: String,
    val avatar: String,
    val date: String,
    val content: String,
    val likes: Int,
    val comments: Int
)