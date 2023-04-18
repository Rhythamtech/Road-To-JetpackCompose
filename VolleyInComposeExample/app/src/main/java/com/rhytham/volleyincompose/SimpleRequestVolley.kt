package com.rhytham.volleyincompose

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


fun simpleRequest(context: Context, cardNum: MutableState<String>, cardExp: MutableState<String>) {
    val queue = Volley.newRequestQueue(context)
    val url = "https://random-data-api.com/api/v2/credit_cards"
    var response:JSONObject
    val stringRequest = StringRequest(
        Request.Method.GET, url,
        {
            // Handling Success
            Log.d("Success", "simpleRequest:${it}")
            response = JSONObject(it)

            cardNum.value = response.getString("credit_card_number")
            cardExp.value = response.getString("credit_card_expiry_date")

        }, {
            // Handling Error
            cardNum.apply { "0000-0000-0000-0000" }
            cardExp.apply {"9999-12-31"}
            Log.d("Error", "simpleRequest:${it}")
        })
    queue.add(stringRequest)
}


