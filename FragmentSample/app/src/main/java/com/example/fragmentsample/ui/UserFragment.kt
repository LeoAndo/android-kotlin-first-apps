package com.example.fragmentsample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.fragmentsample.R

class UserFragment : Fragment(R.layout.fragment_user) {
    private val safeArgs by navArgs<UserFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtInfo = view.findViewById<TextView>(R.id.txtInfo)
        txtInfo.text = safeArgs.user.name + " : " + safeArgs.user.age
    }
}

