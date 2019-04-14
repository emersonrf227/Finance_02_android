package br.com.ilikeweb.emerson.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import br.com.ilikeweb.emerson.R

class SettingFragment : Fragment() {







    @SuppressLint("WrongViewCast")
    @Override
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(br.com.ilikeweb.emerson.R.layout.fragment_setting, container, false)
        val button = view.findViewById(R.id.bt3) as Button

        button.setOnClickListener{ Toast.makeText(getContext(), "Tocado2", Toast.LENGTH_LONG).show()}

        return view





    }





}

