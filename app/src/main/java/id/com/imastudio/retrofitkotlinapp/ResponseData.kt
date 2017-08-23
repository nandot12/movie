package id.com.imastudio.retrofitkotlinapp

import com.google.gson.annotations.SerializedName


class ResponseData {

    @SerializedName("data")
    var data: List<Datum>? = null

}
