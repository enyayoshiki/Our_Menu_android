package com.example.ourmenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.View.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(menuImage)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (menuText.text.isNotEmpty()){
            menuInflater.inflate(R.menu.context,menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            R.id.mail -> {
                val subject = getString(R.string.app_name)
                val text = "${menuText.text}が食べたい！！"
                val uri = Uri.fromParts(
                    "mailto",
                    "doremococo@yahoo.co.jp",
                    null)
                val intent = Intent(Intent.ACTION_SENDTO , uri )
                intent.putExtra(Intent.EXTRA_SUBJECT,subject)
                intent.putExtra(Intent.EXTRA_TEXT,text)
                if (intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
                return true
            }
            R.id.sms -> {
                val text = "${menuText.text}が食べたい"
                val uri = Uri.fromParts(
                    "smsto",
                    "09073167519",
                    null
                )
                val intent = Intent(Intent.ACTION_SENDTO , uri)
                intent.putExtra("smsbody",text)
                if (intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
            }
        }
        return super.onContextItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeMenu -> {
                menuImage.setImageResource(R.drawable.cooking_mama)
                menuText.text = ""
                return true
            }
            R.id.curryUdonMenu -> {
                menuImage.setImageResource(R.drawable.curry_udon)
                menuText.text = getString(R.string.curry_udon_text)
                return true
            }
            R.id.lemonRamenMenu -> {
                menuImage.setImageResource(R.drawable.ramen_lemon)
                menuText.text = getString(R.string.lemonramen_text)
                return true
            }
            R.id.gekikaraRamenMenu ->{
                menuImage.setImageResource(R.drawable.ramen_gekikara)
                menuText.text = getString(R.string.gekikararamen_text)
                return true
            }
            R.id.chankoNabeMenu -> {
                menuImage.setImageResource(R.drawable.nabe_chanko)
                menuText.text = getString(R.string.chanko_text)
                return true
            }
            R.id.nabeyakiUdonMenu -> {
                menuImage.setImageResource(R.drawable.nabeyakiudon)
                menuText.text = getString(R.string.nabeyakiudon_text)
                return true
            }
            return super.onOptionsItemSelected(item) -> return true
        }
    }
}
