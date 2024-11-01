package lat.pam.utsproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve data from the intent
        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val name = intent.getStringExtra("name")
        val notes = intent.getStringExtra("notes")

        // Display the retrieved data
        findViewById<TextView>(R.id.foodNameTextView).text = "Food Name : $foodName"
        findViewById<TextView>(R.id.jumlahTextView).text = "Number of Servings : $servings"
        findViewById<TextView>(R.id.nameTextView).text = "Ordering Name : $name"
        findViewById<TextView>(R.id.notesTextView).text = "Notes : $notes"

        val backToMenuButton = findViewById<Button>(R.id.backtoMenu)

        backToMenuButton.setOnClickListener() {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
        }
    }
}