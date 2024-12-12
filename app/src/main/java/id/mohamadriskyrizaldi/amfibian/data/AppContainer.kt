package id.mohamadriskyrizaldi.amfibian.data

import id.mohamadriskyrizaldi.amfibian.network.AmphibiansApiService
import id.mohamadriskyrizaldi.amfibian.model.Amphibian
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

// Interface yang mendefinisikan fungsi untuk mendapatkan data amfibi
interface AmphibiansRepository {
    // Fungsi suspend untuk mendapatkan daftar amfibi
    suspend fun getAmphibians(): List<Amphibian>
}

// Implementasi dari AmphibiansRepository yang berinteraksi dengan API untuk mendapatkan data
class DefaultAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {

    // Mengimplementasikan fungsi untuk mendapatkan daftar amfibi dari API
    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
}

// Interface untuk container aplikasi yang menyediakan repository
interface AppContainer {
    val amphibiansRepository: AmphibiansRepository
}

// Implementasi dari AppContainer untuk mengelola dependensi
class DefaultAppContainer : AppContainer {
    // URL dasar untuk API
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    // Membuat instance Retrofit yang digunakan untuk panggilan API
    private val retrofit: Retrofit = Retrofit.Builder()
        // Menambahkan converter factory menggunakan Kotlinx Serialization
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        // Mengatur base URL untuk Retrofit
        .baseUrl(BASE_URL)
        .build()

    // Membuat instance dari AmphibiansApiService menggunakan Retrofit
    private val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    // Menyediakan repository untuk aplikasi
    override val amphibiansRepository: AmphibiansRepository by lazy {
        DefaultAmphibiansRepository(retrofitService)
    }
}
