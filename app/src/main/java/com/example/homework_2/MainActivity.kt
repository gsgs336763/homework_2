package com.example.homework_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var edname: EditText? = null
        var tvtext: TextView? = null
        var tvname: TextView? = null
        var tvwinner: TextView? = null
        var tvmmora: TextView? = null
        var tvcmora: TextView? = null
        var btnscissor: RadioButton? = null
        var btnstone: RadioButton? = null
        var btnpaper: RadioButton? = null
        var btnmora: Button? = null
        edname = findViewById(R.id.ed_name)
        tvtext = findViewById(R.id.tv_text)
        tvname = findViewById(R.id.tv_name)
        tvwinner = findViewById(R.id.tv_winner)
        tvmmora = findViewById(R.id.tv_mmora)
        tvcmora = findViewById(R.id.tv_cmora)
        btnscissor = findViewById(R.id.btn_scissor)
        btnstone = findViewById(R.id.btn_stone)
        btnpaper = findViewById(R.id.btn_paper)
        btnmora = findViewById(R.id.btn_mora)
        btnmora.setOnClickListener(View.OnClickListener {
            if (edname.length() < 1) tvtext.setText("請輸入玩家姓名") else {
                tvname.setText(String.format("名字\n%s", edname.getText().toString()))
                if (btnscissor.isChecked()) tvmmora.setText("我方出拳\n剪刀") else if (btnstone.isChecked()) tvmmora.setText(
                    "我方出拳\n石頭"
                ) else tvmmora.setText("我方出拳\n布")
                val computer = (Math.random() * 3).toInt()
                if (computer == 0) tvcmora.setText("電腦出拳\n剪刀") else if (computer == 1) tvcmora.setText(
                    "電腦出拳\n石頭"
                ) else tvcmora.setText("我方出拳\n布")
                if (btnscissor.isChecked() && computer == 2 ||
                    btnstone.isChecked() && computer == 0 ||
                    btnpaper.isChecked() && computer == 1
                ) {
                    tvwinner.setText(
                        """
                            勝利者
                            ${edname.getText()}
                            """.trimIndent()
                    )
                    tvtext.setText("恭喜你獲勝了! ! !")
                } else if (btnscissor.isChecked() && computer == 1 ||
                    btnstone.isChecked() && computer == 2 ||
                    btnpaper.isChecked() && computer == 0
                ) {
                    tvwinner.setText("勝利者\n電腦")
                    tvtext.setText("可惜，電腦獲勝了!")
                } else {
                    tvwinner.setText("勝利者\n平手")
                    tvtext.setText("平局，請在試一次!")
                }
            }
        })
    }
}