package edu.itesm.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.WindowManager
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class HomeActivity : AppCompatActivity() {

    var count = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        /*Función para el countdown*/
        fun startCountDown() {
            var timer1 = object : CountDownTimer(5000, 1000) {
                override fun onFinish() {
                    countdown.text = "Go!"
                }
                override fun onTick(millisUntilFinished: Long) {

                    countdown.text = "${count--}"
                }
            }
            timer1.start()
        }

        startCountDown()

        Handler().postDelayed({
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
            finish()

        }, 5000)
    }
}
