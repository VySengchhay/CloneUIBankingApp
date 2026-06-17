package com.androidapp.portfolio.feature.home.notification

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidapp.portfolio.app.BaseUiState
import com.androidapp.portfolio.data.models.NewsGroup
import com.androidapp.portfolio.data.models.TransactionGroup
import com.androidapp.portfolio.data.repository.NotificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotificationViewModel : ViewModel() {
    private val notificationRepository = NotificationRepository()

    private val _transactionList : MutableStateFlow<BaseUiState<List<TransactionGroup>>> =
        MutableStateFlow(BaseUiState.Loading)
    val transactionList: StateFlow<BaseUiState<List<TransactionGroup>>> = _transactionList.asStateFlow()

    private val _newsList : MutableStateFlow<BaseUiState<List<NewsGroup>>> =
        MutableStateFlow(BaseUiState.Loading)
    val newsList: StateFlow<BaseUiState<List<NewsGroup>>> = _newsList.asStateFlow()

    var selectedTab by mutableIntStateOf(0)
        private set

    fun onTabSelected(index: Int) {
        selectedTab = index
    }

    init {
        getNotificationTransactionList()
        getNotificationNewsList()
    }

    fun getNotificationTransactionList() {
        viewModelScope.launch {
            _transactionList.emit(BaseUiState.Loading)
            notificationRepository.getNotificationTransactionList().collect {
                _transactionList.emit(BaseUiState.Success(it))
            }
        }
    }

    fun getNotificationNewsList() {
        viewModelScope.launch {
            _newsList.emit(BaseUiState.Loading)
            notificationRepository.getNotificationNewsList().collect {
                _newsList.emit(BaseUiState.Success(it))
            }
        }
    }
}
