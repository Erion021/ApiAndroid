package zubkov.vadim.monkeyfilm.home.data.network.response

import com.google.gson.annotations.SerializedName
import zubkov.vadim.monkeyfilm.home.data.MediaModel

data class HomeResponse(@SerializedName("data") val filmList: List<MediaModel>)