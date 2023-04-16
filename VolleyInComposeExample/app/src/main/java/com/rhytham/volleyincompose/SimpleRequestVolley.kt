package com.rhytham.volleyincompose

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


fun simpleRequest(context: Context):String {
    val queue = Volley.newRequestQueue(context)
    val url = "https://random-data-api.com/api/v2/credit_cards"
    var response = ""

    val stringRequest = StringRequest(Request.Method.GET,
        url, {
             // Handling Success
            Log.d("Success", "simpleRequest:${it}")
            response = it

        }, {
            // Handling Error
            Log.d("Error", "simpleRequest:${it}")
            response = "Error"
        })
    queue.add(stringRequest)
    return response
}