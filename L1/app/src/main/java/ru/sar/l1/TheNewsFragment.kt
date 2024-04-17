package ru.sar.l1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


const val TAG = "number"

class TheNewsFragment : Fragment() {
    private var param: Int? = null


    override fun onDetach() {
        super.onDetach()
        NewsList.forwardStack.add(param?:100)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getInt(TAG)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.NewsTitle).text=NewsList.news[param?: return@onViewCreated].title
        view.findViewById<TextView>(R.id.NewsAuthor).text=NewsList.news[param?: return@onViewCreated].author
        view.findViewById<TextView>(R.id.NewsContent).text=NewsList.news[param?: return@onViewCreated].content

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_the_news, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param Parameter 1.
         * @return A new instance of fragment TheNewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param: Int) =
            TheNewsFragment().apply {
                arguments = Bundle().apply {
                    putInt(TAG, param)
                }
            }
    }
}