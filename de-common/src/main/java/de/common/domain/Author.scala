package de.common.domain

case class Author(name: String, email: String = null) extends AnyRef with Serializable

object Author {
  val BillYing: Author = Author("Bill YING", "yingzhor@gmail.com")
}
