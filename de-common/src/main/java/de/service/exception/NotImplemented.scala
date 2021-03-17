package de.service.exception

class NotImplemented(message: String = "暂未实现") extends RuntimeException(message)

object NotImplemented {

  def apply(message: String = null): NotImplemented = new NotImplemented(message)

}
