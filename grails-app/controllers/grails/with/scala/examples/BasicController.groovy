package grails.with.scala.examples

import me.aaronramirez.ScalaObject

class BasicController {

    def index() {
        render(contentType: 'text/json') {
            [message: new ScalaObject().message()]
        }
    }
}
