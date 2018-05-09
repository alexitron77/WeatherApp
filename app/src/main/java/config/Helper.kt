package config

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.example.alexis.weatherapp.R
import java.io.InputStream
import java.util.*
import kotlin.collections.HashMap

class Helper {

    fun getProperty(context: Context, property: String): String {
        val resources: Resources = context.getResources()

        try {
            val rawResources: InputStream = resources.openRawResource(R.raw.config)
            val properties = Properties()
            properties.load(rawResources)
            return properties.getProperty(property)
        } catch (e: Resources.NotFoundException) {
            Log.e("Error", "Fail to find property")
        }
        return ""
    }

    fun urlBuilder(url: String, key: String, params: HashMap<String, String>): String {
        val path = StringBuilder()
        path.append("$url?apikey=$key")

        params.forEach { (k, v) -> path.append("&$k=$v") }
        Log.d("URL", path.toString())
        return path.toString()
    }

}