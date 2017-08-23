package id.com.imastudio.retrofitkotlinapp.MVPDeleteUpdate

import android.util.Log
import id.com.imastudio.retrofitkotlinapp.ResponseInsert
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by nandoseptianhusni on 8/23/17.
 */
class PresenterUpdateHapus {

    var presenterView : PresenterModel? = null

    constructor(presenterView: PresenterModel?) {
        this.presenterView = presenterView
    }

    fun Hapus(id : String){
        //get inisialisasi
        var getInit = InitRetrofit().getInitInstance()
        //get request
        var request = getInit.request_delete(id)

//        var progress = ProgressDialog(applicationContext)
//        progress.setMessage("loading")
//        progress.show()

        //get response

        request.enqueue(object : Callback<ResponseInsert> {
            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
              //  progress.dismiss()
                Log.d("Error insert",t.toString())

                presenterView?.Error(t.toString())
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
               // progress.dismiss()
                Log.d("response insert :",response?.message())
                if (response != null) {
                    if(response.isSuccessful && response.body()?.status.equals("true")){

                        var result = response.body()?.status
                        var msg = response.body()?.msg

                        presenterView?.Hasil(result!!, msg!!,0)






                    }
                }




                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }

}