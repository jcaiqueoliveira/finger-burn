package sample.kanda.data.mappers

import kanda.libs.domain.DomainException
import retrofit2.Response

/**
 * Created by caique on 3/6/18.
 */

fun mapRestResponse(response: Response<*>): Any {
    return when (response.code()) {
        in 200..226 -> response.body() ?: Any()
        in 400..451 -> throw DomainException.ClientException
        in 500..511 -> throw DomainException.ServerException
        else -> throw DomainException.ClientException
    }
}