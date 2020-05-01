$(document).ready(function(){
	console.log('commonJs ready!!');
});

$(window).scroll(function (){ 
	let scrollValue = $(document).scrollTop(); 
	(scrollValue > 35)? $('header').css('background-color', '#ffffff') : $('header').css('background-color', 'transparent') 
});