package com.example.movefit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Busca los campos de texto y botones
        val usernameEditText = findViewById<EditText>(R.id.et_username)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val submitButton = findViewById<Button>(R.id.btn_login)
        val registrarButton = findViewById<Button>(R.id.btn_registrar)

        // Configura el listener para el botón "Iniciar Sesión"
        submitButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validar los campos
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Recuperar las credenciales guardadas en SharedPreferences
                val sharedPref = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                val savedUsername = sharedPref.getString("username", null)
                val savedPassword = sharedPref.getString("password", null)

                // Validar si las credenciales coinciden
                if (username == savedUsername && password == savedPassword) {
                    // Inicio de sesión exitoso
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                    // Redirigir al MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Credenciales incorrectas
                    Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Mostrar un mensaje de error si los campos están vacíos
                Toast.makeText(this, "Por favor, ingresa el nombre de usuario y la contraseña", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura el listener para el botón de "Registrar"
        registrarButton.setOnClickListener {
            // Crea un Intent para navegar a RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)  // Lanza la actividad de registro
        }
    }
}
