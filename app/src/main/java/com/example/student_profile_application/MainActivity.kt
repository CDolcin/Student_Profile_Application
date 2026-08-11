package com.example.student_profile_application

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Enable modern edge-to-edge drawing capabilities
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 2. Fix the Inset padding error by targeting the ScrollView component at the root index
        val rootScrollView = findViewById<android.widget.ScrollView>(android.R.id.content).getChildAt(0)
        ViewCompat.setOnApplyWindowInsetsListener(rootScrollView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Initialize all layout input views from activity_main.xml
        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etStudentId = findViewById<EditText>(R.id.etStudentId)
        val etProgramme = findViewById<EditText>(R.id.etProgramme)
        val etDepartment = findViewById<EditText>(R.id.etDepartment)
        val etSemester = findViewById<EditText>(R.id.etSemester)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)

        // 4. Initialize action components
        val imgProfilePicture = findViewById<ImageView>(R.id.imgProfilePicture)
        val btnAddPicture = findViewById<Button>(R.id.btnAddPicture)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnEdit = findViewById<Button>(R.id.btnEdit)

        // 5. Handle Click Interactions: Add Profile Picture Prompt
        btnAddPicture.setOnClickListener {
            Toast.makeText(this, "Profile picture upload function triggered", Toast.LENGTH_SHORT).show()
        }

        // 6. Handle Click Interactions: Save Student Profile Information
        btnSave.setOnClickListener {
            val name = etFullName.text.toString().trim()
            val studentId = etStudentId.text.toString().trim()

            if (name.isEmpty() || studentId.isEmpty()) {
                Toast.makeText(this, "Please fill out required fields (Name & Student ID)", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Profile saved successfully for: $name", Toast.LENGTH_LONG).show()
            }
        }

        // 7. Handle Click Interactions: Clear Form Input Fields
        btnClear.setOnClickListener {
            etFullName.text.clear()
            etStudentId.text.clear()
            etProgramme.text.clear()
            etDepartment.text.clear()
            etSemester.text.clear()
            etEmail.text.clear()
            etPhone.text.clear()
            Toast.makeText(this, "Form fields cleared", Toast.LENGTH_SHORT).show()
        }

        // 8. Handle Click Interactions: Edit Student Details Functionality Trigger
        btnEdit.setOnClickListener {
            Toast.makeText(this, "Editing enabled for input profiles", Toast.LENGTH_SHORT).show()
        }
    }
}
