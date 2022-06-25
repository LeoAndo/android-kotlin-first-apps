package com.example.myokashi

data class APIResponse(val item: List<Item>?) {
    data class Item(val id: Int, val name: String, val url: String, val image: String?)
}