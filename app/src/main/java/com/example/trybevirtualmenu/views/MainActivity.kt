package com.example.trybevirtualmenu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.adapters.MenuAdapter
import com.example.trybevirtualmenu.interfaces.MenuItemListener
import com.example.trybevirtualmenu.models.MenuDatabase

class MainActivity : AppCompatActivity(), MenuItemListener {

    private val menuList: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dishs = MenuDatabase.getMenu()

        val adapter = MenuAdapter(dishs)

        adapter.setMenuListener(this)

        menuList.layoutManager = LinearLayoutManager(baseContext)
        menuList.adapter = adapter
    }

    override fun setMenuItemClickListener(v: View, position: Int) {
        val it = Intent(baseContext, MenuItemDetailActivity::class.java)
        it.putExtra("dishPosition", position)
        startActivity(it)
    }
}
