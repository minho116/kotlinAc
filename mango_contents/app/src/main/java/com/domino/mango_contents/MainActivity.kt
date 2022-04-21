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
        items.add(
            ContentsModel("https://www.mangoplate.com/restaurants/2J0axpUplhy7",
                "https://mp-seoul-image-production-s3.mangoplate.com/283112/53774_1597724351125_60274?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "옥동식")
        )
        items.add(
            ContentsModel("https://www.mangoplate.com/restaurants/lx7BAVdqCpLm",
                "https://mp-seoul-image-production-s3.mangoplate.com/1601255_1629723658048924.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "아스트랄")
        )
        items.add(
            ContentsModel("https://www.mangoplate.com/restaurants/Lj8LbMuvciWk",
                "https://mp-seoul-image-production-s3.mangoplate.com/872233_1620809693230837.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "울다이닝")
        )
        items.add(
            ContentsModel("https://www.mangoplate.com/restaurants/ne_LkgB6a_Fp",
                "https://mp-seoul-image-production-s3.mangoplate.com/463989_1639533259805174.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "비아 톨레도 파스타바")
        )
        items.add(
            ContentsModel("https://www.mangoplate.com/restaurants/c0QnYuxR7ioD",
                "https://mp-seoul-image-production-s3.mangoplate.com/1454700_1615468261313272.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "심퍼티쿠시")
        
       



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
