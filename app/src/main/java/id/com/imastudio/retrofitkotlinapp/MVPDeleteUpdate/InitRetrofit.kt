package id.com.imastudio.retrofitkotlinapp.MVPDeleteUpdate

import id.com.imastudio.retrofitkotlinapp.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by nandoseptianhusni on 8/22/17.
 */
class InitRetrofit {


    //function untuk inizialise retrofit
    fun getInitRetrofit(): Retrofit {

        return Retrofit.Builder().
                baseUrl("http://192.168.20.177/lumen-api24/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


    }

   fun getInitInstance(): ApiService {
        return getInitRetrofit().create(ApiService::class.java)
    }
}

