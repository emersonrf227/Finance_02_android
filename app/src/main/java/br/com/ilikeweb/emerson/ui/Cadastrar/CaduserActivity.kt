package br.com.ilikeweb.emerson.ui.Cadastrar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.ilikeweb.emerson.R
import br.com.ilikeweb.emerson.model.Usuario
import br.com.ilikeweb.emerson.ui.Login.LoginActivity
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

            var  txtEmail = etEmail.text.toString()
            var txtPassword = etSenha.text.toString()
            var txtNome = etNome.text.toString()
            var quantTxtPassword = txtPassword.length


            if (txtNome == "") {

                Toast.makeText(this, "Campo nome em branco", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            else if (txtEmail == "") {

                Toast.makeText(this, "Campo e-mail em branco", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (txtPassword == "") {

                Toast.makeText(this, "Campo password em branco", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

                else if (quantTxtPassword <= 8) {

                Toast.makeText(this, "Seu password precisa ter acima de 8 dígitos", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }



            else

            {

                createUser()

            }


        }


    }

    private fun createUser() {
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

                   // val intent2 = Intent(applicationContext, LoginActivity::class.java)
                   // startActivity(intent2)
                   // finish()

                } else {

                    Toast.makeText(this@CaduserActivity,
                        it.exception?.message,
                        Toast.LENGTH_LONG).show()

                }


            }


    }

}

