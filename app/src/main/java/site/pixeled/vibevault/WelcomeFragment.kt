package site.pixeled.vibevault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class WelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val submitButton = view.findViewById<Button>(R.id.welcomeStartButton)
        view.findViewById<EditText>(R.id.welcomeNameField).addTextChangedListener { text ->
            submitButton.isEnabled = !text.isNullOrEmpty()
        }

        submitButton.setOnClickListener {
            val name = view.findViewById<EditText>(R.id.welcomeNameField).text.toString()
            val bundle = Bundle()
            bundle.putString("name", name)
            Navigation.findNavController(view)
                .navigate(R.id.action_welcomeFragment_to_homeFragment, bundle)
        }

        return view
    }
}