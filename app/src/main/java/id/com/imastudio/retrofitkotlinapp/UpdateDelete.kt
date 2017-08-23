package id.com.imastudio.retrofitkotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import id.com.imastudio.retrofitkotlinapp.MVPDeleteUpdate.PresenterModel
import id.com.imastudio.retrofitkotlinapp.MVPDeleteUpdate.PresenterUpdateHapus
import kotlinx.android.synthetic.main.activity_update_delete.*

class UpdateDelete : AppCompatActivity(), PresenterModel {


    //deklrasi variable untuk penampung index
    var id: Long? = null
    var name: String? = null
    var nis: Long? = null

    var presenter: PresenterUpdateHapus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(id.co.imastudio.retrofitkotlinapp.R.layout.activity_update_delete)


        id = intent.getLongExtra("id", 0)
        name = intent.getStringExtra("nama")
        nis = intent.getLongExtra("nis", 0)

        presenter = id.com.imastudio.retrofitkotlinapp.MVPDeleteUpdate.PresenterUpdateHapus(this)

        tambahname.setText(name)
        tambahnis.setText(nis.toString())

        btnhapus.setOnClickListener {
            presenter!!.Hapus(id.toString())

        }


    }

    override fun Hasil(result: String, msg: String,status : Int) {

        if(status == 0 ){

        }
        else{

        }
        if(result.equals("true")){
            startActivity(Intent(applicationContext, id.com.imastudio.retrofitkotlinapp.MainActivity::class.java))
            finish()
        }
        else{

            Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()

        }
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {

        Log.e("error update",error.toString())
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
