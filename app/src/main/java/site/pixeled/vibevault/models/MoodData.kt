package site.pixeled.vibevault.models

import site.pixeled.vibevault.types.MoodType
import java.util.Date

data class MoodEntry(val type: MoodType, val time: Date, val description: String?)

object MoodData : Iterable<MoodEntry> {
    private val mEntries = ArrayList<MoodEntry>()

    fun addEntry(entry: MoodEntry) {
        mEntries.add(entry)
    }

    fun removeAt(index: Int) {
        mEntries.removeAt(index)
    }

    fun entries(): List<MoodEntry> {
        return mEntries
    }

    override fun iterator(): Iterator<MoodEntry> {
        return mEntries.iterator()
    }

}