package com.domino.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val contentModels = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark2)

        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(this,contentModels)
        recyclerView.adapter=rvAdapter


        recyclerView.layoutManager = GridLayoutManager(this,2)




        myBookmarkRef
            .child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    for(dataModel in snapshot.children)
                    {
                        Log.d("Datamodel",dataModel.toString())
                        contentModels.add(dataModel.getValue(ContentsModel::class.java)!!)
                    }

                    rvAdapter.notifyDataSetChanged() // 어댑터 동기화

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark","dbError")
                }

            })
    }
}