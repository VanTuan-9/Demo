package com.example.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.demo.databinding.ActivityMainBinding


class DemoLiveDataAct : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val countData: MutableLiveData<Int> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // LiveData<Int>() // retrofit trả về. RoomDb trả về
        // MutableLiveData<Int>() /// Mình tạo ra .

        countData.value = 4                 // Main thread
        countData.postValue(4)         // Thread

        binding.btnReplace.setOnClickListener {

            val current = countData.value ?: 0
            countData.value = current + 1
        }

        binding.btnReplace3.setOnClickListener {
            val current = countData.value ?: 0
            countData.value = current + 3
        }

        countData.observe(this, Observer {
            binding.countTv.text = (it ?: 0).toString()
        })
    }
}
