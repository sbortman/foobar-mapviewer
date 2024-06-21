package foobar.mapviewer


class WmsController {
  WebMappingService webMappingService

  def index() {
    render webMappingService.getMap( params )
  }
}