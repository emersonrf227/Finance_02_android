package br.com.ilikeweb.emerson.Fragment
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ilikeweb.emerson.R



class MapsFragment : Fragment() {



    fun  BuscarBanco() {
        val query = "Banco 24 Horas"
        val geo = "geo:0,0?q=$query"

        exibirNoMapa(geo)

    }

    fun exibirNoMapa(geo: String) {
        val geoURI = Uri.parse(geo)
        val intent = Intent(Intent.ACTION_VIEW, geoURI)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_maps, container, false)
        BuscarBanco()
    }




}


