package com.example.m3design_uns

import androidx.fragment.app.Fragment

data class CardHome(
    val id: String,
    val title: String,
    val content: String,
    val iconResId: Int,
    val color: Int,
    val destinationFragment: Fragment
)
