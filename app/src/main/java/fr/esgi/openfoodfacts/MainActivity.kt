package fr.esgi.openfoodfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import fr.esgi.openfoodfacts.model.Product
import fr.esgi.openfoodfacts.model.enum.NutriScore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.action_bar))

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
            "Aucune"
        )

        // Retrieve the views
        val imageView = findViewById<ImageView>(R.id.main_image)
        val titleTextView = findViewById<TextView>(R.id.title_text)
        val subtitleTextView = findViewById<TextView>(R.id.subtitle_text)
        val nutriScoreImageView = findViewById<ImageView>(R.id.nutri_score_image)
        val barcodeTextView = findViewById<TextView>(R.id.barcode_value)
        val selledInTextView = findViewById<TextView>(R.id.selled_in_value)
        val quantityTextView = findViewById<TextView>(R.id.quantity_value)
        val ingredientTextView = findViewById<TextView>(R.id.ingredient_value)
        val allergenicSubstanceTextView = findViewById<TextView>(R.id.allergenic_substance_value)
        val additivesTextView = findViewById<TextView>(R.id.additives_value)

        // Set to the views
        Glide.with(this).load(product.imageUrl).into(imageView)
        titleTextView.setText(product.name)
        subtitleTextView.setText(product.brand)
        nutriScoreImageView.setImageResource(product.nutriScore.drawableId)
        barcodeTextView.setText(product.barcode.toString())
        selledInTextView.setText(product.selledIn.joinToString())
        quantityTextView.setText(product.quantity)
        ingredientTextView.setText(product.ingredients)
        allergenicSubstanceTextView.setText(product.allergenicSubstances)
        additivesTextView.setText(product.additives)
    }
}