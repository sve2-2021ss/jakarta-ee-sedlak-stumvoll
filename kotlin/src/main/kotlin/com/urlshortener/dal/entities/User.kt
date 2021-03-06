package com.urlshortener.dal.entities

import javax.persistence.*
import javax.validation.constraints.NotBlank

const val userNameConstraint = "UserNameUniqueConstraint"

@Entity
@Table(
    name = "ShortUrlUser",
    uniqueConstraints = [UniqueConstraint(columnNames = ["name"], name = userNameConstraint)]
)
class User(
    @field:NotBlank
    var name: String,
    @Enumerated var role: UserRole,
    var password: String,
    @OneToMany @JoinColumn(name = "user_id") var shortUrls: MutableSet<ShortUrl> = mutableSetOf(),
    @Id @GeneratedValue var id: Long? = null
)

enum class UserRole(val type: String) {
    Premium("Premium"),
    Peasant("Free")
}