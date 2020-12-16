package com.example.calculadora_danielamello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide() /*o comando irá ocultar a toolbar do telefone durante a execução do app*/

        fun IniciarCalculo(string:String, limpar_dados: Boolean){
            /*nessa função serão passados dois parâmetros a String e o Boleano*/

            if(txtresultado.text.isNotEmpty()){ /*se o resultado não estiver vazio, faça*/
                calculo.text= "" /*resultado recebe vazio*/
            }

            if (limpar_dados){ /*limpar_dados sendo boleano retorna verdadeiro ou falso. Neste caso, se verdadeiro faça:*/
                txtresultado.text= "" /*resultado recebe vazio*/
                calculo.append(string) /*o cálculo irá receber uma string (append=acrescentar)*/
            }
            else {
                calculo.append(txtresultado.text) /*calculo recebe resultado*/
                calculo.append(string) /*calculo recebe string*/
                txtresultado.text = "" /*resultado recebe vazio*/
            }
        }

        numero_zero.setOnClickListener {IniciarCalculo("0", true)} /*o comando possibilita o clique dos botões e a definição dos valores numéricos*/
        numero_um.setOnClickListener {IniciarCalculo("1", true)}
        numero_dois.setOnClickListener {IniciarCalculo("2", true)}
        numero_tres.setOnClickListener {IniciarCalculo("3", true)}
        numero_quatro.setOnClickListener {IniciarCalculo("4", true)}
        numero_cinco.setOnClickListener {IniciarCalculo("5", true)}
        numero_seis.setOnClickListener {IniciarCalculo("6", true)}
        numero_sete.setOnClickListener {IniciarCalculo("7", true)}
        numero_oito.setOnClickListener {IniciarCalculo("8", true)}
        numero_nove.setOnClickListener {IniciarCalculo("9", true)}
        numero_ponto.setOnClickListener {IniciarCalculo(".", true)}

        //Operadores
        soma.setOnClickListener { IniciarCalculo("+", false) }
        subtracao.setOnClickListener { IniciarCalculo("-", false) }
        multiplicacao.setOnClickListener { IniciarCalculo("*", false) }
        divisao.setOnClickListener { IniciarCalculo("/", false) }

        limpar.setOnClickListener {
            calculo.text= ""
            txtresultado.text= ""
        }

        numero_apagar.setOnClickListener {
            val string = calculo.text.toString()

            if (string.isNotBlank()) {
                calculo.text = string.substring(0,string.length-1) /*retira um espaço da string sempre que clicado*/
            }
            txtresultado.text = ""
        }
    }
}