package com.plcoding.cryptocurrencyapp.data.repository

import com.plcoding.cryptocurrencyapp.common.Resource
import com.plcoding.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyapp.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.plcoding.cryptocurrencyapp.domain.model.Coin
import com.plcoding.cryptocurrencyapp.domain.model.CoinDetail
import com.plcoding.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

// Implementation of the CoinRepository
class CoinRepository @Inject constructor(private var api: CoinPaprikaApi) : CoinRepository{

/*    override suspend fun getCoinById(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toCoinDetail()
    }
*/
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