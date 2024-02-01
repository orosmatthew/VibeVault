package site.pixeled.vibevault

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import site.pixeled.vibevault.types.MoodType
import site.pixeled.vibevault.types.moods

class LogFragment : Fragment() {

    private var mSelectedMood: MoodType? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_log, container, false)

        val selectedMoodView = view.findViewById<TextView>(R.id.logSelectedMood)
        val submitButton = view.findViewById<Button>(R.id.logSubmitButton)
        moods.forEach { mood ->
            view.findViewById<Button>(mood.logButtonId).setOnClickListener {
                mSelectedMood = mood.type
                selectedMoodView.text = getString(mood.stringId)
                submitButton.isEnabled = true
            }
        }

        view.findViewById<Button>(R.id.logSubmitButton).setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        return view
    }
}