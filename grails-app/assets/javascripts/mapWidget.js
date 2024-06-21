//= require jquery-3.5.1.js
//= require webjars/openlayers/4.6.5/ol.js
//= require_self

class MapWidget {
    constructor(params) {
        const layers = [
            new ol.layer.Tile({
                source: new ol.source.XYZ({
                    url: 'https://mt1.google.com/vt/lyrs=y&x={x}&y={y}&z={z}'
                })
            }),
            new ol.layer.Tile({
                source: new ol.source.TileWMS({
                    url: '/wms',
                    params: {
                    }
                })
            })
        ];

        const map = new ol.Map({
            controls: ol.control.defaults().extend([
                new ol.control.ScaleLine({
                    units: 'degrees'
                })
            ]),
            layers: layers,
            target: 'map',
            view: new ol.View({
                projection: 'EPSG:4326',
                center: [0, 0],
                zoom: 2
            })
        });
    }
}