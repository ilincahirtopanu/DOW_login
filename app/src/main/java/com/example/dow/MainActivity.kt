package com.example.dow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dow.ui.theme.DOWTheme

class MainActivity : ComponentActivity() {

    private lateinit var loginButton: Button
    private lateinit var myPassword: EditText
    private lateinit var myUsername: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginButton=findViewById(R.id.loginButton)
        myUsername=findViewById(R.id.usernameTxt)
        myPassword=findViewById(R.id.password)

        loginButton.setOnClickListener {

            if (myUsername.text.isEmpty() || myPassword.text.isEmpty()) {
                Toast.makeText(
                    this,
                    "Username and password cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val mySecondScreenIntent= Intent(this@MainActivity, SecondActivity::class.java)
            mySecondScreenIntent.putExtra("username", myUsername.text.toString())

            startActivity(mySecondScreenIntent)

        }
    }


}
