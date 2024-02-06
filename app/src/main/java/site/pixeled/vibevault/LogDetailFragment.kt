package site.pixeled.vibevault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import site.pixeled.vibevault.models.MoodData
import site.pixeled.vibevault.types.moodTypeStringId

class LogDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log_detail, container, false)
        val logIndex = arguments?.getInt("logIndex")
        logIndex?.let {
            val moodEntry = MoodData.entries()[logIndex]
            view.findViewById<TextView>(R.id.logDetailHeader).text = moodEntry.time.toString()
            moodTypeStringId(moodEntry.type)?.let { stringId ->
                view.findViewById<TextView>(R.id.logDetailMood).text = getString(stringId)
            }
            view.findViewById<TextView>(R.id.logDetailDescription).text =
                moodEntry.description ?: "No Description"

            view.findViewById<Button>(R.id.logDetailDelete).setOnClickListener {
                MoodData.removeAt(logIndex)
                Navigation.findNavController(view).popBackStack()
            }
        }

        return view
    }
}