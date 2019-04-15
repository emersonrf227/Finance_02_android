package br.com.ilikeweb.emerson.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import br.com.ilikeweb.emerson.MainActivity
import br.com.ilikeweb.emerson.R
import br.com.ilikeweb.emerson.ui.addReceita.addReceitaActivity
import kotlinx.android.synthetic.main.fragment_lancamento.*


class LancamentoFragment : Fragment() {


    @SuppressLint("WrongViewCast")
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_lancamento, container, false)
        val button = view.findViewById(R.id.addReceita) as Button



        button.setOnClickListener { Toast.makeText(getContext(), "Tela adicionar receita", Toast.LENGTH_LONG).show()

            onBackPressedModify()

        }

        return view



    }


     fun onBackPressedModify() {
        val intent = Intent(getContext(), addReceitaActivity::class.java)
        startActivity(intent)

    }




}