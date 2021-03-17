package de.service

trait EchoService {

  def echo(message: String): String

  def brokenEcho(message: String): Nothing

}
