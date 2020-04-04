package com.example.ourmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.homeMenu -> {
                whatFoodImage.setImageResource(R.drawable.cooking_mama)
                whatFood.text = ""
                return true
            }
            R.id.curryUdonMenu -> {
                whatFoodImage.setImageResource(R.drawable.curry_udon)
                whatFood.text = getString(R.string.curry_udon_text)
                return true
            }
            R.id.lemonRamenMenu -> {
                whatFoodImage.setImageResource(R.drawable.ramen_lemon)
                whatFood.text = getString(R.string.lemonramen_text)
                return true
            }
            R.id.gekikaraRamenMenu ->{
                whatFoodImage.setImageResource(R.drawable.ramen_gekikara)
                whatFood.text = getString(R.string.gekikararamen_text)
                return true
            }
            R.id.chankoNabeMenu -> {
                whatFoodImage.setImageResource(R.drawable.nabe_chanko)
                whatFood.text = getString(R.string.chanko_text)
                return true
            }
            R.id.nabeyakiUdonMenu -> {
                whatFoodImage.setImageResource(R.drawable.nabeyakiudon)
                whatFood.text = getString(R.string.nabeyakiudon_text)
                return true
            }
            return super.onOptionsItemSelected(item) ->{
                whatFoodImage.setImageResource(R.drawable.cooking_mama)
                whatFood.text = getString(R.string.what_food)
                return true
            }
        }
    }
}
