package com.quickupapps.practiceroomdb

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.quickupapps.practiceroomdb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up button click listeners
        findViewById<Button>(R.id.create_button).setOnClickListener {
            val subjects = listOf(Subject(85, 90, 80))
            val user = User( 1,"John Doe", subjects)
            userViewModel.insertUser(user)
        }

        findViewById<Button>(R.id.update_button).setOnClickListener {
            val subjects = listOf(Subject(88, 92, 85))
            val user = User(1,"John Doe", subjects)
            userViewModel.updateUser(user)
        }

        findViewById<Button>(R.id.delete_button).setOnClickListener {
            val user = User(1, "John Doe", emptyList())
            userViewModel.deleteUser(user)
        }

        findViewById<Button>(R.id.fetch_button).setOnClickListener {
            userViewModel.getUser(1) { user ->
                user?.let {
                    findViewById<TextView>(R.id.user_info_textview).text = user.toString()
                }
                if (user == null) {
                    findViewById<TextView>(R.id.user_info_textview).text = ""
                }
            }
        }
    }
}
