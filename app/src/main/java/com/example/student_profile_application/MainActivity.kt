package com.example.student_profile_application

import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        enableEdgeToEdge()

        // Load activity_main.xml
        setContentView(R.layout.activity_main)

        // =========================================================
        // SCROLL VIEW
        // =========================================================

        val rootScrollView =
            findViewById<ScrollView>(R.id.mainScrollView)

        ViewCompat.setOnApplyWindowInsetsListener(rootScrollView) { view, insets ->

            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // =========================================================
        // BUTTONS
        // =========================================================

        val btnAddPicture =
            findViewById<Button>(R.id.btnAddPicture)

        val btnSave =
            findViewById<Button>(R.id.btnSave)

        val btnClear =
            findViewById<Button>(R.id.btnClear)

        val btnEdit =
            findViewById<Button>(R.id.btnEdit)


        // =========================================================
        // ADD PICTURE BUTTON
        // =========================================================

        btnAddPicture.setOnClickListener {

            Toast.makeText(
                this,
                getString(R.string.profile_picture_upload),
                Toast.LENGTH_SHORT
            ).show()
        }


        // =========================================================
        // SAVE BUTTON
        // =========================================================

        btnSave.setOnClickListener {

            Toast.makeText(
                this,
                getString(R.string.profile_saved),
                Toast.LENGTH_LONG
            ).show()
        }


        // =========================================================
        // CLEAR BUTTON
        // =========================================================

        btnClear.setOnClickListener {

            Toast.makeText(
                this,
                getString(R.string.profile_cleared),
                Toast.LENGTH_SHORT
            ).show()
        }


        // =========================================================
        // EDIT BUTTON
        // =========================================================

        btnEdit.setOnClickListener {

            Toast.makeText(
                this,
                getString(R.string.edit_clicked),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}