package e.yoppie.dartsdinner.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import e.yoppie.dartsdinner.data.Dinner

class MainViewModel : ViewModel() {
    var dinnerMutableLiveData = MutableLiveData<MutableList<Dinner>>()

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

    fun loadDinnerList(){
        dinnerMutableList = mutableListOf(
            Dinner("0", "ぐるなび", "https://cookpad.com/"),
            Dinner("1", "ぐるなび", "https://cookpad.com/"),
            Dinner("2", "ぐるなび", "https://cookpad.com/"),
            Dinner("3", "ぐるなび", "https://cookpad.com/"),
            Dinner("4", "ぐるなび", "https://cookpad.com/"),
            Dinner("5", "ぐるなび", "https://cookpad.com/"),
            Dinner("6", "ぐるなび", "https://cookpad.com/"),
            Dinner("7", "ぐるなび", "https://cookpad.com/"),
            Dinner("8", "ぐるなび", "https://cookpad.com/"),
            Dinner("9", "ぐるなび", "https://cookpad.com/"),
            Dinner("10", "ぐるなび", "https://cookpad.com/"),
            Dinner("11", "ぐるなび", "https://cookpad.com/"),
            Dinner("12", "ぐるなび", "https://cookpad.com/"),
            Dinner("13", "ぐるなび", "https://cookpad.com/"),
            Dinner("14", "ぐるなび", "https://cookpad.com/"),
            Dinner("15", "ぐるなび", "https://cookpad.com/"),
            Dinner("16", "ぐるなび", "https://cookpad.com/"),
            Dinner("17", "ぐるなび", "https://cookpad.com/"),
            Dinner("18", "ぐるなび", "https://cookpad.com/"),
            Dinner("19", "ぐるなび", "https://cookpad.com/"),
            Dinner("20", "ぐるなび", "https://cookpad.com/")
        )
        dinnerMutableLiveData.value = dinnerMutableList
    }
}