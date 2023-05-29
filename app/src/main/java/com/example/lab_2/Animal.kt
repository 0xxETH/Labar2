package com.example.lab_2

import java.io.Serializable

data class Animal(
    val name: String,
    val latin: String,
    val description: String,
    val url: String
): Serializable