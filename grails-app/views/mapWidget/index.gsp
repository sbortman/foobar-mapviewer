<html>
    <head>
        <title>Map Widget</title>
        <meta name="layout" content="main">
        <asset:stylesheet src="mapWidget.css"/>
    </head>
    <body>
        <div id="content">
            <div id="map"></div>
        </div>
        <asset:javascript src="mapWidget.js"/>
        <asset:script>
        $(document).ready(() => {
            new MapWidget();
         } );
        </asset:script>
        <asset:deferredScripts/>
    </body>
</html>