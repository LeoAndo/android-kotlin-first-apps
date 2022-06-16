package com.example.android102

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var nowQuestionNo = 0 // 今の問題が難問目かのカウント数
    private var correctNo = 0 // 正解数
    private var ans // 式の計算結果
            = 0
    private var time: Long = 0 // タイマーの開始時刻(ms)

    // Views
    private var chronometer: Chronometer? = null
    private var btnStart: Button? = null
    private var btnStop: Button? = null
    private var btnReset: Button? = null
    private var txtMessage: TextView? = null
    private var txtQuestion: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Viewのインスタンス取得
        chronometer = findViewById(R.id.chrono)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)
        btnReset = findViewById(R.id.btnReset)
        txtMessage = findViewById(R.id.txtMessage)
        txtQuestion = findViewById(R.id.txtQuestion)
    }

    /**
     * ボタンが押された時に呼ばれるイベントメソッド.
     *
     * @param view 引数にはクリックされたButtonのインスタンスが渡される
     */
    fun onClickAction(view: View) {
        if (view.id == R.id.btnStart) { // 押されたボタンがSTARTボタンの時
            // カウントアップタイマーの時間設定
            chronometer!!.base = SystemClock.elapsedRealtime() - time
            // タイマースタート
            chronometer!!.start()
            btnStop!!.isEnabled = true
            btnStart!!.isEnabled = false
            btnReset!!.isEnabled = false

            // 計算問題を開始する
            startQuestion()
        } else if (view.id == R.id.btnStop) {
            chronometer!!.stop()
            time = SystemClock.elapsedRealtime() - chronometer!!.base // startしてからの経過時間を取得する
            btnStop!!.isEnabled = false
            btnStart!!.isEnabled = true
            btnReset!!.isEnabled = true
        } else if (view.id == R.id.btnReset) {
            chronometer!!.stop()
            chronometer!!.base = SystemClock.elapsedRealtime()
            time = 0
            btnStop!!.isEnabled = false
            btnStart!!.isEnabled = true
            btnReset!!.isEnabled = false
            // カウント値と表示文字のクリア
            clear()
        }
    }

    /**
     * 1-9の数字ボタンが押された時に呼ばれるメソッド.
     *
     * @param view 引数にはクリックされたButtonのインスタンスが渡される
     */
    fun onClickAnswer(view: View) {
        val btn = view as Button
        val enterNumStr = btn.text.toString()
        val enterNum = enterNumStr.toInt()

        // 正解だった場合
        if (enterNum == ans) {
            // 正解数をカウント
            correctNo++
        }
        if (nowQuestionNo <= 9) {
            startQuestion()
        } else { //10問以降は終了
            // タイマーを止める処理
            chronometer!!.stop()
            time = SystemClock.elapsedRealtime() - chronometer!!.base
            Log.d(LOG_TAG, "時間 = $time")
            // 終了メッセージを表示する (msを秒に変換)
            txtMessage!!.text = correctNo.toString() + "問正解しました！時間は" + time / 1000 + "秒です"
            txtQuestion!!.text = ""
            btnReset!!.isEnabled = true
            btnStart!!.isEnabled = false
            btnStop!!.isEnabled = false
        }
    }

    private fun startQuestion() {
        // 現在の問題番号をカウントアップ
        nowQuestionNo++

        //1-9までのランダムな数字
        val a = (Math.random() * 9).toInt() + 1 // random()メソッドは0.0以上1.0未満の実数しか生成しない
        ans = 10 - a //計算結果の正解の答え
        // 問題の表示
        val question = nowQuestionNo.toString() + "問目: 10 - " + a + " =" // 問題の式の文字列
        txtQuestion!!.text = question
    }

    // カウント値や表示文字列のクリア
    private fun clear() {
        nowQuestionNo = 0
        correctNo = 0
        txtMessage!!.text = "それでは問題です"
        txtQuestion!!.text = ""
    }

    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName // ログのタグ名
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}