package jp.ac.jec.cm0199.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter = Counter(0)
        findViewById<Button>(R.id.buttonCountUp).setOnClickListener {
            counter.countUp()
            showToast(counter.value.toString())
        }
        findViewById<Button>(R.id.buttonNextScreen).setOnClickListener {
            showToast("start SubActivity")
            SubActivity.start(this)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}