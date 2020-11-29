package com.example.hostelmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.hostelmanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sets up action bar (back button)


        val navController=this.findNavController(R.id.myNavHostFragment)


//        val navHostFragment=supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
//        val navController=navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    //setting up funcitonality to back button
    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}