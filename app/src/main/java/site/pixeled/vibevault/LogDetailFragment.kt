package site.pixeled.vibevault

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class LogDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_detail, container, false)
        val rowIndex = arguments?.getInt("rowIndex")
        view.findViewById<TextView>(R.id.logDetailTemp).text = rowIndex?.toString() ?: "Unknown"
        return view
    }
}