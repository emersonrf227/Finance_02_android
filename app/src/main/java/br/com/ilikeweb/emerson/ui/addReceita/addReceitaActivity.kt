package br.com.ilikeweb.emerson.ui.addReceita

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ilikeweb.emerson.R
import kotlinx.android.synthetic.main.activity_add_receita.*
import br.com.ilikeweb.emerson.MainActivity
import android.content.Intent
import br.com.ilikeweb.emerson.model.Receitas
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase



class addReceitaActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_receita)
        getSupportActionBar()!!.hide();



        auth = FirebaseAuth.getInstance()

        btPreReceita.setOnClickListener {

            Toast.makeText(this, "Voltando", Toast.LENGTH_LONG).show()

            onBackPressed()

        }

        btAddReceita.setOnClickListener{



            saveReceitasFirebase()

        }


    }

    private fun saveReceitasFirebase() {

        var desc = lbDescReceita.text.toString()
        var valor = lbValReceita.text.toString().toLong()
        var tipo = "R"

        var id_user = (FirebaseAuth.getInstance().currentUser!!.uid)

        val receita = Receitas(desc, valor, tipo, id_user)

            FirebaseDatabase.getInstance().getReference("Lancamentos").push()
            .setValue(receita)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this@addReceitaActivity,
                        "Receita Cadastrada !",
                        Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this@addReceitaActivity,
                        it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }


    override fun onBackPressed() {
        val intent = Intent(this@addReceitaActivity, MainActivity::class.java)
        startActivity(intent)
    }


}
