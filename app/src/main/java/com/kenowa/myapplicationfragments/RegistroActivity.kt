package com.kenowa.myapplicationfragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*
import java.util.*

class RegistroActivity : AppCompatActivity() {

    private lateinit var fecha: String
    private var cal = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Bandera para saber si ya se guardó una fecha
        var flag = false

        // Almacenar la fecha seleccionada en el calendario
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = "yyyy-MM-dd"
                val simpleDateFormat = SimpleDateFormat(format, Locale.US)
                fecha = simpleDateFormat.format(cal.time).toString()
                tv_fechaNacimiento.text = fecha
                flag = true
            }

        // Mostrar un calendario cuando se presione el botón de calendario
        ibtn_calendario.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // Configurar las características de vista del spinner de ciudades
        val spinner: Spinner = findViewById(R.id.sp_lugarNacimiento)
        ArrayAdapter.createFromResource(
            this,
            R.array.lista_ciudades,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // Registrar la información una vez se oprima el botón de guardar
        btn_guardar.setOnClickListener {
            val nombre = et_nombre.text.toString()
            val correo = et_correo.text.toString()
            val telefono = et_telefono.text.toString()
            val clave = et_clave.text.toString()
            val claveAgain = et_claveAgain.text.toString()
            val ciudad = sp_lugarNacimiento.selectedItem.toString()
            //val genero = if (rbtn_masculino.isChecked) "Masculino" else "Femenino"

            if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty() || clave.isEmpty() ||
                claveAgain.isEmpty() || !flag || ciudad == "Seleccione una ciudad") {
                Toast.makeText(this, "Registro incompleto!\nHay campos vacíos", Toast.LENGTH_SHORT).show()
            } else {
                if (clave.length >= 6) {
                    if (clave == claveAgain) {
                        val intent = Intent(this, LoginActivity::class.java )
                        intent.putExtra( "nombre", nombre )
                        intent.putExtra( "correo", correo )
                        intent.putExtra("clave", clave)
                        startActivity(intent)
                        Toast.makeText(this, "Registro exitoso!", Toast.LENGTH_SHORT).show()
                        finish()
                    } else{
                        Toast.makeText(this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Contraseñas de 6 caracteres mínimo", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}