package id.com.imastudio.retrofitkotlinapp

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.co.imastudio.retrofitkotlinapp.R

/**
 * Created by nandoseptianhusni on 8/23/17.
 */
class Custom : RecyclerView.Adapter<Custom.MyHolder> {
    override fun onBindViewHolder(holder: MyHolder?, position: Int) {

        holder?.textupdate?.setOnClickListener {

            var intent = Intent(c, UpdateDelete::class.java)
            intent.putExtra("id",data2?.get(position)?.id)
            intent.putExtra("nama",data2?.get(position)?.nama)
            intent.putExtra("nis",data2?.get(position)?.nis)
            c?.startActivity(intent)
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var c  : Activity? = null
    var data2 : List<Datum>? = null

    constructor(c: Activity?, data2: List<Datum>?) {
        this.c = c
        this.data2 = data2
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var textupdate : TextView? = itemView?.findViewById(R.id.linkupdate)

    }


}