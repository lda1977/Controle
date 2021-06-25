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

/**
 * const val EXTRA_MESSAGE_EMAIL = "br.com.ptz.controle.MESSAGEEMAIL"
 * const val EXTRA_MESSAGE_SENHA = "br.com.ptz.controle.MESSAGESENHA"
 * const val EXTRA_MESSAGE_NOME = "br.com.ptz.controle.MESSAGENOME"
*/
class Login : AppCompatActivity() {

    var text: TextView? = null
    var errorText: TextView? = null
    var show: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Mostrando os textView e Button
        text = findViewById<View>(R.id.textView) as TextView
        errorText = findViewById<View>(R.id.textView2) as TextView
        show = findViewById<Button>(R.id.button) as Button
        show!!.setOnClickListener { Task().execute() }

        // Criando Button
        //val EntranoSistema = findViewById<Button>(R.id.btnLogar) as Button

        // Chamando onclicklistenner
        //EntranoSistema.setOnClickListener {
    /*
            // Pegando o conteudo dos campos txtInpEmail e txtInpPassword
            val tLogin = findViewById<View>(R.id.txtInpEmail) as TextView  // Que é o testo Login
            val tSenha = findViewById<View>(R.id.txtInpPassword) as TextView  // Que é o testo Senha

            // Salvando em variaveis String Separadas
            val login = tLogin.text.toString()
            val senha = tSenha.text.toString()

            // Aqui vou chamara o DBA

            // Chamando a função setOnClickListener
            show!!.setOnClickListener { Task().execute() }

            // Variáveis de Resultado do DBA
            val ResultadoLoginDBA = login
            val ResultadoSenhaDBA = senha

            // Fazendo uma comparação de variáveis
            if(ResultadoLoginDBA == tLogin.text.toString() && ResultadoSenhaDBA == tSenha.text.toString()){
                ALERTA("Login com Sucesso!")

                val message = tLogin.text.toString()
                val messageP = tSenha.text.toString()

                val intent = Intent(this, SistemaMainActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                    putExtra(EXTRA_MESSAGE, messageP)
                }
                startActivity(intent)

            }else{
                ALERTA("Erro!!! Login ou Senha incorretos, tente novamente!!!")
            }
        }


        show!!.setOnClickListener { Task().execute() }

     */
    }
/*
    // Criando a função de ALERTA
    private fun ALERTA ( ResultadoLogin: String){
        // Aqui vou verificar se foi logado com sucesso ou não
        Toast.makeText(this, ResultadoLogin, Toast.LENGTH_LONG).show()
    }
*/
    internal inner class Task : AsyncTask<Void?, Void?, Void?>() {
        var records = ""
        var error = ""
        protected override fun doInBackground(vararg params: Void?): Void? {
            try {
                Class.forName("com.mysql.jdbc.Driver")
                val connection = DriverManager.getConnection("jdbc:mysql://192.168.1.164:3306/fornecedor", "andro", "andro")
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery("SELECT Email, Senha, Nome\n" +
                        "FROM `fornecedor`.`user` ORDER BY Nome")
                while(resultSet.next()){
                    records += """${resultSet.getString(1)} ${resultSet.getString(2)} ${resultSet.getString(3)} 
"""
                }
            } catch (e: Exception) {
                error = e.toString()
            }
            return null
        }
        override fun onPostExecute(aVoid: Void?) {
            text!!.text = records
            if (error !== "") errorText!!.text = error
            super.onPostExecute(aVoid)
        }
    }
}