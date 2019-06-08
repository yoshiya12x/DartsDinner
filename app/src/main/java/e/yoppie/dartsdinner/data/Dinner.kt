package e.yoppie.dartsdinner.data

import com.squareup.moshi.Json

data class Dinner(
    @Json(name = "recipeId")
    val id: String,
    @Json(name = "recipeTitle")
    val name: String,
    @Json(name = "recipeUrl")
    val url: String
)