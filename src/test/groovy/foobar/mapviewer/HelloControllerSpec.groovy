package foobar.mapviewer

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class HelloControllerSpec extends Specification implements ControllerUnitTest<HelloController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
