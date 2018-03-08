package sample.kanda.data.infra.model

import kanda.libs.domain.ChuckNorrisFact

/**
 * Created by caique on 3/7/18.
 */
object MapChuckNorrisResponseToDomain {
    operator fun invoke(response: ChuckNorrisResponse): ChuckNorrisFact {
        return response.run {
            ChuckNorrisFact(
                    iconUrl = iconUrl ?: "https://api.chucknorris.io/jokes",
                    phrase = value ?: "Something wrong"
            )
        }
    }
}