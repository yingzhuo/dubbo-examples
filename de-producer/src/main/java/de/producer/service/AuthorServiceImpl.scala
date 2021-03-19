package de.producer.service

import de.common.domain.Author
import de.service.AuthorService
import de.service.version.Version
import org.apache.dubbo.config.annotation.DubboService

@DubboService(version = Version.Default)
class AuthorServiceImpl extends AnyRef with AuthorService {

  override def get: Author = Author("应卓", "yingzhor@gmail.com")

}