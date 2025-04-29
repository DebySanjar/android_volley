package com.uz.volleyandnetworkcheck

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.uz.volleyandnetworkcheck.adapter.UserAdapter
import com.uz.volleyandnetworkcheck.databinding.ActivityMainBinding
import com.uz.volleyandnetworkcheck.model.User
import com.uz.volleyandnetworkcheck.util.NetworkUtils

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recy
        recyclerView.setHasFixedSize(true)

        if (NetworkUtils.isNetworkAvailable(this)) {
            fetchFollowers()
        } else {
            Log.e(TAG, "Internet yo'q")
            Toast.makeText(this, "Internet aloqasi yo'q!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchFollowers() {
        val url = "https://api.github.com/users/mojombo/followers"
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                val userList = mutableListOf<User>()

                for (i in 0 until response.length()) {
                    val jsonObject = response.getJSONObject(i)
                    val id = jsonObject.getInt("id")
                    val login = jsonObject.getString("login")
                    val avatarUrl = jsonObject.getString("avatar_url")
                    val userType = jsonObject.getString("user_view_type")
                    val profileUrl = jsonObject.getString("html_url")
                    userList.add(User(id, login, avatarUrl, userType, profileUrl))
                }

                recyclerView.adapter = UserAdapter(userList)
            },
            { error ->
                Log.e(TAG, error.toString())
            }
        )

        Volley.newRequestQueue(this).add(jsonArrayRequest)
    }
}
