package com.akhaliq.province

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListProvinceAdapter(val listProvince: ArrayList<Province>) : RecyclerView.Adapter<ListProvinceAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_province, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProvince.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (imageProvince, namaPropinsi, keterangan, luas, laguDaerah,jumlahSatuanPemerintahan,ibuKota,hariJadi) = listProvince[position]

        Glide.with(holder.itemView.context)
            .load(holder.itemView.context.getResources().getIdentifier(imageProvince, "drawable", holder.itemView.context.getPackageName()))
            .apply(RequestOptions().override(65, 65))
            .into(holder.imgLogo);

        holder.tvNamaPropinsi.text = namaPropinsi
        holder.tvIbukota.text = "Ibu Kota "+ibuKota  //+" "+imageProvince
        holder.tvLuas.text = "Luas "+luas

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            //Toast.makeText(mContext, "OKKK  : "+ibuKota, Toast.LENGTH_SHORT).show()

        val moveWithDataIntent  = Intent(mContext, ProvinceDetailActivity::class.java)
        moveWithDataIntent .putExtra(ProvinceDetailActivity.EXTRA_IMAGE, imageProvince)
        moveWithDataIntent .putExtra(ProvinceDetailActivity.EXTRA_NAMA, namaPropinsi)
        moveWithDataIntent .putExtra(ProvinceDetailActivity.EXTRA_KETERANGAN, keterangan)
        moveWithDataIntent .putExtra(ProvinceDetailActivity.EXTRA_LUAS, luas)
        moveWithDataIntent .putExtra(ProvinceDetailActivity.EXTRA_LAGU, laguDaerah)
        moveWithDataIntent .putExtra(ProvinceDetailActivity.EXTRA_SATUAN, jumlahSatuanPemerintahan)
        moveWithDataIntent .putExtra(ProvinceDetailActivity.EXTRA_IBUKOTA, ibuKota)
        moveWithDataIntent .putExtra(ProvinceDetailActivity.EXTRA_HARIJADI, hariJadi)
        mContext.startActivity(moveWithDataIntent )

        }

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNamaPropinsi: TextView = itemView.findViewById(R.id.tvNamaPropinsi)
        var tvIbukota: TextView = itemView.findViewById(R.id.tvIbukota)
        var tvLuas: TextView = itemView.findViewById(R.id.tvLuas)
        var imgLogo: ImageView = itemView.findViewById(R.id.imgLogo)
    }


}