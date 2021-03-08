package edu.itesm.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TotalAdapter (private val totales: List<Order>)
    : RecyclerView.Adapter<TotalAdapter.TotalViewHolder>(){
    inner class TotalViewHolder(renglon: View): RecyclerView.ViewHolder(renglon){
        var fecha = renglon.findViewById<TextView>(R.id.fecha)
        var total = renglon.findViewById<TextView>(R.id.total)
    }

    // Crea el renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TotalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val renglonLayout = inflater.inflate(R.layout.renglon_layout, parent, false)
        return TotalViewHolder(renglonLayout)
    }

    // Asocia datos con los elementos del renglon
    override fun onBindViewHolder(holder: TotalViewHolder, position: Int) {
        val dato = totales[position]
        val total = dato.total
        val subtotal = dato.subtotal
        holder.fecha.text = dato.fechaAc.toString()
        holder.total.text = "Subtotal: $subtotal. Total: $total"
    }

    // Cuantos elemntos tiene la lista
    override fun getItemCount(): Int {
        return totales.size
    }
}