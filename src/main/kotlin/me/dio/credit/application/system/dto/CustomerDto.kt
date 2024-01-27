package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field: NotEmpty(message = "Invalid First Name") val firstName: String,
    @field: NotEmpty(message = "Invalid Last Name") val lastName: String,
    @field: NotEmpty(message = "Invalid CPF")
    @field: CPF(message = "this invalid CPF") val cpf: String,
    @field: NotNull(message = "Invalid Income") val income: BigDecimal,
    @field:Email(message = "Invalid Email")
    @field: NotEmpty(message = "Invalid Email") val email: String,
    @field: NotEmpty(message = "Invalid Password") val password: String,
    @field: NotEmpty(message = "Invalid ZipCode") val zipCode: String,
    @field: NotEmpty(message = "Invalid street") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
