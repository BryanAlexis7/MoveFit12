package com.example.movefit

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_course_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener las vistas del layout
        val courseNameTextView = findViewById<TextView>(R.id.tv_course_name)
        val courseDescriptionTextView = findViewById<TextView>(R.id.tv_course_description)
        val courseImageView = findViewById<ImageView>(R.id.iv_course_image)

        // Obtener los datos del curso desde el Intent
        val intent: Intent = intent
        val courseName = intent.getStringExtra("COURSE_NAME")
        val courseDescription = intent.getStringExtra("COURSE_DESCRIPTION")
        val courseImage = intent.getIntExtra("COURSE_IMAGE", -1)

        // Mostrar los datos en las vistas
        courseNameTextView.text = courseName
        courseDescriptionTextView.text = courseDescription
        if (courseImage != -1) {
            courseImageView.setImageResource(courseImage)
        }
    }
}
