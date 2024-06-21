package foobar.mapviewer

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class WmsControllerSpec extends Specification implements ControllerUnitTest<WmsController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
