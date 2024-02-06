package site.pixeled.vibevault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import site.pixeled.vibevault.models.MoodData

class MoodListEntryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mood_list, container, false)
        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            val adapter = MoodListEntryRecyclerViewAdapter(MoodData.entries())
            adapter.setOnRowSelectListener { rowIndex ->
                Toast.makeText(context, "Row Index: $rowIndex", Toast.LENGTH_SHORT).show()
            }
            view.adapter = adapter
        }
        return view
    }
}