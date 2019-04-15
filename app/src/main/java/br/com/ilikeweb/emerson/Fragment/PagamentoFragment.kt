package br.com.ilikeweb.emerson.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import br.com.ilikeweb.emerson.R
import br.com.ilikeweb.emerson.ui.addDespesas.addDespesasActivity




class PagamentoFragment : Fragment() {


    @SuppressLint("WrongViewCast")
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_pagamento, container, false)
        val button = view.findViewById(R.id.addDespesas) as Button





        button.setOnClickListener {
            Toast.makeText(getContext(), "Tela adicionar despesas", Toast.LENGTH_LONG).show()
            onBackPressedModify()

        }

        return view


    }


    fun onBackPressedModify() {
        val intent = Intent(getContext(), addDespesasActivity::class.java)
        startActivity(intent)

    }

}


