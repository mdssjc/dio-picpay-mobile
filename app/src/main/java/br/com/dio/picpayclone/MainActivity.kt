package br.com.dio.picpayclone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.dio.picpayclone.ui.componente.ComponenteViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val componenteViewModel: ComponenteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        componenteViewModel.componente.observe(this, Observer {
            it?.let { temComponentes ->
                if (temComponentes.bottomNavigation) {
                    navView.visibility = View.VISIBLE
                } else {
                    navView.visibility = View.GONE
                }
            }
        })
        navView.setupWithNavController(navController)
    }
}