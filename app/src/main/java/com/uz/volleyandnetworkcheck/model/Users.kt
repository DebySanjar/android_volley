package com.uz.volleyandnetworkcheck.model

data class User(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val userType: String,
    val profileUrl: String
)

