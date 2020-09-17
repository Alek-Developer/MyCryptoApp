package com.gsixacademy.android.mycryptoapp.modules.home.adapters

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.gsixacademy.android.mycryptoapp.R
import com.gsixacademy.android.mycryptoapp.models.Crypto
import kotlinx.android.synthetic.main.crypto_item_layout.view.*
import java.text.DecimalFormat

class CryptoAdapter(val context: Activity,val coinList: ArrayList<Crypto>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.crypto_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(coinList[position])
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(itemModel : Crypto) {

     GlideToVectorYou.justLoadImage(context, Uri.parse(itemModel.iconUrl),itemView.cryptoIv)

            itemView.cryptoNameTv.text = itemModel.name
            itemView.cryptoSymbolTv.text = itemModel.symbol
            itemView.cryptoPriceTv.text = getformatter()?.format(itemModel.price?.toBigDecimal())

            if (itemModel.change!! < 0.0) {
                itemView.changeTv.setTextColor(context.resources.getColor(R.color.red))
                itemView.changeTv.text = itemModel.change.toString().substring(1,itemModel.change.toString().length) + "%"
                itemView.changeIv.setImageResource(R.drawable.arrow_down)

            }else {
                itemView.changeTv.setTextColor(context.resources.getColor(R.color.colorPrimary))
                itemView.changeTv.text = itemModel.change.toString()
                itemView.changeIv.setImageResource(R.drawable.arrow_up)
            }

        }
    }


    fun getformatter(): DecimalFormat? {
        val formatter = DecimalFormat( "#,###.##")
        formatter.minimumFractionDigits = 2
        return formatter
    }

}