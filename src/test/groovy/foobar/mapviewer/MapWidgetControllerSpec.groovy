package foobar.mapviewer

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class MapWidgetControllerSpec extends Specification implements ControllerUnitTest<MapWidgetController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
