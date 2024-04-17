package ru.sar.l1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


const val TAG = "number"

class TheNewsFragment : Fragment() {

    private var idNews: Int? = null
    private var menuItemColorBefore = Color.BLACK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * memorize color of menu item in the TitleFragment
         */
        arguments?.let {
            idNews = it.getInt(TAG)
            val fragment =
                parentFragmentManager.findFragmentByTag("Title Fragment") as? TitleNewsFragment
            val textView = fragment?.listOfTitleTextView?.get(idNews!!)
            menuItemColorBefore = textView?.currentTextColor!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_the_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.NewsTitle).text =
            NewsList.news[idNews ?: return@onViewCreated].title
        view.findViewById<TextView>(R.id.NewsAuthor).text =
            NewsList.news[idNews ?: return@onViewCreated].author
        view.findViewById<TextView>(R.id.NewsContent).text =
            NewsList.news[idNews ?: return@onViewCreated].content

    }

    override fun onStop() {
        super.onStop()

        //return the old color for the menu item
        val fragment =
            parentFragmentManager.findFragmentByTag("Title Fragment") as? TitleNewsFragment
        val textView = idNews?.let { fragment?.listOfTitleTextView?.get(it) }
        if (textView != null) {
            textView.setTextColor(menuItemColorBefore)
        }
    }

    override fun onDetach() {
        super.onDetach()
        //push to stack fragments for navigation in the future
        NewsList.forwardStack.add(idNews ?: 100)
    }


    override fun onResume() {
        super.onResume()
        val fragment =
            parentFragmentManager.findFragmentByTag("Title Fragment") as? TitleNewsFragment
        fragment?.highLightItem(idNews ?: return)
    }


    companion object {

        @JvmStatic
        fun newInstance(param: Int) = TheNewsFragment().apply {
            arguments = Bundle().apply {
                putInt(TAG, param)
            }
        }
    }
}