package ee.shanel.ideabucket.rest

import org.json.JSONObject

object SubmitIdea {
    fun submit(idea: String, category: String) {
        val json = JSONObject()
        json.put("idea", idea)
        json.put("category", category)
        APIService( {
            if (it == null) {
                println("connection error")
                return@APIService
            }
            println(it)
        } ).execute("POST", "http://86.18.157.128:1200/api/submit_idea", json.toString())
    }
}
