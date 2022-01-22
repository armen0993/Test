package com.eddy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eddy.myapplication.ui.posts.PostsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, PostsFragment())
            .commit()

    }
}