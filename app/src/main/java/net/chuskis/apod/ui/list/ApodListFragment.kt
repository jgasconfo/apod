package net.chuskis.apod.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import net.chuskis.apod.base.BaseFragment
import net.chuskis.apod.databinding.FragmentApodListBinding
import net.chuskis.apod.network.NetworkStatus
import net.chuskis.apod.viewmodel.ApodViewModel

class ApodListFragment : BaseFragment() {

    private var _binding: FragmentApodListBinding? = null
    private val binding get() = _binding!!

    private val adapter = ApodAdapter { apod ->
        apodViewModel.getApodDetail(apod)
        router.navigateToApodDetail(requireActivity())
    }

    private val apodViewModel : ApodViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentApodListBinding.inflate(inflater, container, false)
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
        apodViewModel.getApodList()
    }

    private fun initViews() {
        binding.apodList.adapter = adapter
        binding.todayButton.setOnClickListener {
            router.navigateToTodayApod(requireActivity())
        }
    }

    private fun observeLiveData() {
        apodViewModel.apodList.observe(viewLifecycleOwner) {
            progressManager?.hideProgress()
            when (it.status) {
                NetworkStatus.SUCCESS -> adapter.submitList(it.data)
                NetworkStatus.ERROR -> showErrorMessage(it.errorCode)
                NetworkStatus.LOADING -> progressManager?.showProgress()
            }
        }
    }

}