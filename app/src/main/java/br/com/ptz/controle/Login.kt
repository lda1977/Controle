package br.com.ptz.controle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.EditText
import android.widget.Toast
import br.com.ptz.controle.sistema.SistemaMainActivity
import java.sql.*
import java.util.*

// Variáveis Constante declaradas
const val EXTRA_MESSAGE_EMAIL = "br.com.ptz.controle.MESSAGEEMAIL"
const val EXTRA_MESSAGE_SENHA = "br.com.ptz.controle.MESSAGESENHA"




class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        // execute the query via connection object
        //executeMySQLQuery()

        // Fazendo impressão com a biblioteca Toast
        //Toast.makeText(this, "..:: Tela LOGIN!", Toast.LENGTH_SHORT).show()



        // Crie um objeto Snackbar chamando o método estático Snackbar.make().
        // Durante a criação do Snackbar, você especifica:
        //  a mensagem exibida e a quantidade de tempo pela qual ela será exibida.
                //val mySnackbar = Snackbar.make(view, stringId, duration)

        val mySnackbar = Snackbar.make(findViewById(R.id.btnLogar),
            R.string.email_archived, Snackbar.LENGTH_LONG)

        mySnackbar.setAction(R.string.undo_string, MyUndoListener())

        // Exemplo
        /*     val mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
                                   R.string.email_archived, Snackbar.LENGTH_SHORT)
                mySnackbar.setAction(R.string.undo_string, MyUndoListener())
         */

        /*
        * view
        * A visualização à qual o Snackbar será anexado. Na verdade, o método pesquisa a hierarquia de visualizações desde a view transmitida até chegar a um CoordinatorLayout ou à visualização de conteúdo da decoração da janela. Normalmente, é mais simples transmitir apenas o CoordinatorLayout que envolve seu conteúdo.
        *
        * stringId
        * O ID do recurso da mensagem que você quer exibir. Pode ser um texto formatado ou não formatado.
        *
        * duration
        * O período de exibição da mensagem. Pode ser LENGTH_SHORT ou LENGTH_LONG.
        *
        * */


        mySnackbar.show()
    }


    class MyUndoListener : View.OnClickListener {

        override fun onClick(v: View) {
            // Code to undo the user's last action
        }
    }

    // Função responsavel pelo onClick do Button btnLogar
    fun aoClickMSG(emaildigitado: View) {

        val emaileditText = findViewById<EditText>(R.id.Digitadoemail)
        val senhaeditText = findViewById<EditText>(R.id.DigitadoPass)

        val MSGemail = emaileditText.text.toString()
        val MSGsenha = senhaeditText.text.toString()

        if(MSGemail == "teste"){
            // Chamar tela sistema e print "SUCESSO ACESSAR O SISTEMA"
            Toast.makeText(this, "Login com SUCESSO vamos para tela Sistema", Toast.LENGTH_LONG).show()

            getConnection()
            // execute the query via connection object
            //executeMySQLQuery()

            // Fazendo uso da Bibliote Intent
            val loginintent = Intent(this, SistemaMainActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE_EMAIL, MSGemail)
                putExtra(EXTRA_MESSAGE_SENHA, MSGsenha)
            }
            startActivity(loginintent)

        }else{
            // Erro de Login
            // Chamar tela Login e print "Erro E-mail"
            Toast.makeText(this, "Erro! De E-mail digitado esta errado. Tentente novamente!", Toast.LENGTH_LONG).show()
            // Fazendo uso da Bibliote Intent
            val Errorloginintent = Intent(this, Login::class.java).apply {
                putExtra(EXTRA_MESSAGE_EMAIL, MSGemail)
            }
            startActivity(Errorloginintent)
        }
    }

    /*
    *
    * */

    val connectionProps = Properties()
    internal var conn: Connection? = null
    // make a connection to MySQL Server

    fun getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver")
            val conn = DriverManager.getConnection("jdbc:mysql://192.168.1.164:3306/fornecedor", "andro", "andro")
            val statement = conn.createStatement()
            val resultSet = statement.executeQuery("SELECT * FROM fornecedor.user")

        } catch (e: SQLException) {
            // handle any errors
            e.printStackTrace()
        } catch (e: Exception) {
            // handle any errors
            e.printStackTrace()
        }
    }
}