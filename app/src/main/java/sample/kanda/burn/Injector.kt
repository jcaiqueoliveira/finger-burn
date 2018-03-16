package sample.kanda.burn

import android.content.Context
import com.github.salomonbrys.kodein.*
import io.reactivex.schedulers.Schedulers
import kanda.libs.domain.RetriveChuckNorrisFact
import sample.kanda.burn.fact.FactNavigator
import sample.kanda.burn.fact.FactViewModel
import sample.kanda.data.infra.service.ChuckNorrisApi
import sample.kanda.data.infra.service.Service
import sample.kanda.data.infra.service.ServiceBuilder

/**
 * Created by caique on 3/15/18.
 */
class Injector(val context: Context) {
    val dependency = Kodein {
        bind<FactViewModel>() with provider {
            FactViewModel(useCase = instance())
        }

        bind<RetriveChuckNorrisFact>() with singleton {
            Service(api = instance())
        }

        bind<ChuckNorrisApi>() with singleton {
            ServiceBuilder(instance())
                    .create(ChuckNorrisApi::class.java)
        }

        bind<FactNavigator>() with provider {
            FactNavigator(Schedulers.computation())
        }

        bind<String>() with singleton {
            "https://api.chucknorris.io/jokes/"
        }
    }
}