package sample.kanda.burn.fact

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import kanda.libs.domain.RetriveChuckNorrisFact
import sample.kanda.app.structure.HandleState
import sample.kanda.app.structure.LOADING
import sample.kanda.app.structure.State
import sample.kanda.burn.fact.states.WAITING_INPUT

/**
 * Created by caique on 3/12/18.
 */
class FactViewModel(private val useCase: RetriveChuckNorrisFact) : ViewModel() {

    fun initViewState(): Observable<State> {
        return Observable.just(WAITING_INPUT)
    }

    fun getFact(term: String): Observable<State> {
        return useCase.getFacts(term)
                .map { MapDomainFactToPresentation(it) }
                .compose(HandleState())
                .startWith(LOADING)
    }
}