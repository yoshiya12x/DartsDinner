package e.yoppie.dartsdinner.repository

class DinnerRepository: BaseRepository() {
    fun getDinnerList() = this.retrofit
        .create(FoodListApiInterface::class.java)
        .getFoodList()
}