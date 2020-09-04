package com.akhaliq.province

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvProvince: RecyclerView
    private var listFilter: ArrayList<Province> = arrayListOf()
    private var listResult: ArrayList<Province> = arrayListOf()
    private lateinit var msg: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "List Propinsi"

        val dataSearch: EditText = findViewById(R.id.dataSearch)
        rvProvince = findViewById(R.id.rvProvince)
        rvProvince.setHasFixedSize(true)

        dataSearch.addTextChangedListener(textWatcher)

        //check if the EditText have values or not
        msg= dataSearch.text.toString()
        if(msg.trim().length<1){
            listResult.addAll(ProvinceData.listData)
            showRecyclerList()
        }
    }


    private fun showRecyclerList() {
        rvProvince.layoutManager = LinearLayoutManager(this)
        val listProvinceAdapter = ListProvinceAdapter(listResult)
        rvProvince.adapter = listProvinceAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.person, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.profile -> {
                val iAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(iAbout)
            }
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //output.text = s
            //Toast.makeText(applicationContext, "Maximum Limit Reached "+s.toString(), Toast.LENGTH_SHORT).show()

            listFilter= arrayListOf()
            listResult= arrayListOf()
            listFilter.addAll(ProvinceData.listData)
            var datatemp:String
            for (data in listFilter) {
                datatemp=data.namaPropinsi.toLowerCase()
                if (datatemp.contains(s.toString().toLowerCase())) {
                     listResult.add(data)}
                }
              showRecyclerList()
            }


        }
}