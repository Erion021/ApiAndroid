package zubkov.vadim.apiandroid.login.data.network.response

import com.google.gson.annotations.SerializedName
import zubkov.vadim.apiandroid.login.data.UserModel

data class LoginLoadResponse(@SerializedName("success") val filmList: List<UserModel>)
