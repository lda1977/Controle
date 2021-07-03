package br.com.ptz.controle.sistema

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.com.ptz.controle.EXTRA_MESSAGE_EMAIL
import br.com.ptz.controle.EXTRA_MESSAGE_SENHA
import br.com.ptz.controle.R
import java.sql.DriverManager


class SistemaMainActivity : AppCompatActivity() {

    // Variáveis Local
    var textBuscar: TextView? = null
    var errorText: TextView? = null
    var show: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sistema_main)

        textBuscar = findViewById<View>(R.id.textView) as TextView
        errorText = findViewById<View>(R.id.textView2) as TextView
        show = findViewById<View>(R.id.button) as Button
        show!!.setOnClickListener { Task().execute() }

        // Fazendo impressão com a biblioteca Toast
        Toast.makeText(this, "..:: Tela Sistema!!!", Toast.LENGTH_LONG).show()
/*
        // Variaveis
        val stringU: String
        stringU = getString(R.string.USENAMEold)

        val stringP: String
        stringP = getString(R.string.PASSAWORD_old)
 */
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


    } // Fim onCreate

    // Implementando a função publica ClickbtnEntrada
    public fun ClickBTN (BTNfoiClicado: View ){
        // Variavel local que contém o Click do Button
        val BTNClick = findViewById<Button>(R.id.button) as Button
        // Fazendo uso do Biblioteca Intent
        val BTNfoiClicado = Intent(this, SistemaMainActivity::class.java).apply{
            // Aqui devo Implementar o bloco de comando caso necessário

        }
        startActivity(BTNfoiClicado)
    }

    ///////////////////////////////////////////////////////
    // Função onCreateOptionsMenu onde vai inflar o menu
    //////////////////////////////////////////////////////
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }
    ///////////////////////////////////////////////////////
    // Função onOptionsItemSelected onde verifica o item selecionado
    //////////////////////////////////////////////////////
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_sair ->{
                this.finish()
                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
                true
            }
            else -> true
        }
        return super.onOptionsItemSelected(item)
    }

    internal inner class Task : AsyncTask<Void?, Void?, Void?>() {
        var records = ""
        var error = ""
        protected override fun doInBackground(vararg params: Void?): Void? {
            try {
                Class.forName("com.mysql.jdbc.Driver")
                val connection = DriverManager.getConnection("jdbc:mysql://192.168.1.164:3306/fornecedor", "andro", "andro")
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery("SELECT * FROM fornecedor.user")
                while (resultSet.next()) {
                    records += """${resultSet.getString(1)} ${resultSet.getString(2)} ${resultSet.getString(3)} ${resultSet.getString(4)}
"""
                }
            } catch (e: Exception) {
                error = e.toString()
            }
            return null
        }

        override fun onPostExecute(aVoid: Void?) {
            textBuscar!!.text = records
            if (error !== "") errorText!!.text = error
            super.onPostExecute(aVoid)
        }
    }

}  // Fim Class SistemaMainActivity