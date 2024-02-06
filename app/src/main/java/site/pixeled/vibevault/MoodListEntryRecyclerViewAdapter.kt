package site.pixeled.vibevault

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import site.pixeled.vibevault.databinding.FragmentMoodListEntryBinding
import site.pixeled.vibevault.models.MoodEntry
import site.pixeled.vibevault.types.moodTypeStringId

class MoodListEntryRecyclerViewAdapter(private val mMoodEntries: List<MoodEntry>) :
    RecyclerView.Adapter<MoodListEntryRecyclerViewAdapter.ViewHolder>() {

    private var mOnRowSelectListener: ((rowIndex: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentMoodListEntryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    fun setOnRowSelectListener(listener: (rowIndex: Int) -> Unit) {
        mOnRowSelectListener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = mMoodEntries[position]
        val moodStringId = moodTypeStringId(entry.type)
        holder.moodView.text =
            if (moodStringId != null) holder.itemView.context.getString(moodStringId) else "Unknown"
        holder.dateView.text = entry.time.toString()
    }


    override fun getItemCount(): Int = mMoodEntries.size

    inner class ViewHolder(binding: FragmentMoodListEntryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                mOnRowSelectListener?.invoke(layoutPosition)
            }
        }

        val moodView: TextView = binding.moodListEntryMood
        val dateView: TextView = binding.moodListEntryDate
    }
}