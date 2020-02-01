package ee.shanel.ideabucket.rest

import com.google.gson.GsonBuilder
import ee.shanel.ideabucket.IdeaList
import okhttp3.*
import java.io.IOException

object RestController {
    fun getIdeas() : IdeaList {
        var retVal = IdeaList(arrayListOf())
        val url = "http://86.18.157.128:1200/api/ideas"

        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val res = response.body?.string()

                    if (res != null) {
                        val gson = GsonBuilder().create()
                        retVal = gson.fromJson(res, IdeaList::class.java)

                    }
                }


            }
            override fun onFailure(call: Call, e: IOException) {
                // Just return the empty list.
            }
        })
        while (retVal.ideas.isEmpty()) {

        }
        return retVal
    }
}