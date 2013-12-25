<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%pageContext.setAttribute("path", request.getContextPath());%>
<%pageContext.setAttribute("locale", request.getLocale());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的地图应用</title>
<script type="text/javascript" src="${path}/resources/OpenLayers/OpenLayers.js"></script>
<script type="text/javascript">
	var map =null;
	function initMap(){
		 var bounds = new OpenLayers.Bounds(  //地图区域范围  
                 74.137, 6.319,  
                 135.086, 53.558  
             );
		var options={
					controls:[new OpenLayers.Control.KeyboardDefaults()],
				    maxExtent: bounds,  
                    maxResolution: 0.23808203125,  
                    projection: "EPSG:4326",  
                    numZoomLevels: 21,   
                    units: 'degrees'
				};//添加键盘控制的控件
				format = 'image/png'; 
				map = new OpenLayers.Map('map',options);//创建地图对象map,这里的map是用来显示的div的id
				var size = new OpenLayers.Size(400,400);
				//var wms = new OpenLayers.Layer.Image('b','img/maptest.jpg',bounds,size);//创建image类型的图层
			
				      /**********************加载图层 开始*******************************/  
                tiled = new OpenLayers.Layer.WMS(  //图层组  
                    "基础图层", "http://localhost:8080/geoserver/wms",  
                    {  
                        height: '330',  
                        width: '698',  
                        layers: 'roads',  
                        styles: '',  
                        srs: 'EPSG:4326',  
                        format: format,  
                        tiled: 'true',  
                        tilesOrigin : map.maxExtent.left + ',' + map.maxExtent.bottom  
                    },  
                    {  
                        buffer: 0,  
                        displayOutsideMaxExtent: true  
                    }   
                ); 
                  
                places = new OpenLayers.Layer.WMS(  //图层组  
                    "基础图层", "http://localhost:8080/geoserver/wms",  
                    {  
                        height: '330',  
                        width: '698',  
                        layers: 'places',  
                        styles: '',  
                        srs: 'EPSG:4326',  
                        format: format,  
                        tiled: 'true',  
                        tilesOrigin : map.maxExtent.left + ',' + map.maxExtent.bottom  
                    },  
                    {  
                        buffer: 0,  
                        displayOutsideMaxExtent: true  
                    }   
                ); 
                  
                osm = new OpenLayers.Layer.OSM("OSMMM");
				//map.addLayer(tiled);//将图层添加到地图里面
				//map.addLayer(places);//将图层添加到地图里面
				//map.setBaseLayer(tiled);//设置图层为基层
				map.addLayer(osm);//将图层添加到地图里面
				map.setBaseLayer(osm);//设置图层为基层
				map.zoomToMaxExtent();
				
				//下面几个事添加map控件的，根据自己需要添加
				map.addControl(new OpenLayers.Control.PanZoomBar({
					position:new OpenLayers.Pixel(2,15)
				}));
				map.addControl(new OpenLayers.Control.ScaleLine());
				map.addControl(new OpenLayers.Control.OverviewMap());
				map.addControl(new OpenLayers.Control.Navigation());
	}
</script>
</head>
<body onload="initMap();">
wwwwwwwwwwwwww----${path}---
${path}
<div id="map" style="width:1024px;height:768px;"></div>
</body>
</html>