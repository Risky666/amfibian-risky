package id.mohamadriskyrizaldi.amfibian.data

import id.mohamadriskyrizaldi.amfibian.model.Amphibian
import id.mohamadriskyrizaldi.amfibian.network.AmphibiansApiService

// Interface yang mendefinisikan kontrak untuk repositori yang menangani data Amphibians
interface AmphibiansRepository {
    // Fungsi untuk mengambil daftar objek Amphibian
    suspend fun getAmphibians(): List<Amphibian>
}

// Implementasi default dari interface AmphibiansRepository
class DefaultAmphibiansRepository(
    // Layanan API Retrofit untuk mengambil data Amphibians dari jaringan
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {

    // Implementasi fungsi getAmphibians, mengambil data melalui layanan API
    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
}
