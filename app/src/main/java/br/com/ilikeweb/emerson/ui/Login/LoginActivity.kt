package br.com.ilikeweb.emerson.ui.Login

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ilikeweb.emerson.MainActivity
import br.com.ilikeweb.emerson.R
import br.com.ilikeweb.emerson.ui.Cadastrar.CaduserActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val CADASTRO_REQUEST_CODE = 1

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null) {

            vaiParaTelaMenu()

        }

        btLogin.setOnClickListener {


            mAuth.signInWithEmailAndPassword(
                etNome.text.toString(),
                etSenha.text.toString()

            ).addOnCompleteListener {

                if (it.isSuccessful) {

                    vaiParaTelaMenu()


                } else {

                    Toast.makeText(this@LoginActivity, it.exception?.message,
                        Toast.LENGTH_LONG).show()
                }
            }
        }




        btCadastrar.setOnClickListener {
            val telaSeguinte = Intent(this,
                CaduserActivity::class.java)
            startActivityForResult(telaSeguinte, CADASTRO_REQUEST_CODE)

        }


    }

    private fun vaiParaTelaMenu() {
        val telaSeguinte = Intent(this, MainActivity::class.java)
        startActivity(telaSeguinte)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CADASTRO_REQUEST_CODE -> {
                when (resultCode) {

                    Activity.RESULT_OK -> {

                        etSenha.setText(data?.getStringExtra("senha"))
                        etNome.setText(data?.getStringExtra("email"))

                    }
                }
            }
        }


    }


}







