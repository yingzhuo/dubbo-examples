package de.consumer.stub

import de.common.domain.Author
import de.service.AuthorService
import org.slf4j.LoggerFactory

class AuthorServiceStub(authorService: AuthorService) extends AuthorService {

  private val log = LoggerFactory.getLogger(classOf[AuthorServiceStub])

  override def get: Author = {
    log.debug("{} - stub", getClass.getName)
    authorService.get
  }

}
