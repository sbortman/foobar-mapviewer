package foobar.mapviewer

import grails.web.servlet.mvc.GrailsParameterMap
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import javax.imageio.ImageIO
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage

import geoscript.geom.Bounds
import geoscript.layer.Shapefile
import geoscript.render.Map as GeoScriptMap
import static geoscript.style.Symbolizers.*

@Slf4j
//@CompileStatic
class WebMappingService {

  def states = new Shapefile('data/statesp020.shp')
  def countries = new Shapefile('data/world_adm0.shp')
  def style = stroke(color: 'yellow') + fill(opacity: 0)

  def getMap( GrailsParameterMap params ) {
    log.info( params as String )

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream()


    Integer width = params.getInt( 'WIDTH' )
    Integer height = params.getInt( 'HEIGHT' )
/*
    BufferedImage image = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB )
    Graphics2D g2d = image.createGraphics()

    g2d.color = Color.red
    g2d.drawRect( 0, 0, width, height )
    g2d.dispose()

    ImageIO.write( image, 'png', outputStream )
*/

    List<Double> coords = params.get( 'BBOX' )?.split( ',' )?.collect { it?.toDouble() }

    def bounds = new Bounds(
      coords[1],
      coords[0],
      coords[3],
      coords[2],
      params.get('CRS')
    )

    countries.style = style
    states.style = style

    def map = new GeoScriptMap(
        fixAspectRatio: false,
        type: 'gif',
        width: width,
        height: height,
        bounds: bounds,
        proj: bounds?.proj,
        layers: [
            states,
            countries
        ]
    )

    map.render( outputStream )
    map.close()

    [ contentType: 'image/png', file: outputStream?.toByteArray() ]
  }
}