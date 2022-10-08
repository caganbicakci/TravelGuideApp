package com.caganbicakci.travelguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import com.caganbicakci.travelguideapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailActivityBinding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActivityBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailActivityBinding.root)

        val args : DetailActivityArgs by navArgs()

        detailActivityBinding.apply {
            setVariable(BR.travelModel, args.travelModel)
        }
    }

}