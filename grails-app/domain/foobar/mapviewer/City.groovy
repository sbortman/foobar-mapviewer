package foobar.mapviewer

class City {

  String name
  String country
  Integer population
  Boolean capital
  Double longitude
  Double latitude

  static constraints = {
    name()
    country()
    population()
    capital()
    longitude()
    latitude()
  }
}