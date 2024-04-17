package ru.sar.l1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleNewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleNewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resources = requireContext().resources
        val packageName = requireContext().packageName

        for (i in 1..6) {
            val textViewId = resources.getIdentifier("txtTitle$i", "id", packageName)
            val textView = view.findViewById<TextView>(textViewId)
            textView.text = NewsList.news[i - 1].title
        }

        fun callNewsFragment(numberElementInArray: Int) {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.NewsContainer,
                    TheNewsFragment.newInstance(numberElementInArray),
                    "News Fragment"
                )
                .addToBackStack(null)
                .commit()
            NewsList.forwardStack.clear()

        }
        view.findViewById<TextView>(R.id.txtTitle1).setOnClickListener { callNewsFragment(0) }
        view.findViewById<TextView>(R.id.txtTitle2).setOnClickListener { callNewsFragment(1) }
        view.findViewById<TextView>(R.id.txtTitle3).setOnClickListener { callNewsFragment(2) }
        view.findViewById<TextView>(R.id.txtTitle4).setOnClickListener { callNewsFragment(3) }
        view.findViewById<TextView>(R.id.txtTitle5).setOnClickListener { callNewsFragment(4) }
        view.findViewById<TextView>(R.id.txtTitle6).setOnClickListener { callNewsFragment(5) }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title_news, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TitleNews.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TitleNewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}