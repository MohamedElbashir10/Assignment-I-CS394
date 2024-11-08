package com.bird394proj.data

import java.io.Serializable

data class Bird(
    val name: String,
    val scientificName: String,
    val habitat: String,
    val imageResId: Int,
    val funFact: String
) : Serializable
