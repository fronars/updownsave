package ru.roge.updownsave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var mail: EditText
    lateinit var pass: EditText
    private val pattern = ("[a-z]{1,100}" + "@" + "[a-z]{1,6}" + "." + "[a-z]{1,3}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mail = findViewById(R.id.editTextTextPersonName)
        pass = findViewById(R.id.editTextTextPersonName2)
    }
    private fun emailValid(text:String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()}

    fun login(view: View) {
        if (mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty()) {
            if (emailValid(mail.text.toString())) {

                val intent = Intent(this@MainActivity, UpDownSaveActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Заполните текстовые поля", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Заполните текстовые поля", Toast.LENGTH_SHORT).show()
        }
    }
}