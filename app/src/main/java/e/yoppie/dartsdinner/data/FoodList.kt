package e.yoppie.dartsdinner.data

import com.squareup.moshi.Json

data class FoodList(
    @Json(name = "result")
    val foodList: MutableList<Dinner>
)