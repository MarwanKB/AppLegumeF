package fr.esgi.openfoodfacts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import fr.esgi.openfoodfacts.model.NutritionFacts

class NutritionActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition)

        val nutritionFacts = intent.getSerializableExtra("nutrition_facts") as NutritionFacts

        val fatNutritionLevelIconView = findViewById<View>(R.id.nutrient_level_fat)
        val acideNutritionLevelIconView = findViewById<View>(R.id.nutrient_level_acide)
        val sugarNutritionLevelIconView = findViewById<View>(R.id.nutrient_level_sugar)
        val saltNutritionLevelIconView = findViewById<View>(R.id.nutrient_level_salt)

        val fatQuantityInfo = findViewById<TextView>(R.id.fat_quantity_info)
        val acideQuantityInfo = findViewById<TextView>(R.id.acide_quantity_info)
        val sugarQuantityInfo = findViewById<TextView>(R.id.sugar_quantity_info)
        val saltQuantityInfo = findViewById<TextView>(R.id.salt_quantity_info)

        val fatQuantityDescription = findViewById<TextView>(R.id.fat_quantity_desc)
        val acideQuantityDescription = findViewById<TextView>(R.id.acide_quantity_desc)
        val sugarQuantityDescription = findViewById<TextView>(R.id.sugar_quantity_desc)
        val saltQuantityDescription = findViewById<TextView>(R.id.salt_quantity_desc)

        fatQuantityInfo.setText(
            infoStringFormat(nutritionFacts.fat.per100g, nutritionFacts.fat.unit, getString(R.string.fat_quantity_info))
        )

        acideQuantityInfo.setText(
            infoStringFormat(nutritionFacts.acides.per100g, nutritionFacts.acides.unit, getString(R.string.acide_quantity_info))
        )

        sugarQuantityInfo.setText(
            infoStringFormat(nutritionFacts.sugar.per100g, nutritionFacts.sugar.unit, getString(R.string.sugar_quantity_info))
        )

        saltQuantityInfo.setText(
            infoStringFormat(nutritionFacts.salt.per100g, nutritionFacts.salt.unit, getString(R.string.salt_quantity_info))
        )

        // TODO: rounded icon
        // Fat
        if (nutritionFacts.fat.per100g < 3.0 ) {
            fatNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_low)
            fatQuantityDescription.setText(R.string.low_quantity_text)
        }
        else if (nutritionFacts.fat.per100g >= 3 && nutritionFacts.fat.per100g <= 20) {
            fatNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_moderate)
            fatQuantityDescription.setText(R.string.medium_quantity_text)
        }
        else {
            fatNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_high)
            fatQuantityDescription.setText(R.string.medium_quantity_text)
        }

        // Acides
        if (nutritionFacts.acides.per100g < 1.5 ) {
            acideNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_low)
            acideQuantityDescription.setText(R.string.low_quantity_text)
        }
        else if (nutritionFacts.acides.per100g >= 1.5 && nutritionFacts.acides.per100g <= 5) {
            acideNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_moderate)
            acideQuantityDescription.setText(R.string.medium_quantity_text)
        }
        else {
            acideNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_high)
            acideQuantityDescription.setText(R.string.medium_quantity_text)
        }

        // Sugar
        if (nutritionFacts.sugar.per100g < 5 ) {
            sugarNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_low)
            sugarQuantityDescription.setText(R.string.low_quantity_text)
        }
        else if (nutritionFacts.sugar.per100g >= 5 && nutritionFacts.sugar.per100g <= 12) {
            sugarNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_moderate)
            sugarQuantityDescription.setText(R.string.medium_quantity_text)
        }
        else {
            sugarNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_high)
            sugarQuantityDescription.setText(R.string.medium_quantity_text)
        }

        // Salt
        if (nutritionFacts.salt.per100g < 0.3 ) {
            saltNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_low)
            saltQuantityDescription.setText(R.string.low_quantity_text)
        }
        else if (nutritionFacts.sugar.per100g >= 0.3 && nutritionFacts.sugar.per100g <= 1.5) {
            saltNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_moderate)
            saltQuantityDescription.setText(R.string.medium_quantity_text)
        }
        else {
            saltNutritionLevelIconView.setBackgroundResource(R.color.nutrient_level_high)
            saltQuantityDescription.setText(R.string.medium_quantity_text)
        }


    }

    fun infoStringFormat(quantity: Double, unit: String, text: String): String {
        return String.format("%s %s %s", quantity.toString(), unit, text)
    }
}