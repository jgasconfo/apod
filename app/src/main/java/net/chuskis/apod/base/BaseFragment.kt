package net.chuskis.apod.base

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import net.chuskis.apod.router.MainRouter
import net.chuskis.apod.utils.StringManager
import javax.inject.Inject

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    @Inject
    open lateinit var router: MainRouter

    open var progressManager : ProgressManager? = null

    private val stringManager by lazy { StringManager(requireContext()) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ProgressManager) progressManager = context
    }

    open fun showErrorMessage(errorCode: Int?) {
        val code = errorCode ?: 0
        val message = stringManager.getErrorString(code)
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}