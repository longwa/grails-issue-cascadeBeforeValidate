package cascadebeforevalidate

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class AuthorSpec extends Specification {

    void "test before validate is called on Author"() {
        when:
        def a = new Author().save(flush: true, failOnError: true)

        then:
        a.name == "Author Name"
    }

    void "test before validate is called on cascade to has-many Book"() {
        when:
        def a = new Author()
        a.addToBooks(new Book())
        a.save(flush: true, failOnError: true)

        then:
        a.name == "Author Name"
        a.books.first()
        a.books.first().name == "Book Name"
    }

    void "test before validate is called on cascade to has-one Publisher"() {
        when:
        def a = new Author(publisher: new Publisher())
        a.save(flush: true, failOnError: true)

        then:
        a.name == "Author Name"
        a.publisher.name == "Publisher Name"
    }
}
