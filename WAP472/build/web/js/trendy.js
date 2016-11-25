/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
function createTweetDOM(user) {
	var dom = $("<div>", {
		"class" : "tweet"
	}).append($("<div>", {
		"class" : "user"
	}).append($("<img>", {
		"src" : user.userImage,
		"title" : user.userName,
		"alt" : user.userName
	})).append($("<span>", {
		"text" : user.userName
	}))).append($("<div>", {
		"class" : "user-text"
	}).append($("<a>", {
		"text" : user.userText,
		"href" : "https://www.twitter.com/" + user.userId,
		"title" : user.userName,
		"target" : "_blank"
	})));
	return dom;
        }

function caller(){
    var selector=this.attr("id");
    
$.ajax("setcurrentlocation",{
    "data":{
        query:selector
    }
    
}).done(looptweetdom);
}
function looptweetdom(somedata){
    $.each(somedata,function(idx,each){
        createTweetDOM(each);
    })
   
}

$('a').find('nav nav-pills').click(caller);
}
);

