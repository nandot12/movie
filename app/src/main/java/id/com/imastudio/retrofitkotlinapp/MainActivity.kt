package id.com.imastudio.retrofitkotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import id.co.imastudio.retrofitkotlinapp.R
import id.com.imastudio.retrofitkotlinapp.MVPDeleteUpdate.InitRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dapatData()

        img2.setOnClickListener {

            startActivity(Intent(applicationContext, TambahActivity::class.java))
        }
    }

    private fun dapatData() {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //get init
        var api = InitRetrofit().getInitInstance()
        //get request
        var call = api.request_getdata()
        call.enqueue(object  : Callback<ResponseData>{
            override fun onFailure(call: Call<ResponseData>?, t: Throwable?) {
                Log.d("error get data :",t.toString())
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<ResponseData>?, response: Response<ResponseData>?) {

                Log.d("response get data :", response?.message())

                if (response != null) {
                    if(response.isSuccessful){
                        //get json array data
                        var data  = response.body()?.data

                        //array kita pindahkan recyclerview
                        var adapter = Custom(this@MainActivity, data)



                    }
                    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                }
            }

        })


    }
}
