class MoviesDiscoveryFilters(
    val releaseYear: Int,
    val region: String,
    val language: String,
    val sortBy: String,
    val page: Int
) {
    // Builder
    companion object {
        inline fun build(
            releaseYear: Int, // Mandatory parameter when the object is built
            region: String,
            language: String = "", // Optional parameter when the object is built
            sortBy: String = "",
            page: Int = 1,
            builder: MoviesDiscoveryFilters.() -> Unit = {}
        ): MoviesDiscoveryFilters {
            return MoviesDiscoveryFilters(releaseYear, region, language, sortBy, page).apply(builder)
        }
    }
}

class BuilderTest {

    @Test
    fun Builder() {
        val filters = MoviesDiscoveryFilters.build(releaseYear = 2022, region = "US") {
            language = "en"
            sortBy = "popularity.desc"
            page = 2
        }
    }
}