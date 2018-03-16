package sample.kanda.data.infra.service

import io.reactivex.Observable
import kanda.libs.domain.ChuckNorrisFact
import kanda.libs.domain.RetriveChuckNorrisFact
import sample.kanda.data.infra.model.ChuckNorrisResult
import sample.kanda.data.infra.model.MapChuckNorrisResponseToDomain
import sample.kanda.data.transformers.ComposeInfraStructureTransformers

/**
 * Created by caique on 3/7/18.
 */
class Service(val api: ChuckNorrisApi) : RetriveChuckNorrisFact {
    override fun getFacts(term: String): Observable<ChuckNorrisFact> {
        return api
                .getFactByTerm(term)
                .compose(ComposeInfraStructureTransformers<ChuckNorrisResult>())
                .flatMapIterable { it.result }
                .map {
                    MapChuckNorrisResponseToDomain(it)
                }
    }

}