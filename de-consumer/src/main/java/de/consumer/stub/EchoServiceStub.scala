package de.consumer.stub

import de.service.EchoService
import org.slf4j.LoggerFactory

class EchoServiceStub(echoService: EchoService) extends EchoService {

  private val log = LoggerFactory.getLogger(classOf[EchoServiceStub])

  override def echo(message: String): String = {
    log.debug("{} - stub", getClass.getName)
    echoService.echo(message)
  }

  override def brokenEcho(message: String): Nothing = {
    log.debug("{} - stub", getClass.getName)
    echoService.brokenEcho(message)
  }

}
