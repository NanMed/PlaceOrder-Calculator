package edu.itesm.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_resultado.*
import java.time.LocalDateTime
import kotlin.random.Random

class ResultadoActivity : AppCompatActivity() {
    private lateinit var totalAdapter: TotalAdapter
    private lateinit var totales : ArrayList<Order>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val subtotal= intent.getDoubleExtra("total",80.0)

        Toast.makeText(this, "$ $subtotal is your total!", Toast.LENGTH_LONG ).show()

        initRecycler()
    }

    fun initRecycler(){
        totales = ArrayList<Order>()
        totalAdapter = TotalAdapter(totales)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = totalAdapter

        var arrayTips = doubleArrayOf(0.0,0.10,0.15,0.20,0.25)


        for (i in 0..30){
            val fecha = LocalDateTime.now()
            val subtotal = String.format("%.2f", Random.nextDouble(until = 1000.00)).toDouble()
            val order = Order(subtotal, arrayTips.random(), fecha)
            totales.add(order)
        }
    }
}


