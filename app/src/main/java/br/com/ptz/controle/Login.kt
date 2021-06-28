package br.com.ptz.controle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import br.com.ptz.controle.sistema.SistemaMainActivity

// Constante declaradas
const val EXTRA_MESSAGE_EMAIL = "br.com.ptz.controle.MESSAGEEMAIL"
const val EXTRA_MESSAGE_SENHA = "br.com.ptz.controle.MESSAGESENHA"

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun aoClickMSG(emaildigitado: View) {

        val emaileditText = findViewById<EditText>(R.id.Digitadoemail)
        val senhaeditText = findViewById<EditText>(R.id.DigitadoPass)

        val MSGemail = emaileditText.text.toString()
        val MSGsenha = senhaeditText.text.toString()

        val loginintent = Intent(this, SistemaMainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE_EMAIL, MSGemail)
            putExtra(EXTRA_MESSAGE_SENHA, MSGsenha)
        }
        startActivity(loginintent)
    }
}