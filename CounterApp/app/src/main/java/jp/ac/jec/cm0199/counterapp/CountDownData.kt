package jp.ac.jec.cm0199.counterapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.util.concurrent.TimeUnit

class CountDownData(
    @JvmField val millisInFuture: Long = TimeUnit.SECONDS.toMillis(10),
    @JvmField val countDownInterval: Long = TimeUnit.SECONDS.toMillis(1)
) {
    @JvmOverloads
    fun showMessage(context: Context, message: String = "default message") {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun doSomeThingStaticMethod() {
            Log.d("CountDownData", "doSomeThingStaticMethod: IN")
        }
    }
}