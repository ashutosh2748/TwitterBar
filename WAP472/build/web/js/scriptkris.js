/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
	$(".btn-default").click(getTwitterData);// .trigger('click');
        getTwitterData();
	$('.loader').hide() // Hide it initially
	.ajaxStart(function() {
		$(this).show();
	}).ajaxStop(function() {
		$(this).hide();
	});
});

/* If ajax failed call this method... */
function ajaxFailure(xhr, status, exception) {
	console.log(xhr, status, exception);
}

function activateTweetMenu() {
	$(".query").removeClass("active");
	$("#" + $.cookie("query")).addClass("active");
}

// get tweets from servlet(call API)
function getTwitterData() {
	if (!$.cookie("query")) {
		$.cookie("query", "documentry");
	} else {
		$.cookie("query", $(this).attr("id"));
	}

	$.ajax("getlatesttweets", {
		"type" : "get",
		"data" : {
			"query" : $.cookie("query")
		}
	}).done(dispalyTweets).fail(ajaxFailure);
}

// display tweets coming from API call
function dispalyTweets(json) {
	
        json = JSON.parse(json);
        console.log(json);
	var data = $("#tab-content").empty();
	$.each(json, function(i, user) {
		data.append(createTweetDOM(user));
	});
	activateTweetMenu();
}

// creating Tweet box using jquery ....
function createTweetDOM(user) {
	var dom = $("<div>", {
		"class" : "col-sm-3 mybox"
	}).append($("<div>", {
		"class" : "user "
	}).append($("<img>", {
		"src" : user.imgurl,
		"title" : user.fullname,
		"alt" : user.fullname
	})).append($("<span>", {
		"text" : user.fullname
	}))).append($("<div>", {
		"class" : "user-text"
	}).append($("<a>", {
		"text" : user.text,
		"href" : user.url,
		"title" : user.userName,
		"target" : "_blank"
	})));
	return dom;
}


/*
 * Toggle between adding and removing the "responsive" class to menu when the
 * user clicks on the icon
 */
function myFunction() {
	var x = document.getElementById("myTopnav");
	if (x.className === "menu") {
		x.className += " responsive";
	} else {
		x.className = "menu";
	}
}

