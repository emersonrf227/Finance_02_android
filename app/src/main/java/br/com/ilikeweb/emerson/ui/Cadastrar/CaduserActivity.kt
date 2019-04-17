package br.com.ilikeweb.emerson.ui.Cadastrar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import br.com.ilikeweb.emerson.R
import br.com.ilikeweb.emerson.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_caduser.*


class CaduserActivity : AppCompatActivity() {



        private lateinit var auth: FirebaseAuth

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_caduser)

            auth = FirebaseAuth.getInstance()

            btCadastrar.setOnClickListener {
                Toast.makeText(this, "Aguarde", Toast.LENGTH_LONG).show()

               // loading.visibility = View.VISIBLE

                auth.createUserWithEmailAndPassword(etEmail.text.toString(), etSenha.text.toString())

                    .addOnCompleteListener(this) { task ->

                        Toast.makeText(this, "Aguarde", Toast.LENGTH_LONG).show()

                       // loading.visibility = View.GONE

                        if (task.isSuccessful) {

                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG" , "createUserWithEmail:success")
                            saveFirestoneDatabase()

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(this@CaduserActivity,
                                task.exception?.message, Toast.LENGTH_LONG).show()
                        }


                    }

            }
        }

        private fun saveFirestoneDatabase() {

            val user = Usuario(etNome.text.toString(), etEmail.text.toString())

            FirebaseDatabase.getInstance().getReference("Usuario")
                .child(FirebaseAuth.getInstance().currentUser!!.uid)
                .setValue(user)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this@CaduserActivity,
                            "Usuário cadastrado com sucesso!",
                            Toast.LENGTH_LONG).show()

                        val intent = Intent()
                        intent.putExtra("email", etEmail.text.toString())
                        intent.putExtra("password", etSenha.text.toString())
                        setResult(Activity.RESULT_OK, intent)
                        finish()

                    } else {
                        Toast.makeText(this@CaduserActivity,
                            it.exception?.message, Toast.LENGTH_LONG).show()
                    }
                }
        }


    }
