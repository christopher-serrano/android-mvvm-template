package moe.cachapa.android.mvvm.template.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import moe.cachapa.android.mvvm.template.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}