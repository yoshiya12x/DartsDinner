package e.yoppie.dartsdinner.viewmodel

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import e.yoppie.dartsdinner.data.Dinner
import e.yoppie.dartsdinner.repository.DinnerRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    var dinnerMutableLiveData = MutableLiveData<MutableList<Dinner>>()
    private val dinnerRepository = DinnerRepository()

    var dinnerMutableList = mutableListOf(
        Dinner("1", "カレー", "https://cookpad.com/"),
        Dinner("2", "肉じゃが", "https://cookpad.com/"),
        Dinner("3", "うどん", "https://cookpad.com/"),
        Dinner("4", "シチュー", "https://cookpad.com/"),
        Dinner("5", "野菜炒め", "https://cookpad.com/"),
        Dinner("6", "ミートスパゲティ", "https://cookpad.com/"),
        Dinner("7", "オムライス", "https://cookpad.com/"),
        Dinner("8", "ポトフ", "https://cookpad.com/"),
        Dinner("9", "鳥の唐揚げ", "https://cookpad.com/"),
        Dinner("10", "おでん", "https://cookpad.com/"),
        Dinner("11", "牛丼", "https://cookpad.com/"),
        Dinner("12", "ロールキャベツ", "https://cookpad.com/"),
        Dinner("13", "コロッケ", "https://cookpad.com/"),
        Dinner("14", "酢豚", "https://cookpad.com/"),
        Dinner("15", "餃子", "https://cookpad.com/"),
        Dinner("16", "鯖", "https://cookpad.com/"),
        Dinner("17", "ラーメン", "https://cookpad.com/"),
        Dinner("18", "焼きそば", "https://cookpad.com/"),
        Dinner("19", "生姜焼き", "https://cookpad.com/"),
        Dinner("20", "親子丼", "https://cookpad.com/"),
        Dinner("50", "焼肉", "https://cookpad.com/")
    )

    init {
        dinnerMutableLiveData.value = dinnerMutableList
    }

    @SuppressLint("CheckResult")
    fun loadDinnerList(){
        dinnerRepository.getDinnerList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                dinnerMutableList = res.foodList
                dinnerMutableLiveData.value = dinnerMutableList
            }, { error ->
                Log.d("yoppie_debug", error.message)
            })
    }
}