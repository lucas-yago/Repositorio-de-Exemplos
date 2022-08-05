package com.lucasyago.aprendendoretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasyago.aprendendoretrofit.entities.PostEntity
import com.lucasyago.aprendendoretrofit.services.PostServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClient.createService(PostServices::class.java)
        val call: Call<List<PostEntity>> = service.list()
        call.enqueue(object : Callback<List<PostEntity>>{
            override fun onResponse(call: Call<List<PostEntity>>,response: Response<List<PostEntity>>) {
                val list = response.body()
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                val s = ""
            }

        })




    }
}
