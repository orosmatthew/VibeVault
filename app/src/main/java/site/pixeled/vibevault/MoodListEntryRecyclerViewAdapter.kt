package site.pixeled.vibevault

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import site.pixeled.vibevault.databinding.FragmentMoodListEntryBinding
import site.pixeled.vibevault.models.MoodEntry
import site.pixeled.vibevault.types.MoodType
import java.util.Date

class MoodListEntryRecyclerViewAdapter(private val mMoodEntries: List<MoodEntry>) :
    RecyclerView.Adapter<MoodListEntryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentMoodListEntryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = mMoodEntries[position]
        holder.idView.text = position.toString()
        holder.contentView.text = entry.time.toString()
    }

    override fun getItemCount(): Int = mMoodEntries.size

    inner class ViewHolder(binding: FragmentMoodListEntryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
    }

}