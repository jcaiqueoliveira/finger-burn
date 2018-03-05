package kanda.libs.domain

import io.reactivex.Observable

interface RetriveChuckNorrisFact {
    fun getFacts(term: String): Observable<ChuckNorrisFact>
}
