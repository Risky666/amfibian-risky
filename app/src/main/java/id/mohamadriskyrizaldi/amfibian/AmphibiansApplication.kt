package id.mohamadriskyrizaldi.amfibian

import android.app.Application
import id.mohamadriskyrizaldi.amfibian.data.AppContainer
import id.mohamadriskyrizaldi.amfibian.data.DefaultAppContainer

// Kelas ini merupakan subclass dari Application yang digunakan untuk menginisialisasi dependensi aplikasi
class AmphibiansApplication : Application() {
    /** Instance dari AppContainer yang digunakan oleh kelas lain untuk memperoleh dependensi */
    lateinit var container: AppContainer

    // Fungsi yang dipanggil saat aplikasi dijalankan
    override fun onCreate() {
        super.onCreate()

        // Menginisialisasi container dengan instance DefaultAppContainer
        container = DefaultAppContainer()
    }
}
