package foobar.mapviewer

import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.context.MessageSource

@CompileStatic
@Transactional
@Slf4j
class CsvLoaderService {
  MessageSource messageSource

  def loadCsvFile( File csvFile ) {
    csvFile?.eachLine { String line ->
      List<String> tokens = line?.split( ',' ) as List<String>

      City city = new City(
          name: tokens[ 0 ],
          country: tokens[ 1 ],
          population: tokens[ 2 ]?.toInteger(),
          capital: tokens[ 3 ] == 'Y',
          longitude: tokens[ 4 ].toDouble(),
          latitude: tokens[ 5 ]?.toDouble()
      )

      if ( !city.save() ) {
        city?.errors?.allErrors?.each {
          log.error( messageSource.getMessage( it, Locale.default ) )
        }
      }
    }
  }
}