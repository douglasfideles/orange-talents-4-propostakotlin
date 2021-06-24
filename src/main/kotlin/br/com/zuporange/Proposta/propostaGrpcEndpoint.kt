package br.com.zuporange.Proposta

import br.com.zuporange.PropostaGrpcServiceGrpc
import br.com.zuporange.PropostaRequest
import br.com.zuporange.PropostaResponse
import io.grpc.stub.StreamObserver
import java.math.BigDecimal
import javax.inject.Singleton

@Singleton
class PropostaGrpcEndpoint(val propostaRepository: PropostaRepository) : PropostaGrpcServiceGrpc.PropostaGrpcServiceImplBase() {

    override fun cadastra(request: PropostaRequest, responseObserver: StreamObserver<PropostaResponse>) {

        println("Request ${request.nome}")

        val novaProposta = request.paraProposta()

        val salvarProposta = propostaRepository.save(novaProposta)

        val response = PropostaResponse.newBuilder().setId(salvarProposta.id ?: throw IllegalStateException("valor do id nulo")).build()

        responseObserver.onNext(response)
        responseObserver.onCompleted()

    }
}

fun PropostaRequest.paraProposta() = Proposta (

    nome = this.nome,
    email = this.email,
    documento = this.documento,
    endereco = this.endereco,
    salario = BigDecimal(this.salario)

)