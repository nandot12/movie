package id.com.imastudio.retrofitkotlinapp

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import id.co.imastudio.retrofitkotlinapp.R
import id.com.imastudio.retrofitkotlinapp.MVPDeleteUpdate.InitRetrofit
import kotlinx.android.synthetic.main.activity_tambah.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)


        btnsubmit.setOnClickListener {
            //get inputan
            var name = tambahname.text.toString()
            var nis = tambahnis.text.toString()
            if(name.isNotEmpty() && nis.isNotEmpty()){

                //get inisialisasi
                var getInit = InitRetrofit().getInitInstance()
                //get request
                var request = getInit.request_insert(name,nis.toInt(),1)

                var progress = ProgressDialog(applicationContext)
                progress.setMessage("loading")
                progress.show()

                //get response

                request.enqueue(object : Callback<ResponseInsert>{
                    override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
                        progress.dismiss()
                        Log.d("Error insert",t.toString())
                       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
                        progress.dismiss()
                        Log.d("response insert :",response?.message())
                        if (response != null) {
                            if(response.isSuccessful && response.body()?.status.equals("true")){

                                startActivity(Intent(applicationContext, MainActivity::class.java))
                                finish()




                            }
                        }




                      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })


            }
        }
    }
}
