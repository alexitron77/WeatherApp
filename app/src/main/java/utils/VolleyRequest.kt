package utils

import android.content.Context
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import config.Helper

class VolleyRequest(val method: Int, val endpoint: String, val params: HashMap<String, String>, val context: Context) {

    fun send(): StringRequest {
        val apiUrl: String = Helper().getProperty(context, "API_URL")
        val apiKey: String = Helper().getProperty(context, "API_KEY")

        val url = Helper().urlBuilder("$apiUrl$endpoint", apiKey, params)

        return object : StringRequest(method, url, Response.Listener<String> { response ->
            Log.d("Response", response)
        }, Response.ErrorListener { error ->
            Log.d("Error", error.toString())
        }) {
            // Add header to the request
            override fun getHeaders(): Map<String, String> {
                val header = HashMap<String, String>()
                header.put("Content-Type", "application/json; charset=utf-8")
                return header
            }

            // Set params in the body of the request
            override fun getParams(): Map<String, String> {
                var params = HashMap<String, String>()
                Log.d("Response", "TEST")
                params.put("apikey", apiKey) //Add the data you'd like to send to the server.
                return params
            }
        }
    }


}