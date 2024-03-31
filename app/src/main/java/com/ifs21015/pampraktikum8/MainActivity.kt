package com.ifs21015.pampraktikum8

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.ifs21015.pampraktikum8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupAction()
    }
    private fun setupView() {
        binding.navView.setCheckedItem(R.id.nav_home)
        binding.inAppBar.toolbar.overflowIcon =
            ContextCompat.getDrawable(this, R.drawable.ic_more_vert)
        loadFragment(FLAG_FRAGMENT_HOME)
    }
    private fun setupAction() {
        binding.inAppBar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_favorite -> {
                    val text = "Berhasil Menambahkan ke Favorit"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(this, text, duration) // in Activity
                    toast.show()
                    true
                }
                R.id.action_stopfollow -> {
                    val text = "Berhasil Berhenti Mengikuti"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(this, text, duration) // in Activity
                    toast.show()
                    true
                }
                R.id.action_reason -> {
                    val text = "Kenapa anda lihat ini?"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(this, text, duration) // in Activity
                    toast.show()
                    true
                }
                R.id.action_hide -> {
                    val text = "Berhasil Menyembuyikan"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(this, text, duration) // in Activity
                    toast.show()
                    true
                }
                R.id.action_about -> {
                    val text = "Nanti dikasih tau tentang akun ini"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(this, text, duration) // in Activity
                    toast.show()
                    true
                }
                R.id.action_report -> {
                    val text = "Berhasil Melaporkan!"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(this, text, duration) // in Activity
                    toast.show()
                    true
                }
                else -> true
            }
        }
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    loadFragment(FLAG_FRAGMENT_HOME)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(FLAG_FRAGMENT_PROFILE, "Memilih menu Profile!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_cari -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD, "Memilih menu Cari!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_reels -> {
                    loadFragment(FLAG_FRAGMENT_REELS, "Memilih menu Reels!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_tambah -> {
                    loadFragment(FLAG_FRAGMENT_ADD, "Memilih menu Tambah!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> true
            }
        }
        binding.inAppBar.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(FLAG_FRAGMENT_HOME)
                    true
                }
                R.id.navigation_cari -> {
                    loadFragment(FLAG_FRAGMENT_DASHBOARD)
                    true
                }
                R.id.navigation_tambah -> {
                    loadFragment(FLAG_FRAGMENT_ADD)
                    true
                }
                R.id.navigation_reels -> {
                    loadFragment(FLAG_FRAGMENT_REELS)
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(FLAG_FRAGMENT_PROFILE)
                    true
                }
                else -> true
            }
        }
    }
    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id
        when (flag) {
            FLAG_FRAGMENT_HOME -> {
                binding.inAppBar.bottomNavView
                    .menu
                    .findItem(R.id.navigation_home)
                    .setChecked(true)
                val homeFragment = HomeFragment()
                val bundle = Bundle().apply {
                    this.putString(
                        HomeFragment.EXTRA_MESSAGE,
                        message ?: "Belum ada menu yang dipilih!"
                    )
                }
                homeFragment.arguments = bundle
                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        homeFragment,
                        HomeFragment::class.java.simpleName
                    )
                    .commit()
            }
            FLAG_FRAGMENT_DASHBOARD -> {
                val dashboardFragment = DashboardFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(DashboardFragment::class.java.simpleName)
                if (fragment !is DashboardFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            dashboardFragment,
                            DashboardFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_NOTIFICATION -> {
                val notificationFragment = NotificationFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(NotificationFragment::class.java.simpleName)
                if (fragment !is NotificationFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            notificationFragment,
                            NotificationFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_ADD -> {
                val addFragment = AddFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(AddFragment::class.java.simpleName)
                if (fragment !is AddFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            addFragment,
                            AddFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_REELS -> {
                val reelsFragment = ReelsFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(ReelsFragment::class.java.simpleName)
                if (fragment !is ReelsFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            reelsFragment,
                            ReelsFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
            FLAG_FRAGMENT_PROFILE -> {
                val profileFragment = ProfileFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(ProfileFragment::class.java.simpleName)
                if (fragment !is ProfileFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            profileFragment,
                            ProfileFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
        }
    }
    companion object {
        const val FLAG_FRAGMENT_HOME = "fragment_home"
        const val FLAG_FRAGMENT_DASHBOARD = "fragment_dashboard"
        const val FLAG_FRAGMENT_NOTIFICATION = "fragment_notification"
        const val FLAG_FRAGMENT_ADD = "fragment_add"
        const val FLAG_FRAGMENT_PROFILE = "fragment_profile"
        const val FLAG_FRAGMENT_REELS = "fragment_reels"
    }
}