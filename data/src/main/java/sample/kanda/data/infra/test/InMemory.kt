package sample.kanda.data.infra.test

import io.reactivex.Observable
import kanda.libs.domain.ChuckNorrisFact
import kanda.libs.domain.RetriveChuckNorrisFact
import retrofit2.Response
import sample.kanda.data.transformers.ComposeInfraStructureTransformers

/**
 * Created by jcosilva on 3/5/2018.
 */
class InMemory : RetriveChuckNorrisFact {
    private lateinit var nextError: Throwable
    private var successState = false
    private val fact = ChuckNorrisFact(
            iconUrl = "",
            phrase = "some chucknorris sentence")

    val response: Response<ChuckNorrisFact> = Response.success(ChuckNorrisFact("", ""))

    override fun getFacts(term: String): Observable<ChuckNorrisFact> {
        return Observable.just(response)
                .map {
                    if (successState) {
                        it
                    } else {
                        throw nextError
                    }
                }
                .compose(ComposeInfraStructureTransformers())
    }

    fun nextError(error: Throwable) {
        this.nextError = error
    }

    fun successState() {
        this.successState = true
    }


}