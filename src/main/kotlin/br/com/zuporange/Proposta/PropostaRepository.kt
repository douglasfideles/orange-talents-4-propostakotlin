package br.com.zuporange.Proposta

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PropostaRepository : JpaRepository<Proposta, Long>
