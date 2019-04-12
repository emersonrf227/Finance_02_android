package br.com.ilikeweb.emerson.ui.Cadastrar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.ilikeweb.emerson.R
import br.com.ilikeweb.emerson.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_caduser.*


class CaduserActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth




        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_caduser)

        mAuth = FirebaseAuth.getInstance()




        btCadastrar.setOnClickListener {
            mAuth.createUserWithEmailAndPassword(

                etEmail.text.toString(), //aqui associa o usuario com a senha no firebase
                etSenha.text.toString()  //aqui envia a senha para  o firebase


            ).addOnCompleteListener {
                if (it.isSuccessful) {

                    salvaNoRealtimeDatabase()

                } else {

                    Toast.makeText(this@CaduserActivity,
                        it.exception?.message,
                        Toast.LENGTH_LONG).show()

                }
            }
        }
    }

    private fun salvaNoRealtimeDatabase() {

        val user = Usuario(
            etNome.text.toString(), etEmail.text.toString())
        FirebaseDatabase.getInstance().getReference("Usuario")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(user)
            .addOnCompleteListener {
                if (it.isSuccessful) {

                    Toast.makeText(this@CaduserActivity, "Usuário Gravado com Sucesso!",
                        Toast.LENGTH_LONG).show()
                    val intent = Intent()

                    intent.putExtra("email", etEmail.text.toString())
                    intent.putExtra("senha", etSenha.text.toString())
                    setResult(Activity.RESULT_OK, intent)
                    finish()

                } else {

                    Toast.makeText(this@CaduserActivity,
                        it.exception?.message,
                        Toast.LENGTH_LONG).show()

                }


            }


    }

}

