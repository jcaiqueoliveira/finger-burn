package sample.kanda.data.mappers

import android.util.MalformedJsonException
import com.google.gson.JsonIOException
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import kanda.libs.domain.DomainException

/**
 * Created by caique on 3/6/18.
 */

fun mapGsonErrorToDomainError(err: Throwable): Throwable {
    return when (err) {
        is JsonSyntaxException,
        is MalformedJsonException,
        is JsonParseException,
        is JsonIOException -> DomainException.SerializationException
        else -> err
    }
}