package com.example.canesurvey.model

/**
 * Model class for holding measured error between two locations
 */
data class MeasuredError(val error: Float,
                         val vertError: Double = Double.NaN)