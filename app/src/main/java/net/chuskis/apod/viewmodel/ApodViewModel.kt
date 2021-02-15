package net.chuskis.apod.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import net.chuskis.apod.network.Resource
import net.chuskis.apod.repository.ApiRepository
import kotlinx.coroutines.launch
import net.chuskis.apod.model.responses.Apod

class ApodViewModel  @ViewModelInject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    val apodList = MutableLiveData<Resource<List<Apod>>>()
    fun getApodList() {
        viewModelScope.launch {
            apodList.value = Resource.loading(null)
            apodList.value = apiRepository.callGetRandomPictures()
        }
    }

    val apodDetail = MutableLiveData<Apod>()
    fun getApodDetail(apod: Apod) {
        apodDetail.value = apod
    }

    val apodToday = MutableLiveData<Resource<Apod>>()
    fun getTodayApod() {
        viewModelScope.launch {
            apodToday.value = Resource.loading(null)
            apodToday.value = apiRepository.callGetTodayPicture()
        }
    }

}