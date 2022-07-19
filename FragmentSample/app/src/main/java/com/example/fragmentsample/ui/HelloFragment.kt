package com.example.fragmentsample.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragmentsample.R

class HelloFragment : Fragment(R.layout.fragment_hello) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtHello = view.findViewById<TextView>(R.id.txtHello)
        txtHello.text = "Hello, Fragment"

        view.findViewById<Button>(R.id.buttonNext).setOnClickListener {
            val directions = HelloFragmentDirections.goToUserFragment(User())
            findNavController().navigate(directions)
        }
    }
}



