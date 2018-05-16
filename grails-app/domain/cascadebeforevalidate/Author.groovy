package cascadebeforevalidate

class Author {
    String name
    Publisher publisher

    static hasMany = [books: Book]

    def beforeValidate() {
        name = "Author Name"
    }

    static constraints = {
        publisher(nullable: true)
    }

//    static mapping = {
//        publisher(cascade: 'all')
//    }
}
