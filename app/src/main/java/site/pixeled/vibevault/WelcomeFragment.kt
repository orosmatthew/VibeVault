package site.pixeled.vibevault

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        view.findViewById<Button>(R.id.welcomeStartButton).setOnClickListener {
            val name = view.findViewById<EditText>(R.id.welcomeNameField).text.toString()
            if (name.isEmpty()) {
                Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("name", name)
                Navigation.findNavController(view)
                    .navigate(R.id.action_welcomeFragment_to_homeFragment, bundle)
            }
        }

        return view
    }
}