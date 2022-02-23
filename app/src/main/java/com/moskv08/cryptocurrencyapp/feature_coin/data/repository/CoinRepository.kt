package com.moskv08.cryptocurrencyapp.feature_coin.data.repository

import com.moskv08.cryptocurrencyapp.core.Resource
import com.moskv08.cryptocurrencyapp.feature_coin.data.remote.CoinPaprikaApi
import com.moskv08.cryptocurrencyapp.feature_coin.data.remote.dto.toCoin
import com.moskv08.cryptocurrencyapp.feature_coin.data.remote.dto.toCoinDetail
import com.moskv08.cryptocurrencyapp.feature_coin.data.remote.dto.toCoinMarketCap
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.Coin
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinDetail
import com.moskv08.cryptocurrencyapp.feature_coin.domain.model.CoinMarketCap
import com.moskv08.cryptocurrencyapp.feature_coin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

// Implementation of the CoinRepository
class CoinRepository @Inject constructor(private var api: CoinPaprikaApi) : CoinRepository{

    override fun getCoinMarketCap(): Flow<Resource<CoinMarketCap>> = flow {
        try {
            emit(Resource.Loading())
            val marketCap = api.getCoinMarketInfo().toCoinMarketCap()
            emit(Resource.Success(marketCap))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinMarketCap>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinMarketCap>("Couldn't reach server. Check your internet connection."))
        }
    }

    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }

    override fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = api.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }

}