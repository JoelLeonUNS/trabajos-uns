package com.example.m3design_uns

data class Capacitacion(
    val id: Int,
    val title: String,
    val instructor: String,
    val date: String,
    val duration: String,
    val modality: String,
    val description: String,
    val topics: List<String>,
    val requirements: List<String>,
    val schedule: List<Schedule>
)