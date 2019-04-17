package br.com.ilikeweb.emerson.ui.addDespesas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ilikeweb.emerson.MainActivity
import br.com.ilikeweb.emerson.R
import br.com.ilikeweb.emerson.model.Receitas
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_despesas.*
import kotlinx.android.synthetic.main.activity_add_receita.*


class addDespesasActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_despesas)
        getSupportActionBar()!!.hide();



        auth = FirebaseAuth.getInstance()

        btPreDespsesa.setOnClickListener {

            Toast.makeText(this, "Voltando", Toast.LENGTH_LONG).show()

            onBackPressed()

        }

        btAddDespesa.setOnClickListener{



            saveDespesaFirebase()

        }


    }

    private fun saveDespesaFirebase() {

        var desc = lbDescDespesa.text.toString()
        var valor = lbValorDespesa.text.toString()
        var tipo = "D"

        var id_user = (FirebaseAuth.getInstance().currentUser!!.uid)

        val receita = Receitas(desc, valor, tipo, id_user)

        FirebaseDatabase.getInstance().getReference("Despesa")
            //.child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(receita)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this@addDespesasActivity,
                        "Despesa Cadastrada !",
                        Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this@addDespesasActivity,
                        it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }


    override fun onBackPressed() {
        val intent = Intent(this@addDespesasActivity, MainActivity::class.java)
        startActivity(intent)
    }


}
