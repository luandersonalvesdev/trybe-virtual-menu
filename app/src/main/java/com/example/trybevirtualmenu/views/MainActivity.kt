package com.example.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.MenuAdapter
import com.example.trybevirtualmenu.models.MenuDatabase

class MainActivity : AppCompatActivity() {

    private val menuList: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dishs = MenuDatabase.getMenu()

        menuList.layoutManager = LinearLayoutManager(baseContext)
        menuList.adapter = MenuAdapter(dishs)
    }
}
