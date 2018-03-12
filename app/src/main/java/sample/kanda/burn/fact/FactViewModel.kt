package sample.kanda.burn.fact

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import kanda.libs.domain.RetriveChuckNorrisFact
import sample.kanda.app.structure.HandleState
import sample.kanda.app.structure.LOADING
import sample.kanda.app.structure.State

/**
 * Created by caique on 3/12/18.
 */
class FactViewModel(private val api: RetriveChuckNorrisFact) : ViewModel() {

    fun getFact(term: String): Observable<State> {
        return api.getFacts(term)
                .map { MapDomainFactToPresentation(it) }
                .compose(HandleState())
                .startWith(LOADING)
    }
}