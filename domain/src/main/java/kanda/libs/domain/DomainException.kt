package kanda.libs.domain

/**
 * Created by jcosilva on 3/5/2018.
 */

sealed class DomainException : Throwable() {
    object SerializationException : DomainException()
    object TimeoutDomainException : DomainException()
    object ServerException : DomainException()
    object ClientException : DomainException()
    object GenericException : DomainException()
}


