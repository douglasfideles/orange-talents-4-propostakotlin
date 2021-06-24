package br.com.zuporange.Proposta

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
class Proposta(@field:NotBlank val nome: String,
               @field:NotBlank val email: String,
               @field:NotBlank @field:Documento val documento: String,
               @field:NotBlank val endereco: String,
               @field:Positive val salario: BigDecimal) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
