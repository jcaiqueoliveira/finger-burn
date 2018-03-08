package sample.kanda.data.mappers

import kanda.libs.domain.DomainException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * Created by caique on 3/6/18.
 */
fun mapConnectionExceptionsToDomainErrors(err: Throwable): Throwable {

    if (err is DomainException) {
        return err
    }
    return when (err) {
        is IOException,
        is UnknownHostException,
        is TimeoutException,
        is SocketTimeoutException -> DomainException.ClientException
        else -> DomainException.GenericException
    }
}