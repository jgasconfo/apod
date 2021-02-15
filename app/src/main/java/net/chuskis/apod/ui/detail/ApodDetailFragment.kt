package net.chuskis.apod.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import net.chuskis.apod.base.BaseFragment
import net.chuskis.apod.databinding.FragmentApodDetailBinding
import net.chuskis.apod.model.responses.Apod
import net.chuskis.apod.viewmodel.ApodViewModel

class ApodDetailFragment : BaseFragment() {

    private var _binding: FragmentApodDetailBinding? = null
    private val binding get() = _binding!!

    private val apodViewModel : ApodViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentApodDetailBinding.inflate(inflater, container, false)
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
    }

    private fun initViews() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun observeLiveData() {
        apodViewModel.apodDetail.observe(viewLifecycleOwner) {
            loadViews(it)
        }
    }

    private fun loadViews(apod: Apod) {
        binding.headerImage.load(apod.hdurl)
        binding.apodTitleTextView.text = apod.title
        binding.collapsingToolbar.title = apod.title
        binding.apodTextTextView.text = apod.explanation
    }
}