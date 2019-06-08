package e.yoppie.dartsdinner.adapter

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import e.yoppie.dartsdinner.BR
import e.yoppie.dartsdinner.R
import e.yoppie.dartsdinner.data.Dinner
import e.yoppie.dartsdinner.databinding.DinnerRecyclerViewItemBinding
import e.yoppie.dartsdinner.holder.DinnerRecyclerViewHolder
import e.yoppie.dartsdinner.util.DiffCompanyCallback
import e.yoppie.dartsdinner.viewmodel.DinnerRecyclerViewItemViewModel
import e.yoppie.dartsdinner.viewmodel.MainViewModel

class DinnerRecyclerViewAdapter(private val context: AppCompatActivity, viewModel: MainViewModel) :
    RecyclerView.Adapter<DinnerRecyclerViewHolder>() {

    private var dinnerMutableList: MutableList<Dinner> = mutableListOf()
    private var dinnerIdMutableList: MutableList<String> = mutableListOf()

    init {
        viewModel.dinnerMutableLiveData.observe({ context.lifecycle }, { it?.apply { update(this) } })
    }

    override fun onCreateViewHolder(parent: ViewGroup, pviewType: Int): DinnerRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<DinnerRecyclerViewItemBinding>(
            layoutInflater,
            R.layout.dinner_recycler_view_item,
            parent,
            false
        )
        binding.lifecycleOwner = context
        return DinnerRecyclerViewHolder(binding)
    }

    override fun getItemCount() = dinnerMutableList.size

    override fun onBindViewHolder(holder: DinnerRecyclerViewHolder, position: Int) {
        val dinnerRecyclerViewItemViewModel = DinnerRecyclerViewItemViewModel()
        dinnerRecyclerViewItemViewModel.setDinner(dinnerMutableList[position])
        holder.binding.apply {
            setVariable(BR.dinnerRecyclerViewItemViewModel, dinnerRecyclerViewItemViewModel)
            executePendingBindings()
        }
    }

    private fun update(companyList: MutableList<Dinner>) {
        val diff = DiffUtil.calculateDiff(DiffCompanyCallback(dinnerMutableList, companyList))
        diff.dispatchUpdatesTo(this)
        this.dinnerMutableList.clear()
        this.dinnerMutableList.addAll(companyList)
    }
}