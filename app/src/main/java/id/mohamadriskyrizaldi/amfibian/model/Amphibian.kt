package id.mohamadriskyrizaldi.amfibian.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Amphibian(
    // Properti name yang menyimpan nama amfibi
    val name: String,

    // Properti type yang menyimpan jenis amfibi
    val type: String,

    // Properti description yang menyimpan deskripsi amfibi
    val description: String,

    // Properti imgSrc yang menyimpan URL gambar amfibi
    // Anotasi @SerialName digunakan untuk menentukan nama properti dalam JSON
    @SerialName("img_src") val imgSrc: String
)
