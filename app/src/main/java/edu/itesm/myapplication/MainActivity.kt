package edu.itesm.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    val orders = mutableListOf<Order>()
    var tip : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularTotal(tipSelected: Double){
        val order = Order(subtotal.text.toString().toDouble(), tipSelected)
        setOrderValues(order)
        Log.i("edu.itesm.myapplication", order.toString())
        orders.add(order)
        Log.i("edu.itesm.myapplication", orders.toString())
        Log.i("edu.itesm.myapplication", orders.sumBy{ it.total.roundToInt() }.toString())
    }

    fun butonTip(view: View){
        if (view.getId() == R.id.button0) {
            Log.i("edu.itesm.myapplication", "0" )
            tip = 0.0
        } else if (view.getId() == R.id.button10) {
            Log.i("edu.itesm.myapplication", "10" )
            tip = 0.10
        } else if (view.getId() == R.id.button15) {
            Log.i("edu.itesm.myapplication", "15" )
            tip = 0.15
        } else if (view.getId() == R.id.button20) {
            Log.i("edu.itesm.myapplication", "20" )
            tip = 0.20
        } else if (view.getId() == R.id.button25) {
            Log.i("edu.itesm.myapplication", "25" )
            tip = 0.25
        }else{
            Log.i("edu.itesm.myapplication", "0" )
            tip = 0.0

        }

        calcularTotal(tip)
        placeOrder()

    }

    fun setOrderValues(order: Order){
        totalShow.text=" $ ${order.total}"  // Esta muestra el total en la app
        sOFNum.text=" $ ${order.smallOderFee}" // imprime los cargos
        dFNum.text=" $ ${order.deliveryFee}"
        sFNum.text="$ ${order.serviceFee}"
    }

    fun placeOrder(){
        placeOrderButton.setOnClickListener {
            subtotal.setText("")
            sOFNum.text = "$0"
            sFNum.text="$0"
            dFNum.text="$0"
            totalShow.text="$0"
            val intento = Intent(this, ResultadoActivity::class.java)
            //intento.putExtra("tip", tip)
            //intento.putExtra("subtotal", subtotal.text.toString().toDouble())
            startActivity(intento)
        }
    }

}