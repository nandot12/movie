package id.com.imastudio.retrofitkotlinapp

import retrofit2.Call
import retrofit2.http.*

/**
 * Created by nandoseptianhusni on 8/23/17.
 */
interface ApiService {

    @GET("input-siswa")
    fun request_insert(
            @Query("nama") name: String,
            @Query("nis") nis: Int,
            @Query("status") status: Int
    ): Call<ResponseInsert>

    @GET("get-siswa")
    fun request_getdata(): Call<ResponseData>


    @FormUrlEncoded
    @POST("update-siswa")
    fun request_update(@Field("id") id: String,
                       @Field("nama") name: String,
                       @Field("nis") nis: String): Call<ResponseInsert>

    @FormUrlEncoded
    @POST("delete-siswa")
    fun request_delete(@Field("id") id: String): Call<ResponseInsert>

}