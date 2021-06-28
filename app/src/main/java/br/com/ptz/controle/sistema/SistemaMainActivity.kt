package br.com.ptz.controle.sistema

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.ptz.controle.EXTRA_MESSAGE_EMAIL
import br.com.ptz.controle.EXTRA_MESSAGE_SENHA
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
        val MSGmessageEmail = intent.getStringExtra(EXTRA_MESSAGE_EMAIL)

        // Capture the layout's TextView and set the string as its text
        val textViewEmail = findViewById<TextView>(R.id.ResulttextView).apply {
            text = MSGmessageEmail
        }

        // Get the Intent that started this activity and extract the string
        val MSGmessageSenha = intent.getStringExtra(EXTRA_MESSAGE_SENHA)

        // Capture the layout's TextView and set the string as its text
        val textViewSenha = findViewById<TextView>(R.id.ResltSENHAtextView2).apply {
            text = MSGmessageSenha
        }

    }
}