package edu.itesm.myapplication

import java.time.LocalDateTime
import java.util.*
import kotlin.math.round

data class Order(var subtotal: Double, var tipPercentage: Double, var fecha: LocalDateTime){
    var smallOderFee: Double = round((subtotal * 0.02) * 100) / 100
    var serviceFee:  Double = round((subtotal * 0.05) * 100) / 100
    var deliveryFee : Double = round((subtotal * 0.10) * 100) / 100
    var tip : Double = round((tipPercentage * subtotal) * 100) / 100
    var total : Double = round((subtotal + smallOderFee + serviceFee + deliveryFee + tip) * 100) / 100
    var fechaAc: LocalDateTime = fecha


    override fun toString(): String = "De $subtotal, el total es: $total"
}