package com.example.myokashi.domain

import com.example.myokashi.APIResponse

data class OkashiDomainModel(val id: Int, val name: String, val url: String, val image: String?)

fun APIResponse.toOkashiDomainModels(): List<OkashiDomainModel>? {
    return this.item?.map {
        OkashiDomainModel(id = it.id, name = it.name, url = it.url, image = it.image)
    }
}