package fr.esgi.openfoodfacts.model

import java.io.Serializable

class NutritionFacts (
    val energy: NutritionFactsItem,
    val fat: NutritionFactsItem,
    val acides: NutritionFactsItem,
    val glucides: NutritionFactsItem,
    val sugar: NutritionFactsItem,
    val fibers: NutritionFactsItem,
    val proteins: NutritionFactsItem,
    val salt: NutritionFactsItem,
    val sodium: NutritionFactsItem
        ) : Serializable {
}