package com.example.commuterpedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class DetailIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_intent)

        val train = intent.getParcelableExtra<Parcelable>("train") as Train

        val trainName: TextView = findViewById(R.id.tvTrainName)
        val trainNameJp: TextView = findViewById(R.id.tvTrainNameJp)
        val trainDesc: TextView = findViewById(R.id.tvTrainDesc)
        val trainPhoto: ImageView = findViewById(R.id.ivTrainPhoto)
        val trainLogo: ImageView = findViewById(R.id.ivTrainLogo)

        trainName.text = train.nameid
        trainNameJp.text = train.namejp
        trainDesc.text = train.description
        trainPhoto.setImageResource(train.image)
        trainLogo.setImageResource(train.logo)

        }
    }