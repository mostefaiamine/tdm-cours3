package dz.esi.demonavigation


import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


/**
 * composant 1
 */
class Composant1 : Fragment() {
    private var parent: ParentActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_composant1, container, false)
        val btn = view?.findViewById<Button>(R.id.btnTest)
        btn?.setOnClickListener {
            parent?.Signal()
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ParentActivity) {
            parent = context
        }
    }

    interface ParentActivity {
        fun Signal()
    }


}// Required empty public constructor
