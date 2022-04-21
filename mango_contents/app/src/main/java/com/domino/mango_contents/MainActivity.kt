package com.domino.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener {
            val intent = Intent(this,BookmarkActivity2::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel("https://www.mangoplate.com/restaurants/Cx9Cg9oPDTpK",
            "https://mp-seoul-image-production-s3.mangoplate.com/435193/533108_1648017093717_22054?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "팔레드신")
        )



        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(this,items)
        recyclerView.adapter=rvAdapter

        rvAdapter.itemClick = object: RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url",items[position].url)
                intent.putExtra("title",items[position].titleText)
                intent.putExtra("ImageURL",items[position].ImageURL)
                startActivity(intent)
            }
        }

        recyclerView.layoutManager = GridLayoutManager(this,2)
    }
}