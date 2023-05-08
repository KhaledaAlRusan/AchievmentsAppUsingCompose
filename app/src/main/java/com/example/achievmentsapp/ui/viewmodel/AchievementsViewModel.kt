package com.example.achievmentsapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.achievmentsapp.data.repository.Repository
import com.example.achievmentsapp.domain.models.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AchievementsViewModel @Inject constructor(private val repository: Repository)  : ViewModel() {

    private val _getSuccess:MutableStateFlow<List<Data>> = MutableStateFlow(emptyList())
    val getSuccess = _getSuccess.asStateFlow()


    private val _getError:MutableStateFlow<Exception?> = MutableStateFlow(null)
    val getError = _getError.asStateFlow()

    private val _getLoading:MutableStateFlow<Boolean> = MutableStateFlow(false)
    val getLoading = _getLoading.asStateFlow()

    init {
        getAchievements()
    }


    private fun getAchievements(){
        viewModelScope.launch {
            _getLoading.update { true }

            try {
                val response = repository.getAchievements()
                _getSuccess.update {response}
            }
            catch (e:Exception){
                _getError.update { e }
            }
            _getLoading.update { false  }
        }

    }


}