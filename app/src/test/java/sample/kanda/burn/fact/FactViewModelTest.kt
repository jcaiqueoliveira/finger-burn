package sample.kanda.burn.fact

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import kanda.libs.domain.ChuckNorrisFact
import kanda.libs.domain.RetriveChuckNorrisFact
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import sample.kanda.app.structure.ERROR
import sample.kanda.app.structure.LOADING
import sample.kanda.app.structure.SUCCESS

/**
 * Created by caique on 3/12/18.
 */
class FactViewModelTest {

    val api = mock<RetriveChuckNorrisFact>()
    val fact = ChuckNorrisFact("", "", "", "")
    lateinit var vm: FactViewModel
    @Before
    fun setUp() {
        vm = FactViewModel(api)
    }

    @Test
    fun `should start with loading and finish with a success state`() {
        whenever(api.getFacts("aaa")).thenReturn(Observable.just(fact))

        val result = vm.getFact("aaa")
                .test()
                .assertValueCount(2)
                .assertComplete()
                .assertNoErrors()
                .values()

        assertThat(result[0])
                .isInstanceOf(LOADING::class.java)

        assertThat(result[1])
                .isInstanceOf(SUCCESS::class.java)
    }

    @Test
    fun `should start with loading and finish with an error state`() {
        whenever(api.getFacts("aaa")).thenReturn(Observable.error(Throwable()))

        val result = vm.getFact("aaa")
                .test()
                .assertValueCount(2)
                .assertComplete()
                .values()

        assertThat(result[0])
                .isInstanceOf(LOADING::class.java)
        assertThat(result[1])
                .isInstanceOf(ERROR::class.java)

    }

}