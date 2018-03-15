package sample.kanda.burn

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware

/**
 * Created by caique on 3/15/18.
 */
class FactApplication : Application(), KodeinAware {
    override val kodein: Kodein = Injector(this).dependency
}