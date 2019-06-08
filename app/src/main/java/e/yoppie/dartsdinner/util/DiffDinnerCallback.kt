package e.yoppie.dartsdinner.util

import android.support.v7.util.DiffUtil
import e.yoppie.dartsdinner.data.Dinner

class DiffCompanyCallback(private val oldList: MutableList<Dinner>, private val newList: MutableList<Dinner>) : DiffUtil.Callback() {
    override fun areContentsTheSame(oldPosition: Int, newPosition: Int) = oldList[oldPosition] == (newList[newPosition])

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int) = oldList[oldPosition].id == (newList[newPosition]).id

    override fun getNewListSize() = newList.size

    override fun getOldListSize() = oldList.size
}