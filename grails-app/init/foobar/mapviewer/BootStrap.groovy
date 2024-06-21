package foobar.mapviewer

class BootStrap {
  CsvLoaderService csvLoaderService

  def init = { servletContext ->
    if ( City.count() == 0 ) {
//      csvLoaderService.loadCsvFile( 'data/cities.csv' as File )
      csvLoaderService?.loadCsvFile( new File( 'data/cities.csv' ) )
    }
  }

  def destroy = {
  }
}