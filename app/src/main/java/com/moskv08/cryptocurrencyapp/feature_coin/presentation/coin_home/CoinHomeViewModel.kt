package com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moskv08.cryptocurrencyapp.core.Constants
import com.moskv08.cryptocurrencyapp.core.Resource
import com.moskv08.cryptocurrencyapp.feature_coin.domain.use_case.get_coin_details.GetCoinUseCase
import com.moskv08.cryptocurrencyapp.feature_coin.domain.use_case.get_coin_market_cap.GetCoinMarketCap
import com.moskv08.cryptocurrencyapp.feature_coin.presentation.coin_detail.CoinDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinHomeViewModel @Inject constructor(
    private val getCoinMarketCapUseCase: GetCoinMarketCap
) : ViewModel() {

    // Handel Home screen state
    private val _state = mutableStateOf(CoinHomeState())
    val state: State<CoinHomeState> = _state

    init {
        getCoinMarketCap()
    }

    private fun getCoinMarketCap() {
        getCoinMarketCapUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinHomeState(marketCap = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinHomeState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinHomeState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}
