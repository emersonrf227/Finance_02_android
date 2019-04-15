package br.com.ilikeweb.emerson.ui.addDespesas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ilikeweb.emerson.MainActivity
import br.com.ilikeweb.emerson.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_add_despesas.*


class addDespesasActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_despesas)
        getSupportActionBar()!!.hide();

        mAuth = FirebaseAuth.getInstance()

        btPreDespsesa.setOnClickListener {

            Toast.makeText(this, "Voltando", Toast.LENGTH_LONG).show()

            onBackPressed()

        }



        btAddDespesa.setOnClickListener {

           if (lbDespesas.text.toString() == ""){

               Toast.makeText(this, "Prencha o campo com um valor", Toast.LENGTH_LONG).show()
               return@setOnClickListener
           }



        }


    }


    override fun onBackPressed() {
        val intent = Intent(this@addDespesasActivity, MainActivity::class.java)
        startActivity(intent)
    }


}
