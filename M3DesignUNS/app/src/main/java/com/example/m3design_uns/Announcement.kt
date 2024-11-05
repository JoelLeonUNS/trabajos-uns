package com.example.m3design_uns

import java.io.Serializable

data class Announcement(
    val id: String,
    val title: String,
    val date: String,
    val content: String,
    val details: List<AnnouncementDetail>,
    val information: String
):Serializable
