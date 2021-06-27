package br.com.ptz.controle
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*
import android.widget.Button
import android.widget.TextView
import br.com.ptz.controle.sistema.SistemaMainActivity
import java.*
import java.lang.Exception
import java.sql.DriverManager
import android.widget.Toast.makeText as makeTextEmail


  const val EXTRA_MESSAGE_EMAIL = "br.com.ptz.controle.MESSAGEEMAIL"
  const val EXTRA_MESSAGE_SENHA = "br.com.ptz.controle.MESSAGESENHA"
  const val EXTRA_MESSAGE_NOME = "br.com.ptz.controle.MESSAGENOME"

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }
}