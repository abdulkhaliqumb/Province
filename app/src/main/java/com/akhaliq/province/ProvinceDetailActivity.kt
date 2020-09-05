package com.akhaliq.province

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProvinceDetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province_detail)

        supportActionBar?.hide()

        val btnBack: Button = findViewById(R.id.btn_Back)
        val ivImageProvince: ImageView = findViewById(R.id.tvImageProvince)
        val tvNamaPropinsi: TextView = findViewById(R.id.tvNamaPropinsi)
        val tvKeterangan: TextView = findViewById(R.id.tvKeterangan)
        val tvLuas: TextView = findViewById(R.id.tvLuas)
        val tvLaguDaerah: TextView = findViewById(R.id.tvLaguDaerah)
        val tvJumlahSatuanPemerintahan: TextView = findViewById(R.id.tvJumlahSatuanPemerintahan)
        val tvIbuKota: TextView = findViewById(R.id.tvIbuKota)
        val tvHariJadi: TextView = findViewById(R.id.tvHariJadi)

        val imageProvince = intent.getStringExtra(EXTRA_IMAGE)
        val namaPropinsi = intent.getStringExtra(EXTRA_NAMA)
        val keterangan = intent.getStringExtra(EXTRA_KETERANGAN)
        val luas = intent.getStringExtra(EXTRA_LUAS)
        val laguDaerah = intent.getStringExtra(EXTRA_LAGU)
        val jumlahSatuanPemerintahan = intent.getStringExtra(EXTRA_SATUAN)
        val ibuKota = intent.getStringExtra(EXTRA_IBUKOTA)
        val hariJadi = intent.getStringExtra(EXTRA_HARIJADI)




        Glide.with(this)
            .load(
                this.applicationContext.resources.getIdentifier(
                    imageProvince,
                    "drawable",
                    this.applicationContext.packageName
                )
            )
            .apply(RequestOptions())
            .into(ivImageProvince)

        tvNamaPropinsi.text = namaPropinsi
        tvKeterangan.text = keterangan
        tvLuas.text = "Luas " + luas
        tvLaguDaerah.text = laguDaerah
        tvJumlahSatuanPemerintahan.text = jumlahSatuanPemerintahan
        tvIbuKota.text = "Ibu Kota " + ibuKota
        tvHariJadi.text = hariJadi

        btnBack.setOnClickListener(this)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {

        const val EXTRA_IMAGE = "imageProvince"
        const val EXTRA_NAMA = "namaPropinsi"
        const val EXTRA_KETERANGAN = "keterangan"
        const val EXTRA_LUAS = "luas"
        const val EXTRA_LAGU = "laguDaerah"
        const val EXTRA_SATUAN = "jumlahSatuanPemerintahan"
        const val EXTRA_IBUKOTA = "ibuKota"
        const val EXTRA_HARIJADI = "hariJadi"

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_Back -> {
                val iMainActivity = Intent(this@ProvinceDetailActivity, MainActivity::class.java)
                startActivity(iMainActivity)
            }
        }

    }

}