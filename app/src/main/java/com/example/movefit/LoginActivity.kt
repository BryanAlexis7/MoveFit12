package com.example.movefit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)  // Debe vincular al layout correcto

        // Busca los campos de texto y botones
        val usernameEditText = findViewById<EditText>(R.id.et_username)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val submitButton = findViewById<Button>(R.id.btn_login)  // Asegúrate que el ID sea correcto
        val registrarButton = findViewById<Button>(R.id.btn_registrar)  // Asegúrate que este botón exista

        // Configura el listener para el botón "Enviar"
        submitButton.setOnClickListener {
            // Aquí va la lógica para validar el inicio de sesión
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Ejemplo de validación simple
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Lógica de inicio de sesión aquí
            } else {
                // Mostrar un mensaje de error si los campos están vacíos
            }
        }

        // Configura el listener para el botón de registro
        registrarButton.setOnClickListener {
            // Crea un Intent para navegar a RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)  // Lanza la actividad de registro
        }
    }
}
