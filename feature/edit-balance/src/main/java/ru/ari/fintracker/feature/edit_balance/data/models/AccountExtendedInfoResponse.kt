package ru.ari.fintracker.feature.edit_balance.data.models

import com.google.gson.annotations.SerializedName

data class AccountExtendedInfoResponse (
    @SerializedName("id") val id: Long,
    @SerializedName("userId") val userId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("balance") val balance: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String
)
