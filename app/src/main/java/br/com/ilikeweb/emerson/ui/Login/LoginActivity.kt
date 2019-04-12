package br.com.ilikeweb.emerson.ui.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ilikeweb.emerson.R
import br.com.ilikeweb.emerson.ui.Cadastrar.CaduserActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_pagamento.*

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btCadastrar.setOnClickListener {
            val intent = Intent(this, CaduserActivity::class.java)
            startActivity(intent)
        }








    }








}
