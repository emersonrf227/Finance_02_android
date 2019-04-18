package br.com.ilikeweb.emerson.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

import br.com.ilikeweb.emerson.MainActivity
import android.content.Intent
import br.com.ilikeweb.emerson.ui.Cadastrar.CaduserActivity
import br.com.ilikeweb.emerson.ui.Login.LoginActivity
import br.com.ilikeweb.emerson.ui.addDespesas.addDespesasActivity
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment : Fragment() {





    private lateinit var auth: FirebaseAuth



    @SuppressLint("WrongViewCast")
    @Override
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(br.com.ilikeweb.emerson.R.layout.fragment_setting, container, false)
        val button = view.findViewById(br.com.ilikeweb.emerson.R.id.btlogout) as Button

        button.setOnClickListener{

            FirebaseAuth.getInstance().signOut();
            SingOut()






            //Toast.makeText(getContext(), "Tocado2", Toast.LENGTH_LONG).show()

        }

        return view





    }

    fun SingOut() {
        val intent = Intent(getContext(), LoginActivity::class.java)
        startActivity(intent)

    }





}

