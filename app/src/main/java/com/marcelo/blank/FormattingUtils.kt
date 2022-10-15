package com.marcelo.blank

import android.text.style.RelativeSizeSpan
import androidx.core.text.buildSpannedString
import androidx.core.text.inSpans
import java.time.Duration
import java.time.Instant
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

private const val UNITS_RELATIVE_SIZE = .6f
private val MINUTES_PER_HOUR = TimeUnit.HOURS.toMinutes(1)
private val SECONDS_PER_MINUTE = TimeUnit.MINUTES.toSeconds(1)

/**
 * Format an elapsed duration as `01m01s`. Hours are shown if present, e.g. `1h01m01s`. If
 * [includeSeconds] is `false`, seconds are omitted, e.g. `01m` or `1h01m`.
 */
fun formatElapsedTime(elapsedDuration: Duration, includeSeconds: Boolean) = buildSpannedString {
    val hours = elapsedDuration.toHours()
    if (hours > 0) {
        append(hours.toString())
        inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
            append("h")
        }
    }
    val minutes = elapsedDuration.toMinutes() % MINUTES_PER_HOUR
    append("%02d".format(minutes))
    inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
        append("m")
    }
    if (includeSeconds) {
        val seconds = elapsedDuration.seconds % SECONDS_PER_MINUTE
        append("%02d".format(seconds))
        inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
            append("s")
        }
    }
}

/** Format a distance to two decimals with a "km" suffix. */
fun formatDistanceKm(meters: Double) = buildSpannedString {
    append("%02.2f".format(meters / 1_000))
    inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
        append("km")
    }
}

/** Format calories burned to an integer with a "cal" suffix. */
fun formatCalories(calories: Double) = buildSpannedString {
    append(calories.roundToInt().toString())
    inSpans(RelativeSizeSpan(UNITS_RELATIVE_SIZE)) {
        append(" cal")
    }
}
