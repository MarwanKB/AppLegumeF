package fr.esgi.openfoodfacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import fr.esgi.openfoodfacts.model.NutritionFacts
import fr.esgi.openfoodfacts.model.NutritionFactsItem
import fr.esgi.openfoodfacts.model.Product
import fr.esgi.openfoodfacts.model.enum.NutriScore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.action_bar))

        val nutritionFacts = NutritionFacts(
            NutritionFactsItem("kj", null, 293.0),
            NutritionFactsItem("g", null, 0.8),
            NutritionFactsItem("g", null, 0.1),
            NutritionFactsItem("g", null, 8.4),
            NutritionFactsItem("g", null, 5.2),
            NutritionFactsItem("g", null, 5.2),
            NutritionFactsItem("g", null, 4.8),
            NutritionFactsItem("g", null, 0.75),
            NutritionFactsItem("g", null, 0.295),
        )

        // Create fake product
        val product = Product(
            "Petits pois et carottes",
            "Cassegrain",
            3083680085304,
            NutriScore.B,
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400 g (280 g net égoutté)",
            listOf<String>("France", "Japon", "Suisse"),
            "Petits pois 66%, eau, garniture 2,8% (salade, oignon grelot), sucre, sel, arôme naturel",
            "Aucune",
            "Aucune",
            nutritionFacts
        )
        // Start ActivityDetail
//        val intent = Intent(this, ActivityDetail::class.java)
//        intent.putExtra("product", product)
//        startActivity(intent)

        // Start ActivityDetail
        val intent = Intent(this, NutritionActivity::class.java)
        intent.putExtra("nutrition_facts", nutritionFacts)
        startActivity(intent)

    }
}