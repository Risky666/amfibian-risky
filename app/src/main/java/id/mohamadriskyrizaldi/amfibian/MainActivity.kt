package id.mohamadriskyrizaldi.amfibian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import id.mohamadriskyrizaldi.amfibian.ui.AmphibiansApp
import id.mohamadriskyrizaldi.amfibian.ui.theme.AmphibiansTheme

// Kelas utama
class MainActivity : ComponentActivity() {
    // Fungsi yang dipanggil saat aktivitas pertama kali dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur konten tampilan untuk aktivitas  menggunakan Compose
        setContent {
            AmphibiansTheme {
                // Surface container menggunakan warna latar belakang dari tema yang diterapkan
                Surface(
                    modifier = Modifier.fillMaxSize(),  // Mengisi ukuran penuh layar
                    color = MaterialTheme.colorScheme.background  // Mengatur warna latar belakang sesuai tema
                ) {
                    // Menampilkan aplikasi utama amfibi
                    AmphibiansApp()
                }
            }
        }
    }
}
