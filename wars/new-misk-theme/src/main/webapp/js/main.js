AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
		if (themeDisplay.getLanguageId() =="ar_SA")
			{
			  $('#lang_selector').attr('lang', 'en');
			  $("#lang_selected").html("<p>AR</p>");
		    }
		 if (themeDisplay.getLanguageId() =="en_US")
			{
			  $('#lang_selector').attr('lang', 'ar');
			  $("#lang_selected").html("<p>EN</p>");
		    }
		$('#lang_selector').click ( function (){
		if ($( this ).attr('lang') == 'en')
		{	window.location=themeDisplay.getCDNBaseURL() + '/c/portal/update_language?p_l_id='+ themeDisplay.getPlid() +'&redirect='+ Liferay.currentURL +'&languageId=en_US';
		}
		else if ($( this ).attr('lang') == 'ar')
		{	window.location=themeDisplay.getCDNBaseURL() + '/c/portal/update_language?p_l_id='+ themeDisplay.getPlid() +'&redirect='+ Liferay.currentURL +'&languageId=ar_SA';
		}
	 });
	}
	
);

$(document).ready(function(){
	  $(".lang-flag").click(function(){
		  if ($( this ).attr('id') == 'en')
			{	window.location=themeDisplay.getCDNBaseURL() + '/c/portal/update_language?p_l_id='+ themeDisplay.getPlid() +'&redirect='+ Liferay.currentURL +'&languageId=en_US';
			}
			else if ($( this ).attr('id') == 'ar')
			{	window.location=themeDisplay.getCDNBaseURL() + '/c/portal/update_language?p_l_id='+ themeDisplay.getPlid() +'&redirect='+ Liferay.currentURL +'&languageId=ar_SA';
			}
	  });
	  $("ul.lang-list li").click(function(){
	    $("ul.lang-list li").removeClass("selected");
	    $(this).addClass("selected");
	    if($(this).hasClass('lang-en')){
	      $(".language-dropdown").find(".lang-flag").addClass("lang-en").removeClass("lang-es").removeClass("lang-pt");
	      $("#lang_selected").html("<p>EN</p>")
	    }else if($(this).hasClass('lang-pt')){
	      $(".language-dropdown").find(".lang-flag").addClass("lang-pt").removeClass("lang-es").removeClass("lang-en");
	    $("#lang_selected").html("<p>PT</p>")
	    }else{
	      $(".language-dropdown").find(".lang-flag").addClass("lang-es").removeClass("lang-en").removeClass("lang-pt");
	      $("#lang_selected").html("<p>ES</p>")
	    }
	    $(".language-dropdown").removeClass("open");
	  });
	})
