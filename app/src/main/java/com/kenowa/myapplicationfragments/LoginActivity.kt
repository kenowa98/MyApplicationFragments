package com.kenowa.myapplicationfragments

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_registro.setOnClickListener {
            val intent = Intent( this, RegistroActivity::class.java )
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            val datosRegistrados = intent.extras
            val nombre = datosRegistrados?.getString("nombre")
            val correo = datosRegistrados?.getString("correo")
            val clave = datosRegistrados?.getString("clave")
            if (et_email.text.toString() == correo && et_clave.text.toString() == clave) {
                val intent = Intent( this, MainActivity::class.java )
                intent.putExtra( "nombre", nombre )
                intent.putExtra( "correo", correo )
                intent.putExtra( "clave", clave )
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                Toast.makeText(this, "Correo y/o contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}