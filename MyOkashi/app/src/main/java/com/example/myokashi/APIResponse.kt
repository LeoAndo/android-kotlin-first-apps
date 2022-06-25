package com.example.myokashi

data class APIResponse(val item: List<Item>?) {
    data class Item(val name: String, val url: String, val image: String)
}