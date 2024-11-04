package com.example.m3design_uns

data class Scholarship (
    val id: Int,
    val title: String,
    val provider: String,
    val deadline: String,
    val eligibility: String,
    val type: String,
    val benefits: List<String>, // Lista de beneficios
    val requirements: List<String>, // Lista de requisitos
    val applicationProcess: List<String> // Lista del proceso de postulación
)