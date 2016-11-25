/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global google */

"use strict";
   // navigator.geolocation.getCurrentPosition(setClientLocation);
 //  var latitude,longitude;
function setClientLocation(latitude,longitude){
    if(latitude==0)latitude=position.coords.latitude;
    if(longitude==0)longitude=position.coords.longitude;
    
    
$.ajax("setcurrentlocation",{
    "data":{
        "latitude":latitude,
        "longitude":longitude
    }
    
}).done(setTrends);
//$.post()
function setTrends(some){
    var trends=JSON.parse(some);
    $("#trends").empty();
    for(var i=0;i<trends.trends.length;i++){
    $("#trends").append($("<li>").append(
            
            $('<a>').attr({
                href:trends.trends[i].url
                    })
                    .html(trends.trends[i].name))
        
            );

    }
}
}


$(function(){
   
var x = $('#something');
var getLocation=function () {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        x.add("Geolocation is not supported by this browser.");
    }
};
var showPosition=function showPosition(position) {
    x.replaceWith("<br>Latitude: " + position.coords.latitude + 
    "<br>Longitude: " + position.coords.longitude); 
};
$("#locate").click(function(){
    getLocation();
    navigator.geolocation.getCurrentPosition(setClientLocation);
    }
);

});






function initMap() {
    //38.2494° N, 122.0400° W



  var uluru = {lat: 41, lng: -92};
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 10,
    center: uluru
  });
  var markers=[];
 /* var marker = n=ew google.maps.Marker({
    position: uluru,
    map: map
  });
  
  /*var infowindow = new google.maps.InfoWindow({
    content: null
  });*/

  
    
    /* @map mover
   * map.addListener('center_changed', function() {
          // 3 seconds after the center of the map has changed, pan back to the
          // marker.
          window.setTimeout(function() {
            map.panTo(marker.getPosition());
          }, 3000);
        });
        */

       /* marker.addListener('click', function() {
          map.setZoom(8);
          map.setCenter(marker.getPosition());
        });
        */
         map.addListener('click', function(e) {
                // $('#morething').empty().append(e.latLng.toString());
                clearMarkers();
                 var latitude=e.latLng.lat;
                 var longitude=e.latLng.lng;
    
                     
                     placeMarkerAndPanTo(e.latLng, map);
                     setClientLocation(latitude,longitude);
                 }
                 );
         var content=$("#trends")[0];
  
  var infowindow = new google.maps.InfoWindow({
    content: content
  });
  function setMapOnAll(map) {
		for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(map);
		}
	}

	function clearMarkers() {
		setMapOnAll(null);
	}
        

function placeMarkerAndPanTo(latLng, map) {
    
		//showInfo(location);
  var marker = new google.maps.Marker({
    position: latLng,
    map: map
  }
          
            
            );
    marker.setPosition(latLng);
		marker.setMap(map);
		markers.push(marker);
  
  
  map.panTo(latLng);
  infowindow.setContent(content);
  infowindow.open(map, marker);
}
  
  

}

