var os = function () {
  var ua = navigator.userAgent,
    isWindowsPhone = /(?:Windows Phone)/.test(ua),
    isSymbian = /(?:SymbianOS)/.test(ua) || isWindowsPhone,
    isAndroid = /(?:Android)/.test(ua),
    isFireFox = /(?:Firefox)/.test(ua),
    isChrome = /(?:Chrome|CriOS)/.test(ua),
    isTablet = /(?:iPad|PlayBook)/.test(ua) || (isAndroid && !/(?:Mobile)/.test(ua)) || (isFireFox && /(?:Tablet)/.test(ua)),
    isPhone = /(?:iPhone)/.test(ua) && !isTablet,
    isPc = !isPhone && !isAndroid && !isSymbian;
  return {
    isTablet: isTablet,
    isPhone: isPhone,
    isAndroid: isAndroid,
    isPc: isPc
  }
}()

function getCookie(name) {
	var value = "; " + document.cookie;
	var parts = value.split("; " + name + "=");
	if (parts.length == 2)
		return parts.pop().split(";").shift();
}

function getToken() {
	let value = getCookie('UM_distinctid');
	if (!value) {
		return defaultToken;
	}
	return value.substring(value.length - 6).toUpperCase();
}



// æ–‡ç« æ‰€åœ¨å®¹å™¨çš„é€‰æ‹©å™¨
var articleSelector = 'article.post.container.need';

// DOM å®Œå…¨å°±ç»ªæ—¶æ‰§è¡Œ
$(function() {
	// æ‰¾åˆ°æ–‡ç« æ‰€åœ¨çš„å®¹å™¨
	var $article = $(articleSelector);
	if ($article.length > 0) {
		// æ–‡ç« çš„å®žé™…é«˜åº¦
		var article = $article[0], height = article.clientHeight;
		// æ–‡ç« éšè—åŽçš„é«˜åº¦
		var halfHeight = height * 0.8;
		
		// ç¯‡å¹…çŸ­ä¸€ç‚¹çš„æ–‡ç« å°±ä¸éœ€è¦è§£é”äº†
		if (os.isPc && halfHeight > 800) {
			
			// èŽ·å–å£ä»¤
			var token = getToken();
			$('.asb-post-01').find('.token').text(token);
			
var _lock = function() {
	$article.css('height', halfHeight + 'px');
	$article.addClass('lock');
	$('.asb-post-01').css('display', 'block');
}

var _unlock = function() {
	$article.css('height', 'initial');
	$article.removeClass('lock');
	$('.asb-post-01').css('display', 'none');
}

// æŸ¥è¯¢åŽç«¯çš„ç»“æžœ
var _detect = function() {
	console.log('Detecting Token', token);
	$.ajax({
		url : 'http://ityouknow.com/jfinal/wx/',
		method : 'GET',
		data : {
			token : token
		},
		success : function(data) {
			console.log('locked', data.locked);

			if (data.locked === true) {
				_lock();
			} else {
				_unlock();
			}
		},
		error : function(data) {
			_unlock();
		}
	})
}

_detect();
setInterval(function() {
	_detect();
}, 5000);
		}
	}
});