package br.com.ptz.controle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import br.com.ptz.controle.sistema.SistemaMainActivity

const val EXTRA_MESSAGE = "br.com.ptz.controle.MESSAGE"

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun aoClickMSG(emaildigitado: View) {

        val editText = findViewById<EditText>(R.id.Digitadoemail)
        val MSGmessage = editText.text.toString()
        val intent = Intent(this, SistemaMainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, MSGmessage)
        }
        startActivity(intent)

    }
}