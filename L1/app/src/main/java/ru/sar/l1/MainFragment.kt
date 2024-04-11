package ru.sar.l1


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import ru.sar.L1.ActivityInterface

class MainFragment : Fragment(R.layout.fragment_main){
    private var counter = 0
    private lateinit var textView:TextView
    fun resetCounter(){
        counter=0
        textView.text=counter.toString()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")

        view.findViewById<Button>(R.id.BtnFunMainAct).setOnClickListener {
            /* test function from mainActivity*/
            (requireActivity() as ActivityInterface).test()
        }

        val button=view.findViewById<Button>(R.id.button)
        textView=view.findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            counter++
            textView.text=counter.toString()
        }

        val resultButton=view.findViewById<Button>(R.id.result)
        resultButton.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .add(
                    R.id.fragmentContainer,
                    MainFragment2.newInstance(counter),
                    "MainFragment2"
                )
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }

}