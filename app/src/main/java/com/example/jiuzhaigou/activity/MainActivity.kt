package com.example.jiuzhaigou.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.jiuzhaigou.R
import com.example.jiuzhaigou.fragment.HomeFragment
import com.example.jiuzhaigou.fragment.SpotFragment
import com.example.jiuzhaigou.fragment.TicketFragment
import com.example.jiuzhaigou.fragment.MineFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val titles = arrayOf("首页", "景点", "购票", "我的")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 绑定控件
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)

        // 设置适配器
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> HomeFragment()
                    1 -> SpotFragment()
                    2 -> TicketFragment()
                    3 -> MineFragment()
                    else -> HomeFragment()
                }
            }


            override fun getItemCount(): Int {
                return 4
            }
        }

        // 关联 TabLayout 和 ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}