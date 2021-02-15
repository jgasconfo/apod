package net.chuskis.apod.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import net.chuskis.apod.databinding.ActivityMainBinding
import net.chuskis.apod.router.MainRouter
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ProgressManager {

    @Inject
    lateinit var router: MainRouter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        router.navigateToApodList(this)
    }

    override fun showProgress() {
        binding.progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progress.visibility = View.GONE
    }
}