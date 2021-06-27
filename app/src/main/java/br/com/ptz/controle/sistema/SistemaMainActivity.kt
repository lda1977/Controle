package br.com.ptz.controle.sistema

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.ptz.controle.R

class SistemaMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sistema_main)

        // Variaveis
        val stringU: String
        stringU = getString(R.string.USENAMEold)
        val stringP: String
        stringP = getString(R.string.PASSAWORD_old)


    }
}