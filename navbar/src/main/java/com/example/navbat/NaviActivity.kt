package com.example.navbat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.navbat.databinding.ActivityNaviBinding

private const val TAG_RECOMMEND = "recommend_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_SETTING = "setting_fragment"

class NaviActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // workspace_setting ImageView에 클릭 이벤트 핸들러 추가
        binding.toolbarInclude.workspaceSetting.setOnClickListener {
            // 클릭 시 AbcFragment로 전환
            val fragment = WorkSettingFragment()
            supportFragmentManager.beginTransaction()
                .replace(binding.mainFrameLayout.id, fragment)
                .addToBackStack(null) // 뒤로가기 버튼을 눌렀을 때 이전 Fragment로 돌아가기 위해 스택에 추가
                .commit()
        }

        // 초기 프래그먼트 설정
        val initialFragment = HomeFragment()
        setFragment(TAG_HOME, initialFragment)

        // 바텀 네비게이션 아이템 선택 리스너 설정
        binding.navigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.recommendFragment -> setFragment(TAG_RECOMMEND, RecommendFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.settingFragment -> setFragment(TAG_SETTING, SettingFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val fragTransaction = supportFragmentManager.beginTransaction()

        // 프래그먼트 추가
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            fragTransaction.add(binding.mainFrameLayout.id, fragment, tag)
        }

        // 기존의 다른 프래그먼트 숨기기
        val reco = supportFragmentManager.findFragmentByTag(TAG_RECOMMEND)
        val home = supportFragmentManager.findFragmentByTag(TAG_HOME)
        val setting = supportFragmentManager.findFragmentByTag(TAG_SETTING)

        if (reco != null) {
            fragTransaction.hide(reco)
        }

        if (home != null) {
            fragTransaction.hide(home)
        }

        if (setting != null) {
            fragTransaction.hide(setting)
        }

        // 보여줄 프래그먼트만 보이게 하기
        when (tag) {
            TAG_RECOMMEND -> reco?.let { fragTransaction.show(it) }
            TAG_HOME -> home?.let { fragTransaction.show(it) }
            TAG_SETTING -> setting?.let { fragTransaction.show(it) }
        }

        // 트랜잭션 커밋
        fragTransaction.commitAllowingStateLoss()
    }
}
