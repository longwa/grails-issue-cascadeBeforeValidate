package cascadebeforevalidate

class Book {
    String name

    static belongsTo = [
        author: Author
    ]

    def beforeValidate() {
        name = "Book Name"
    }
}
