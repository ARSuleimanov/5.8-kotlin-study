package ru.sar.l1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction().add(
            R.id.TitleContainer, TitleNewsFragment(), "Title Fragment"
        ).commit()

        findViewById<TextView>(R.id.btnBack).setOnClickListener {
            supportFragmentManager.popBackStack()
        }
        findViewById<TextView>(R.id.btnForward).setOnClickListener {
            if (NewsList.forwardStack.isNotEmpty()) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.NewsContainer, TheNewsFragment.newInstance(
                            NewsList
                                .forwardStack
                                .removeAt(NewsList.forwardStack.size - 1)
                        ), "News Fragment"
                    )
                    .addToBackStack(null)
                    .commit()

                //TheNewsFragment.newInstance(NewsList.forwardStack.removeAt(NewsList.forwardStack.size - 1))
            } else {
                Toast.makeText(this, "No pages in forward stack", Toast.LENGTH_SHORT).show()
            }


        }
    }
}