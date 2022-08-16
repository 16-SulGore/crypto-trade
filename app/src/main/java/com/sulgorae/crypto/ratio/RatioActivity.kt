package com.sulgorae.crypto.ratio

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sulgorae.crypto.R
import com.sulgorae.crypto.common.BaseActivity
import com.sulgorae.crypto.databinding.ActivityRatioBinding

class RatioActivity : BaseActivity<ActivityRatioBinding>(R.layout.activity_ratio) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragment()

        setupTitleBar()
    }

    private fun setFragment() {
        when (intent.getStringExtra(RATIO_TYPE)) {
            RATIO_K -> { navigateRatioFragment(KRationFragment()) }
            RATIO_P -> { navigateRatioFragment(PRatioFragment()) }
        }
    }

    private fun navigateRatioFragment(fragment: Fragment) = supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_ratio, fragment)
        .commit()

    private fun setupTitleBar() = supportActionBar?.let {
        it.setIcon(R.drawable.app_bar)
        it.setDisplayUseLogoEnabled(true)
        it.setDisplayShowHomeEnabled(true)
    }

    companion object {
        const val RATIO_TYPE = "ratio_type"
        const val RATIO_K = "K"
        const val RATIO_P = "P"
    }
}
