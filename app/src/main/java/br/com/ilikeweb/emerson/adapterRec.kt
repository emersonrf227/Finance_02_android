package br.com.ilikeweb.emerson

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.ilikeweb.emerson.model.Receitas
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_adapter_rec.*



class adapterRec(private val dataList: ArrayList<Receitas>,private val context: Context) :
    RecyclerView.Adapter<adapterRec.AtividadeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtividadeViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_lancamento, parent, false)
        return AtividadeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AtividadeViewHolder, position: Int) {
        holder.txtLbdesc!!.text = dataList[position].descricao!!
        holder.txtLbValor!!.setText(dataList[position].valor!!.toString())


    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class AtividadeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtLbdesc: TextView
        var txtLbValor: TextView

        init {
            txtLbdesc = itemView.findViewById(R.id.lbDesc)
            txtLbValor = itemView.findViewById(R.id.lbValor)
        }


    }
}

















