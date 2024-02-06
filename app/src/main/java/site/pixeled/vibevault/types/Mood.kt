package site.pixeled.vibevault.types

import site.pixeled.vibevault.R

enum class MoodType {
    Happy, Ok, Sad
}

data class Mood(val type: MoodType, val logButtonId: Int, val stringId: Int)

val moods = arrayOf(
    Mood(MoodType.Happy, R.id.logHappyButton, R.string.mood_happy),
    Mood(MoodType.Ok, R.id.logOkButton, R.string.mood_ok),
    Mood(MoodType.Sad, R.id.logSadButton, R.string.mood_sad)
)

fun moodTypeStringId(moodType: MoodType): Int? {
    val mood = moods.find { m -> m.type == moodType }
    return mood?.stringId
}
