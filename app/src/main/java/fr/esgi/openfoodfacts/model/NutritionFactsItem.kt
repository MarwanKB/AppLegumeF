package fr.esgi.openfoodfacts.model

import java.io.Serializable

data class NutritionFactsItem(
    val unit: String,
    val perPortion: Double?,
    val per100g: Double): Serializable {
}