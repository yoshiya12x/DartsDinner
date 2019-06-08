package e.yoppie.dartsdinner.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import e.yoppie.dartsdinner.data.Dinner

class DinnerRecyclerViewItemViewModel : ViewModel() {
    val id = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    private val item = MutableLiveData<Dinner>().apply {
        this.observeForever {
            it?.apply {
                this@DinnerRecyclerViewItemViewModel.id.postValue(this.id)
                this@DinnerRecyclerViewItemViewModel.name.postValue(this.name)
            }
        }
    }

    fun setDinner(dinner: Dinner) {
        item.postValue(dinner)
    }
}