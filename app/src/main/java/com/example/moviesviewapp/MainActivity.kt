package com.example.moviesviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
    }

    private fun fetchData() {
        val url = "C:\\Users\\Manohar\\AndroidStudioProjects\\moviesviewapp\\app\\src\\main\\java\\com\\example\\moviesviewapp\\Film.JSON"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val movieList = Gson().fromJson(response.toString(), MovieList::class.java)
                movieAdapter = MovieAdapter(movieList.movies)

                recyclerView.adapter = movieAdapter
            },
            Response.ErrorListener { error ->
                // Handle error
            }
        )

        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
}
