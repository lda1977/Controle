package br.com.ptz.controle.sistema

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.ptz.controle.EXTRA_MESSAGE
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

        // Get the Intent that started this activity and extract the string
        val MSGmessage = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.ResulttextView).apply {
            text = MSGmessage
        }


    }
}