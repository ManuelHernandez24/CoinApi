package com.aplicada2.apiretrofit.model

data class Exchange (
    val name: String,
    val description: String,
    val active: Boolean,
    val last_updated: String
)