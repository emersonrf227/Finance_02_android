package br.com.ilikeweb.emerson.ui.addDespesas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ilikeweb.emerson.MainActivity
import br.com.ilikeweb.emerson.R
import kotlinx.android.synthetic.main.activity_add_despesas.*


class addDespesasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_despesas)
        getSupportActionBar()!!.hide();

        btPreDespsesa.setOnClickListener {

            Toast.makeText(this, "Voltando", Toast.LENGTH_LONG).show()

            onBackPressed()

        }


    }


    override fun onBackPressed() {
        val intent = Intent(this@addDespesasActivity, MainActivity::class.java)
        startActivity(intent)
    }


}
