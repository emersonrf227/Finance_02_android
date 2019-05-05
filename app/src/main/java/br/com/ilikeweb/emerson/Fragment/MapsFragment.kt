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
import com.google.android.gms.maps.SupportMapFragment


class MapsFragment : Fragment() {





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        super.onCreate(savedInstanceState)


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_maps, container, false)

    }




}


