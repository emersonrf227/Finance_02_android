package br.com.ilikeweb.emerson.ui.addReceita

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ilikeweb.emerson.R
import kotlinx.android.synthetic.main.activity_add_receita.*
import br.com.ilikeweb.emerson.MainActivity
import android.content.Intent





class addReceitaActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_receita)
        getSupportActionBar()!!.hide();

        btPreReceita.setOnClickListener {

            Toast.makeText(this, "Voltando", Toast.LENGTH_LONG).show()

            onBackPressed()

        }


    }


    override fun onBackPressed() {
        val intent = Intent(this@addReceitaActivity, MainActivity::class.java)
        startActivity(intent)
    }


}
