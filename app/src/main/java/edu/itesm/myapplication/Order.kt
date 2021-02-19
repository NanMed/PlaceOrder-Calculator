package edu.itesm.myapplication

data class Order(var subtotal: Int, var tipPercentage: Double){
    var smallOderFee: Double = subtotal * 0.02
    var serviceFee:  Double = subtotal * 0.05
    var deliveryFee : Double = subtotal * 0.10
    var tip : Double = tipPercentage * subtotal
    var total : Double = subtotal + smallOderFee + serviceFee + deliveryFee + tip

    override fun toString(): String = "De $subtotal, el total es: $total"
}