package fr.esgi.openfoodfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import fr.esgi.openfoodfacts.model.Product

class ActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getSerializableExtra("product") as Product


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