package br.com.ilikeweb.emerson.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.ilikeweb.emerson.R

class PagamentoFragment : BaseFragment() {
    override fun getTitulo(): Int {
        return R.string.title_notifications
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pagamento, container, false)
    }




}

