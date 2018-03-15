package sample.kanda.app.structure

/**
 * Created by jcosilva on 3/5/2018.
 */
interface State

data class SUCCESS<out T>(val value: T) : State
data class ERROR(val value: ErrorView) : State
object LOADING : State

