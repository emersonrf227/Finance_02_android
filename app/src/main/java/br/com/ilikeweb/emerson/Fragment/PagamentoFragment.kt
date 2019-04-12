package br.com.ilikeweb.emerson.Fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ToggleButton
import br.com.ilikeweb.emerson.R
import kotlinx.android.synthetic.main.fragment_pagamento.*


class PagamentoFragment : BaseFragment() {




    override fun getTitulo(): Int {
        return R.string.title_notifications


    }

     private fun chamaToast(){



         Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_LONG).show();

     }





    @SuppressLint("WrongViewCast")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_pagamento, container, false)

        val BtAction = view.findViewById(R.id.btAction) as ToggleButton

        BtAction.setOnClickListener {

            Toast.makeText(getActivity(), "Teste de Botão", Toast.LENGTH_LONG).show();

        }

        return inflater.inflate(R.layout.fragment_pagamento, container, false)


    }





}

