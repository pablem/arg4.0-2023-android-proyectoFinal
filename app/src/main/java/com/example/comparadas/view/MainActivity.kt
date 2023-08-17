package com.example.comparadas.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.comparadas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparator.observe(this) {
            //println("Se realizó la comparación: $it")
            binding.messageResult.text = "${it.isEqualMessage}"
        }

        binding.compareButton.setOnClickListener {
            mainViewModel.compare(binding.text1.text.toString(),binding.text2.text.toString())
        }
    }
}