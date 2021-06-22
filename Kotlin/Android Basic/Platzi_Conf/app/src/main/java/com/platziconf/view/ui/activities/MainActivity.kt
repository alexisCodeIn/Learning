package com.platziconf.view.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.platziconf.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.toolbarMain))
        configNav()
    }

    private fun configNav(){
        NavigationUI.setupWithNavController(buttonNavigationView_Menu, Navigation.findNavController(this,R.id.fragContent))
    }
}

