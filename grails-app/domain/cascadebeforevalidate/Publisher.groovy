package cascadebeforevalidate

class Publisher {
    String name

    def beforeValidate() {
        name = "Publisher Name"
    }
}
