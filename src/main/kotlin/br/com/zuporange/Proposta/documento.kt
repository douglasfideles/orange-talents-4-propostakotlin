package br.com.zuporange.Proposta

import org.hibernate.validator.constraints.CompositionType
import org.hibernate.validator.constraints.ConstraintComposition
import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import java.lang.annotation.Documented
import javax.validation.Constraint
import javax.validation.Payload
import javax.validation.ReportAsSingleViolation
import kotlin.reflect.KClass

@CPF
@ConstraintComposition(CompositionType.OR)
@CNPJ
@ReportAsSingleViolation
@Constraint(validatedBy = [])
@Documented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Documento (

    val message: String = "Documento invalido",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []

)
