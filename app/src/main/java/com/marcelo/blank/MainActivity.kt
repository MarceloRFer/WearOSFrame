package com.marcelo.blank

import android.app.Activity
import android.os.Bundle
import com.marcelo.blank.databinding.ActivityMainBinding
import java.time.Duration

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener{
            println(">>> BUTTON START")
        }

        binding.btnPause.setOnClickListener {
            println(">>>> BUTTON PAUSE")
        }

        binding.textTime.text = formatElapsedTime(Duration.ZERO, true )

    }

}

