package br.com.ptz.controle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import br.com.ptz.controle.sistema.SistemaMainActivity

const val EXTRA_MESSAGE_EMAIL = "br.com.ptz.controle.sistema.MESSAGEEMAIL"
const val EXTRA_MESSAGE_SENHA = "br.com.ptz.controle.sistema.MESSAGESENHA"

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    // Implementando a função publica ClickbtnEntrada
    public fun ClickBTNLogin(view: View){
        // Variavel local que contém o Click do Button
        val BTNlogin = findViewById<Button>(R.id.button) as Button
        // Fazendo uso do Biblioteca Intent
        var LoginSistemaintent = Intent(this, SistemaMainActivity::class.java).apply{
            // Aqui devo Implementar o bloco de comando caso necessário

        }
        startActivity(LoginSistemaintent)
    }
}