package com.example.chapterlima

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class GamePlayActivityActivity : AppCompatActivity() {

    lateinit var guntingPlayer: ImageView
    lateinit var batuPlayer: ImageView
    lateinit var kertasPlayer: ImageView
    lateinit var guntingCom: ImageView
    lateinit var batuCom: ImageView
    lateinit var kertasCom: ImageView
    lateinit var refreshButton: ImageView
    lateinit var displayWinner: TextView
    lateinit var pemain1: String
    lateinit var com: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // variables and initial state of game
        guntingPlayer = findViewById(R.id.gunting1)
        batuPlayer = findViewById(R.id.batu1)
        kertasPlayer = findViewById(R.id.kertas1)

        guntingCom = findViewById(R.id.gunting2)
        batuCom = findViewById(R.id.batu2)
        kertasCom = findViewById(R.id.kertas2)
//        displayWinner = findViewById(R.id.dynamicText)

//        refreshButton = findViewById(R.id.refresh)


        resetDisplayCom() // clear previous display of computer's pick

        // event listener for everytime player clicks one of the suit imageview
        guntingPlayer.setOnClickListener {
            // untuk variable pemain, lebih baik kalau menggunakan const
            // misal
            // val GUNTING = "gunting
            // saat set, tinggal panggil
            // ex :  pemain1 = GUNTING
            // dengan begini, akan mengurangi typo pada saat pengecekan when di
            // method decideWinner dan displayComputersPick/displayPlayersPick
            pemain1 = "gunting"
            Log.d(MainActivity::class.java.simpleName, "Pemain 1 : " +pemain1)
            // untuk logging udah oke, mungkin buat string concat bisa di ganti jadi "Pemain 1 : $pemain1"
            displayPlayersPick(pemain1)
            com = computerPlay()
            decideWinner(pemain1, com)
        }
        batuPlayer.setOnClickListener {
            pemain1 = "batu"
            Log.d(MainActivity::class.java.simpleName, "Pemain 1 : " + pemain1)
            displayPlayersPick(pemain1)
            com = computerPlay()
            decideWinner(pemain1, com)
        }
        kertasPlayer.setOnClickListener {
            pemain1 = "kertas"
            Log.d(MainActivity::class.java.simpleName, "Pemain 1 : " + pemain1)
            displayPlayersPick(pemain1)
            com = computerPlay()
            decideWinner(pemain1, com)
        }

        refreshButton.setOnClickListener {
            resetGame()
        }

    }


    // function to decide computer's pick in a game suit randomly
    private fun computerPlay(): String {
        var selection: Array<String> = arrayOf("gunting", "batu", "kertas") // bisa di ganti jadi val, karna ga pernah berubah nilainya

        var randomIndex = Random.nextInt(0, 3) // plus point untuk ini, logic random berjalan sesuai requirement
        var randomSelection = selection[randomIndex]
        Log.d(MainActivity::class.java.simpleName, "Komputer : "+ randomSelection )
        resetDisplayCom()
        displayComputersPick(randomSelection)
        return randomSelection
    }


    // function to show computer's pick in suit
    private fun displayComputersPick(pick: String) {
        when(pick) {
            "gunting" -> guntingCom.setBackgroundColor(Color.parseColor("#6699cc"))
            "batu" -> batuCom.setBackgroundColor(Color.parseColor("#6699cc"))
            "kertas" -> kertasCom.setBackgroundColor(Color.parseColor("#6699cc"))
        }
    }

    //    function to show player's choice (click) in suit
    private fun displayPlayersPick(pick: String) {
        resetDisplayPlayer()
        when(pick) {
            "gunting" -> guntingPlayer.setBackgroundColor(Color.parseColor("#6699cc"))
            "batu" -> batuPlayer.setBackgroundColor(Color.parseColor("#6699cc"))
            "kertas" -> kertasPlayer.setBackgroundColor(Color.parseColor("#6699cc"))
        }
    }



    //    function to compare Player and Computer's pick and output the winner
    private fun decideWinner(pemain1: String, com: String): String {
        var winner = ""
        var playerWin = "Pemain 1\nMENANG"
        var comWin = "Pemain 2\nMENANG"
        var seri = "DRAW"
        when(pemain1) {
            "gunting" -> {
                when(com) {
                    "gunting" -> winner = seri
                    "batu" -> winner = comWin
                    "kertas" -> winner = playerWin
                }
            }
            "batu" -> {
                when(com) {
                    "gunting" -> winner = playerWin
                    "batu" -> winner = seri
                    "kertas" -> winner = comWin
                }
            }
            "kertas" -> {
                when(com) {
                    "gunting" -> winner = comWin
                    "batu" -> winner = playerWin
                    "kertas" -> winner = seri
                }
            }
        }
        Log.d(MainActivity::class.java.simpleName, "Winner: " + winner)
        displayWinner.setText(winner)
        displayWinner.setBackgroundColor(Color.parseColor("#6699cc"))
        return winner
    }

    // function to reset background color of computer's pick from the previous game
    private fun resetDisplayCom() {
        guntingCom.setBackgroundColor(Color.parseColor("#ffffff"))
        batuCom.setBackgroundColor(Color.parseColor("#ffffff"))
        kertasCom.setBackgroundColor(Color.parseColor("#ffffff"))
    }

    // function to reset background color of player's pick from the previous game
    private fun resetDisplayPlayer() {
        guntingPlayer.setBackgroundColor(Color.parseColor("#ffffff"))
        batuPlayer.setBackgroundColor(Color.parseColor("#ffffff"))
        kertasPlayer.setBackgroundColor(Color.parseColor("#ffffff"))
    }

    // reset game condition to initial state
    private fun resetGame() {
        resetDisplayPlayer()
        resetDisplayCom()
        displayWinner.setText("VS") // ini bisa di ganti jadi displayWinner.text = "VS"
        displayWinner.setBackgroundColor(Color.parseColor("#ffffff"))
    }
}