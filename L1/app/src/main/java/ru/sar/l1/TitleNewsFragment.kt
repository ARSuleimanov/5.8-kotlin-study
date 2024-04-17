package ru.sar.l1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TitleNewsFragment : Fragment() {

    var listOfTitleTextView: MutableList<TextView> = mutableListOf()

    fun highLightItem(NumberOfItem: Int) {
        listOfTitleTextView[NumberOfItem].setTextColor(Color.GREEN)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title_news, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resources = requireContext().resources
        val packageName = requireContext().packageName

        for (i in 0..5) {
            val textViewId = resources.getIdentifier("txtTitle${i + 1}", "id", packageName)
            val textView = view.findViewById<TextView>(textViewId)
            listOfTitleTextView.add(textView)
            textView.text = NewsList.news[i].title
        }


        fun createNewsFragment(numberElementInArray: Int) {
            parentFragmentManager.beginTransaction().replace(
                R.id.NewsContainer,
                TheNewsFragment.newInstance(numberElementInArray),
                "News Fragment"
            ).addToBackStack(null).commit()
            NewsList.forwardStack.clear()

        }
        view.findViewById<TextView>(R.id.txtTitle1).setOnClickListener { createNewsFragment(0) }
        view.findViewById<TextView>(R.id.txtTitle2).setOnClickListener { createNewsFragment(1) }
        view.findViewById<TextView>(R.id.txtTitle3).setOnClickListener { createNewsFragment(2) }
        view.findViewById<TextView>(R.id.txtTitle4).setOnClickListener { createNewsFragment(3) }
        view.findViewById<TextView>(R.id.txtTitle5).setOnClickListener { createNewsFragment(4) }
        view.findViewById<TextView>(R.id.txtTitle6).setOnClickListener { createNewsFragment(5) }
    }


}