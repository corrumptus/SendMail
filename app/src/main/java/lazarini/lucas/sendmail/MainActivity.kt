package lazarini.lucas.sendmail

import android.content.Intent
import android.content.Intent.ACTION_CHOOSER
import android.content.Intent.ACTION_SENDTO
import android.content.Intent.EXTRA_BCC
import android.content.Intent.EXTRA_CC
import android.content.Intent.EXTRA_EMAIL
import android.content.Intent.EXTRA_INTENT
import android.content.Intent.EXTRA_SUBJECT
import android.content.Intent.EXTRA_TEXT
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lazarini.lucas.sendmail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        activityMainBinding.clearBt.setOnClickListener {
            activityMainBinding.apply {
                toEt.setText("")
                ccEt.setText("")
                bccEt.setText("")
                subjectEt.setText("")
                messageEt.setText("")
            }
        }

        activityMainBinding.sendBt.setOnClickListener {
            activityMainBinding.apply {
                Intent(ACTION_SENDTO).apply {
                    putExtra(EXTRA_EMAIL, arrayOf(toEt.text.toString()))
                    putExtra(EXTRA_CC, arrayOf(ccEt.text.toString()))
                    putExtra(EXTRA_BCC, arrayOf(bccEt.text.toString()))
                    putExtra(EXTRA_SUBJECT, arrayOf(subjectEt.text.toString()))
                    putExtra(EXTRA_TEXT, arrayOf(messageEt.text.toString()))

                    setDataAndType(Uri.parse("mailto:"), "message/rfc822")

                    startActivity(this)
                }
            }
        }
    }
}