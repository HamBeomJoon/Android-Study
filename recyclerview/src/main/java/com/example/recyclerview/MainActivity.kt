package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val profileList = ArrayList<Profile>()
        profileList.add(Profile("안드로이드 개발자 로드맵 - Part1: The Android Platform  asljkdnaksjdjabsdjashdjkdaklhskjdhkjsa salkdhkjasjdhaskdaksdkjashadskjdhkj", "Android"))
        profileList.add(Profile("[Android] NestedScrollView에 대해 알아보자!", "Swift"))
        profileList.add(Profile("기업들은 왜 코틀린을 선택하였을까?", "Flutter"))
        profileList.add(Profile("Text4", "Python"))
        profileList.add(Profile("Text5", "C++"))
        profileList.add(Profile("Text6", "React"))
        profileList.add(Profile("Text7", "React Native"))
        profileList.add(Profile("Text8", "Rust"))
        profileList.add(Profile("Text9", "Go"))
        profileList.add(Profile("Text10", "Java"))
        profileList.add(Profile("Text11", "JavaScript"))
        profileList.add(Profile("Text12", "Kotlin"))
        profileList.add(Profile("Text13", "Dart"))
        profileList.add(Profile("Text14", "C"))
        profileList.add(Profile("Text15", "Visual Basic"))
        profileList.add(Profile("Text16", "Pascal"))
        profileList.add(Profile("Text17", "Spring"))
        profileList.add(Profile("Text18", "Go"))

        binding.rv.adapter = CustomAdapter(profileList)
        binding.rv.layoutManager = LinearLayoutManager(this)
    }
}
