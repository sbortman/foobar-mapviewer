package foobar.mapviewer

class HelloController {

    def index() {
        def name = params['name'] ?: 'World'

//        render "Hello ${name} ${new Date()}!"
       [message: "Hello ${name} ${new Date()}!"]
    }
}