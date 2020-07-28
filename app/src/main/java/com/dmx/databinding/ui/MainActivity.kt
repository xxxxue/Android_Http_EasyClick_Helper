package com.dmx.databinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.dmx.databinding.MyListAdapter
import com.dmx.databinding.R
import com.dmx.databinding.databinding.ActivityMainBinding
import com.dmx.databinding.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        //绑定 viewModel
        val viewModel = MainViewModel()
        binding.vm = viewModel

        //绑定 list
        val myAdapter = MyListAdapter(viewModel.list)

        myAdapter.setOnItemClickListener { _, view, position ->
            viewModel.onItemClick(
                view,
                position
            )
        }
        binding.rvList.adapter = myAdapter
    }
}