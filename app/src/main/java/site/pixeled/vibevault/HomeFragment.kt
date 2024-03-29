package site.pixeled.vibevault

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

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

        view.findViewById<Button>(R.id.homeLogMoodButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_logFragment)
        }

        return view
    }
}