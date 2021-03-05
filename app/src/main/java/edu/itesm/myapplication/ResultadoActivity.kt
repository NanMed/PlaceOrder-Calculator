package edu.itesm.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        initRecycler()
    }

    fun initRecycler(){
        totales = ArrayList<Order>()
        totalAdapter = TotalAdapter(totales)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = totalAdapter

        for (i in 0..30){
            //val fecha = LocalDateTime.now()
            val subtotal = String.format("%.2f", Random.nextDouble(until = 1000.00)).toDouble()
            val order = Order(subtotal, 0.15)
            totales.add(order)
        }
    }
}