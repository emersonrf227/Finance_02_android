package br.com.ilikeweb.emerson.adapter

import com.google.gson.annotations.SerializedName

data class RequestReceita(

    @SerializedName("descricao") val numero: String,
    @SerializedName("valor") val nome: Long



)