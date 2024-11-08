package com.bird394proj.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bird394proj.data.Bird
import com.bird394proj.databinding.ActivityBirdDetailBinding

class BirdDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBirdDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBirdDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the Bird object using Serializable
        val bird = intent.getSerializableExtra("bird") as? Bird
        if (bird != null) {
            displayBirdDetails(bird)
        }
    }

    private fun displayBirdDetails(bird: Bird) = with(binding) {
        birdNameDetail.text = bird.name
        birdScientificName.text = bird.scientificName
        birdHabitat.text = bird.habitat
        birdFunFact.text = bird.funFact
        birdImage.setImageResource(bird.imageResId)
    }
}

