package com.example.kotlinmvp.models.mainfragment

import android.os.Bundle
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    companion object {
        @JvmStatic
        fun newInstance(params1: String?, params2: String?) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(params1, params1)
                }
            }
    }
}
