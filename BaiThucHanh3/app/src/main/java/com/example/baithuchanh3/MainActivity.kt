package com.example.baithuchanh3

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtA: EditText
    private lateinit var edtB: EditText
    private lateinit var txtKetQua: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtA = findViewById(R.id.edtSoA)
        edtB = findViewById(R.id.edtSoB)
        txtKetQua = findViewById(R.id.txtKetQua)

        findViewById<Button>(R.id.btnCong).setOnClickListener { tinh("+") }
        findViewById<Button>(R.id.btnTru).setOnClickListener { tinh("-") }
        findViewById<Button>(R.id.btnNhan).setOnClickListener { tinh("*") }
        findViewById<Button>(R.id.btnChia).setOnClickListener { tinh("/") }
    }

    private fun tinh(phepToan: String) {
        val aStr = edtA.text.toString()
        val bStr = edtB.text.toString()

        if (aStr.isEmpty() || bStr.isEmpty()) {
            txtKetQua.text = "Kết quả: Dữ liệu không hợp lệ"
            return
        }

        try {
            val a = aStr.toDouble()
            val b = bStr.toDouble()

            val kq = when (phepToan) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> {
                    if (b == 0.0) {
                        txtKetQua.text = "Kết quả: Không chia cho 0"
                        return
                    }
                    a / b
                }
                else -> 0.0
            }

            txtKetQua.text = "Kết quả: $kq"

        } catch (e: NumberFormatException) {
            txtKetQua.text = "Kết quả: Dữ liệu không hợp lệ"
        }
    }
}
