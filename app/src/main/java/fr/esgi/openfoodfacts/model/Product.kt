package fr.esgi.openfoodfacts.model

import fr.esgi.openfoodfacts.model.enum.NutriScore
import java.io.Serializable

data class Product(
    val name: String,
    val brand: String,
    val barcode: Long,
    val nutriScore: NutriScore,
    val imageUrl: String,
    val quantity: String,
    val selledIn: List<String>,
    val ingredients: String,
    val allergenicSubstances: String,
    val additives: String,
    val nutritionFacts: NutritionFacts
    ): Serializable  {
}