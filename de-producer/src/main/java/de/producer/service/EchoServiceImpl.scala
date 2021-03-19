package de.producer.service

import de.service.EchoService
import de.service.exception.NotImplemented
import de.service.version.Version
import org.apache.dubbo.config.annotation.DubboService

@DubboService(version = Version.Default)
class EchoServiceImpl extends AnyRef with EchoService {

  override def echo(message: String): String = message

  override def brokenEcho(message: String): Nothing = throw NotImplemented()

}
