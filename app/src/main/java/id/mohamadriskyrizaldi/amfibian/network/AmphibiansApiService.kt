package id.mohamadriskyrizaldi.amfibian.network

import id.mohamadriskyrizaldi.amfibian.model.Amphibian
import retrofit2.http.GET

// Interface yang mendefinisikan endpoint API untuk mendapatkan data amfibi
interface AmphibiansApiService {
    // Mendefinisikan fungsi untuk mendapatkan daftar amfibi dari endpoint "amphibians"
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}
