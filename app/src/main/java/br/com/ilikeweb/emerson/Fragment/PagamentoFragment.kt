package br.com.ilikeweb.emerson.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


import br.com.ilikeweb.emerson.R
import kotlinx.android.synthetic.main.fragment_pagamento.*


class PagamentoFragment : BaseFragment() {





    override fun getTitulo(): Int {
        return R.string.title_notifications


    }

     private fun chamaToast(){



         Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_LONG).show();

     }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_pagamento, container, false)


    }





}

