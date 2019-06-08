package e.yoppie.dartsdinner.activity

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.res.ColorStateList
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import com.jakewharton.rxbinding2.support.v4.widget.refreshes
import com.jakewharton.rxbinding2.view.clicks
import e.yoppie.dartsdinner.R
import e.yoppie.dartsdinner.adapter.DinnerRecyclerViewAdapter
import e.yoppie.dartsdinner.databinding.ActivityMainBinding
import e.yoppie.dartsdinner.util.ScoreManagement
import e.yoppie.dartsdinner.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var score = 0
    private var isPreCode = false

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        activityMainBinding = binding

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.mainViewModel = viewModel

        binding.dinnerRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.dinnerRecyclerView.adapter = DinnerRecyclerViewAdapter(this, viewModel)
        binding.dinnerSwipeRefreshLayout
            .refreshes()
            .subscribe {
                viewModel.loadDinnerList()
                binding.dinnerSwipeRefreshLayout.isRefreshing = false
            }
        binding.arrowFloatingActionButton
            .clicks()
            .filter { score != 0 }
            .subscribe {
                val url =
                    if(score == 50) viewModel.dinnerMutableLiveData.value!![20].url
                    else viewModel.dinnerMutableLiveData.value!![score - 1].url
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("url", url)
                intent.putExtra("score", score)
                this.startActivity(intent)
            }
    }

    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        activityMainBinding.arrowFloatingActionButton.backgroundTintList =
            ColorStateList.valueOf(resources.getColor((R.color.colorAccent)))

        if (event!!.action != KeyEvent.ACTION_DOWN) {
            return super.dispatchKeyEvent(event)
        }

        val scoreManagement = ScoreManagement(event)
        if (scoreManagement.isPreCode()) {
            isPreCode = true
            return super.dispatchKeyEvent(event)
        }
        score = if (isPreCode) scoreManagement.convertPreCode() else scoreManagement.convert()

        activityMainBinding.scoreTextView.text = score.toString()
        isPreCode = false
        return super.dispatchKeyEvent(event)
    }
}
