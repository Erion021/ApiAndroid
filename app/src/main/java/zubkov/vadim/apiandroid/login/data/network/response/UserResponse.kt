package zubkov.vadim.apiandroid.login.data.network.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("status") val status: String,
    @SerializedName("accessToken") val accessToken: String
)
