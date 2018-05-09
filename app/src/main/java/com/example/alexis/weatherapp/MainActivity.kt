package com.example.alexis.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import utils.VolleyRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun searchLocation(view: View) {
        val myRequestQueue = Volley.newRequestQueue(this)

        // Set the targeted api endpoint
        val endPoint = "/locations/v1/cities/autocomplete"
        val params = HashMap<String, String>()
        params.put("q", "Paris")

        // Instantiate the request
        val request = VolleyRequest(Request.Method.GET, "$endPoint", params, this)
        val getTopCities = request.send()

        // Add the request to the queue
        myRequestQueue.add(getTopCities)
    }
}