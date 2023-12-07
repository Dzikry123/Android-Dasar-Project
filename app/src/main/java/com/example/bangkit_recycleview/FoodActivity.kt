package com.example.bangkit_recycleview

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        lateinit var button : Button

        val headingFood : TextView = findViewById(R.id.headingFood)
        val ImageFood : ImageView = findViewById(R.id.image)
        val descFood : TextView = findViewById(R.id.desc)

        val bundle: Bundle? = intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageArticle")
        val desc = bundle!!.getString("desc")

        headingFood.text = heading
        ImageFood.setImageResource(imageId)
        descFood.text = desc

        // share button
        button = findViewById(R.id.shareButton)
        val dataShare = "Food Name : \n ${headingFood.text} \n" + "\n Description : \n ${descFood.text}"
        button.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, dataShare)
            // choose app for sharing
            val chooseApp = Intent.createChooser(intent, "Share this data using....")
            startActivity(chooseApp)

            // String Array

//
//        val stringArray = resources.getStringArray(R.array.string_array_name)
//            val element1 = stringArray[0]
//            val element2 = stringArray[1]
//
//        val textView = findViewById<TextView>(R.id.string_array)
//            textView.text = element1

        }
    }
}