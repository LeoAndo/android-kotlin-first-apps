package jp.ac.jec.cm0199.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter = Counter(0)
        val txtCount = findViewById<TextView>(R.id.txtCount)

        val buttonCountUp = findViewById<Button>(R.id.buttonCountUp)
        buttonCountUp.setOnClickListener {
            // ここにボタンクリックした時の処理を記述する！
            counter.countUp()
            txtCount.text = counter.value.toString()

            if(counter.value > 10) {
                SubActivity.startActivity(this)
            }
        }
    }
}


