package com.example.reddit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reddit.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: adapter
    private val redditData = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = adapter(redditData)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.reddit.com/top.json?")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchData(){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<response> = getRetrofit().create(IService::class.java).getINformationReddit("limit=10")
            val dataResponse: response? = call.body()

            if(call.isSuccessful) {
                //Show Recycler
                val redditDataResponse: List<String> = dataResponse?.data ?: emptyList()
                redditData.clear()
                redditData.addAll(redditDataResponse)
                adapter.notifyDataSetChanged()

            } else {
                showError()
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Error ", Toast.LENGTH_SHORT).show()
    }
}