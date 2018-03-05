package sample.kanda.app.structure

/**
 * Created by caique on 3/9/18.
 */
sealed class ErrorView

object Generic : ErrorView()
object Connection : ErrorView()
object Response : ErrorView()