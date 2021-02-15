package net.chuskis.apod.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import net.chuskis.apod.base.BaseFragment
import net.chuskis.apod.databinding.FragmentTodayBinding
import net.chuskis.apod.model.responses.Apod
import net.chuskis.apod.network.NetworkStatus
import net.chuskis.apod.viewmodel.ApodViewModel

class TodayFragment : BaseFragment() {

    private var _binding: FragmentTodayBinding? = null
    private val binding get() = _binding!!

    private val apodViewModel : ApodViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeLiveData()
        apodViewModel.getTodayApod()
    }

    private fun initViews() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun observeLiveData() {
        apodViewModel.apodToday.observe(viewLifecycleOwner) {
            progressManager?.hideProgress()
            when (it.status) {
                NetworkStatus.SUCCESS -> it.data?.let { apod -> loadViews(apod) }
                NetworkStatus.ERROR -> showErrorMessage(it.errorCode)
                NetworkStatus.LOADING -> progressManager?.showProgress()
            }
        }
    }

    private fun loadViews(apod: Apod) {
        binding.image.load(apod.hdurl)
        binding.titleTextView.text = apod.title
        binding.explanationTextView.text = apod.explanation
    }
}