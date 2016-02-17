package sbkotlin.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity data class Pessoa(
        @Id @GeneratedValue(strategy = AUTO) var id: Long = 0,
        @NotNull(message = "O nome é obrigatório!") var nome: String = "")