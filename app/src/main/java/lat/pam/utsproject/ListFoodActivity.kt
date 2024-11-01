package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the food list data
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cheese Cake", "Desert kue dengan bahan utama keju", R.drawable.cheesecake),
            Food("Cireng", "Makanan ringan yang dibuat dari tepung tapioka, mempunyai tekstur cruncy", R.drawable.cireng),
            Food("Donat", "Donat enak dengan rasa", R.drawable.donut),
            Food("Kopi Hitam", "Kopi hitam dengan aroma khas dan rasa yang kuat", R.drawable.kopi_hitam),
            Food("Mie Goreng", "Mie goreng dengan bumbu khas dan cita rasa gurih", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Nasi goreng spesial dengan bumbu rempah pilihan", R.drawable.nasigoreng),
            Food("Sparkling Tea", "Minuman teh segar dengan sensasi soda", R.drawable.sparkling_tea),
        )

        adapter = FoodAdapter(foodList) { foodName ->
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("food_name", foodName.name)

            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
