package com.example.android102;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_bak extends AppCompatActivity {

    private int nowQuestionNo = 0; // 今の問題が難問目かのカウント数
    private int correctNo = 0; // 正解数
    private int ans; // 式の計算結果
    private long time = 0; // タイマーの開始時刻(ms)
    private static final String LOG_TAG = MainActivity_bak.class.getSimpleName(); // ログのタグ名
    // Views
    private Chronometer chronometer;
    private Button btnStart;
    private Button btnStop;
    private Button btnReset;
    private TextView txtMessage;
    private TextView txtQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Viewのインスタンス取得
        chronometer = findViewById(R.id.chrono);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnReset = findViewById(R.id.btnReset);
        txtMessage = findViewById(R.id.txtMessage);
        txtQuestion = findViewById(R.id.txtQuestion);
    }

    /**
     * ボタンが押された時に呼ばれるイベントメソッド.
     *
     * @param view 引数にはクリックされたButtonのインスタンスが渡される
     */
    public void onClickAction(View view) {
        if (view.getId() == R.id.btnStart) { // 押されたボタンがSTARTボタンの時
            // カウントアップタイマーの時間設定
            chronometer.setBase(SystemClock.elapsedRealtime() - time);
            // タイマースタート
            chronometer.start();
            btnStop.setEnabled(true);
            btnStart.setEnabled(false);
            btnReset.setEnabled(false);

            // 計算問題を開始する
            startQuestion();
        } else if (view.getId() == R.id.btnStop) {
            chronometer.stop();
            time = SystemClock.elapsedRealtime() - chronometer.getBase(); // startしてからの経過時間を取得する

            btnStop.setEnabled(false);
            btnStart.setEnabled(true);
            btnReset.setEnabled(true);
        } else if (view.getId() == R.id.btnReset) {
            chronometer.stop();
            chronometer.setBase(SystemClock.elapsedRealtime());
            time = 0;
            btnStop.setEnabled(false);
            btnStart.setEnabled(true);
            btnReset.setEnabled(false);
            // カウント値と表示文字のクリア
            clear();
        }
    }

    /**
     * 1-9の数字ボタンが押された時に呼ばれるメソッド.
     *
     * @param view 引数にはクリックされたButtonのインスタンスが渡される
     */
    public void onClickAnswer(View view) {
        Button btn = (Button) view;
        String enterNumStr = btn.getText().toString();
        int enterNum = Integer.parseInt(enterNumStr);

        // 正解だった場合
        if (enterNum == ans) {
            // 正解数をカウント
            correctNo++;
        }

        if (nowQuestionNo <= 9) {
            startQuestion();
        } else { //10問以降は終了
            // タイマーを止める処理
            chronometer.stop();
            time = SystemClock.elapsedRealtime() - chronometer.getBase();
            Log.d(LOG_TAG, "時間 = " + time);
            // 終了メッセージを表示する (msを秒に変換)
            txtMessage.setText(correctNo + "問正解しました！時間は" + time / 1000 + "秒です");
            txtQuestion.setText("");

            btnReset.setEnabled(true);
            btnStart.setEnabled(false);
            btnStop.setEnabled(false);
        }
    }

    private void startQuestion() {
        // 現在の問題番号をカウントアップ
        nowQuestionNo++;

        //1-9までのランダムな数字
        int a = (int) (Math.random() * 9) + 1; // random()メソッドは0.0以上1.0未満の実数しか生成しない
        ans = 10 - a; //計算結果の正解の答え
        // 問題の表示
        String question = nowQuestionNo + "問目: 10 - " + a + " ="; // 問題の式の文字列
        txtQuestion.setText(question);
    }

    // カウント値や表示文字列のクリア
    private void clear() {
        nowQuestionNo = 0;
        correctNo = 0;
        txtMessage.setText("それでは問題です");
        txtQuestion.setText("");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}