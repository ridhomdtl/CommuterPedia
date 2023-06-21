package com.example.commuterpedia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvTrain: RecyclerView
    private val list = ArrayList<Train>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTrain = findViewById(R.id.RecyclerView)
        rvTrain.setHasFixedSize(true)

        list.addAll(getTrainList())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getTrainList(): ArrayList<Train> {
        val trainName = resources.getStringArray(R.array.fleet_type)
        val trainDesc = resources.getStringArray(R.array.fleet_description)
        val trainImage = resources.obtainTypedArray(R.array.fleet_image)
        val trainNameJp = resources.getStringArray(R.array.fleet_type_jp)
        val trainLogo = resources.obtainTypedArray(R.array.fleet_logo)
        val listTrain = ArrayList<Train>()
        for (i in trainName.indices) {
            val train =
                Train(trainImage.getResourceId(i, -1), trainName[i], trainDesc[i], trainNameJp[i], trainLogo.getResourceId(i, -1))
            listTrain.add(train)
        }
        return listTrain
    }

    private fun showRecyclerList() {
        rvTrain.layoutManager = LinearLayoutManager(this)
        val listTrainAdapter = TrainAdapter(list)
        rvTrain.adapter = listTrainAdapter
    }
}