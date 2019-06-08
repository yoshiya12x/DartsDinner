package e.yoppie.dartsdinner.repository

import e.yoppie.dartsdinner.data.FoodList
import io.reactivex.Observable
import retrofit2.http.GET

interface FoodListApiInterface {
    @GET("stage1/dinnerlisttest")
    fun getFoodList(
    ): Observable<FoodList>
}