package foobar.mapviewer

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CityControllerSpec extends Specification implements ControllerUnitTest<CityController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
