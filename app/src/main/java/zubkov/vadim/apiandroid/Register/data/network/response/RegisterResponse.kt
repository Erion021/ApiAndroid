package zubkov.vadim.pruebasandroiddiseo.Screens.Register.data.network.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("status") val status: String,
    @SerializedName("accessToken") val accessToken: String
)