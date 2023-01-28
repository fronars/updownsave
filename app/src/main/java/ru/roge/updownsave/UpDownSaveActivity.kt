package ru.roge.updownsave

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

private var counter = 0
private var prefs: SharedPreferences? = null
lateinit var textView: TextView

class UpDownSaveActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_up_down_save)
        textView = findViewById(R.id.textView)
        prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        counter = prefs?.getInt("counter", 0)!!
        textView.text = counter.toString()
    }

    fun addition(view: View){
        counter++
        textView.text = counter.toString()
    }

    fun subtraction(view: View){
        counter--
        textView.text = counter.toString()
    }
    fun save(view: View){
        saveData(counter)
    }
    private fun saveData(result: Int){
        val editor = prefs?.edit()
        editor?.putInt("counter", result)
        editor?.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData(counter)
    }
}