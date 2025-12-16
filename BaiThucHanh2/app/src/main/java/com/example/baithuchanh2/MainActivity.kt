package com.example.baithuchanh2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtSoLuong: EditText
    private lateinit var btnTao: Button
    private lateinit var txtThongBao: TextView
    private lateinit var layoutDanhSach: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtSoLuong = findViewById(R.id.edtSoLuong)
        btnTao = findViewById(R.id.btnTao)
        txtThongBao = findViewById(R.id.txtThongBao)
        layoutDanhSach = findViewById(R.id.layoutDanhSach)

        btnTao.setOnClickListener {
            taoDanhSach()
        }
    }

    private fun taoDanhSach() {
        layoutDanhSach.removeAllViews()
        txtThongBao.text = ""

        val input = edtSoLuong.text.toString().trim()

        if (input.isEmpty()) {
            txtThongBao.text = "Dữ liệu bạn nhập không hợp lệ"
            return
        }

        try {
            val n = input.toInt()

            if (n <= 0) {
                txtThongBao.text = "Dữ liệu bạn nhập không hợp lệ"
                return
            }

            for (i in 1..n) {
                val tv = TextView(this)
                tv.text = i.toString()
                tv.textSize = 16f
                tv.setTextColor(resources.getColor(android.R.color.white))
                tv.setPadding(0, 24, 0, 24)
                tv.textAlignment = View.TEXT_ALIGNMENT_CENTER
                tv.setBackgroundColor(
                    resources.getColor(android.R.color.holo_red_dark)
                )

                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 16, 0, 0)
                tv.layoutParams = params

                layoutDanhSach.addView(tv)
            }

        } catch (e: NumberFormatException) {
            txtThongBao.text = "Dữ liệu bạn nhập không hợp lệ"
        }
    }
}
