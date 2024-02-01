package site.pixeled.vibevault

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import site.pixeled.vibevault.models.MoodData
import site.pixeled.vibevault.types.moods

class HomeFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val name = arguments?.getString("name")
        name.let {
            view.findViewById<TextView>(R.id.homeUserGettingTextView).text = "Welcome $it"
        }

        val moodDataText = StringBuilder()
        MoodData.forEach { entry ->
            val moodStringId = moods.find { mood -> mood.type == entry.type }?.stringId
            moodStringId?.let {
                moodDataText.appendLine("${entry.time} | ${getString(it)}")
            }
        }
        view.findViewById<TextView>(R.id.homeMoodDataTextView).text = moodDataText.toString()

        view.findViewById<Button>(R.id.homeLogMoodButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_logFragment)
        }

        return view
    }
}