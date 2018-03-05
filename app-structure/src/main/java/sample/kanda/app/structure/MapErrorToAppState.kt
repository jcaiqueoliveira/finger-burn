package sample.kanda.app.structure

import kanda.libs.domain.DomainException.*

/**
 * Created by jcosilva on 3/5/2018.
 */

object MapErrorToAppState {
    operator fun invoke(error: Throwable): State {
        return when (error) {
            ClientException,
            TimeoutException -> ERROR(Connection)
            ServerException -> ERROR(Response)
            else -> ERROR(Generic)
        }
    }
}