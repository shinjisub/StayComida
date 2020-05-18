function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
 
function dateFormat(format, date) {
	var d = new Date(date);
	var weekName = ["일", "월", "화", "수", "목", "금", "토"];
	return format.replace(/(yyyy|yy|mm|dd|e|H|h|i|s|ap)/gi, function($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear(); // 년도(4자리)
            case "yy": return d.getYear(); // 년도 (2자리)
            case "mm": return ((d.getMonth()+1) < 10 ? '0'+(d.getMonth()+1) : (d.getMonth()+1)); // 월
            case "dd": return (d.getDate() < 10 ? '0'+d.getDate() : d.getDate()); // 일
            case "e": return weekName[d.getDay()]; // 요일
            case "H": return d.getHours(); // 시(0~23)
            case "h": return ((h = d.getHours() % 12) ? h : 12); // 시(0~12)
            case "i": return d.getMinutes(); // 분
            case "s": return d.getSeconds(); // 초
            case "ap": return d.getHours() < 12 ? "오전" : "오후"; // 오전, 오후
            default: return $1;
        }
    });
}

function selectDefaultValue() {
	var attr = 'default-value';
	var selects = $('select['+attr+']');
	if (selects.length > 0) {
		$.each(selects, function (index, select) { 
			var value = $(this).attr(attr);
			$(this).val(value);
			$(this).change();
		})
	}
}

function inputValidation() {
	$(document).on('keyup', '[validation]', function(){
	    const validation = $(this).attr('validation');
	    if (validation) {
	    	const self = $(this);
	    	const value = $.trim(self.val());
	    	const validationArr = validation.split('|');
	        validationArr.map(vali => {
	            switch (vali) {
	                case 'onlyNum':
	                    self.val(value.replace(/[^0-9]/g, ""));
	                    break;
	                case 'onlyEng':
	                    self.val(value.replace(/[^a-zA-Z]/g, ""));
	                    break;
	                case 'onlyPrice': 
	                    self.val(numberWithCommas(value.replace(/[^0-9]/g, "")));
	                    break;
	                default:
	                    if (vali.indexOf('max') !== -1) {
	                        var max = parseInt(vali.replace('max', ''));
	                        self.attr('maxlength', max);
	                        if (parseInt(value.length) > parseInt(max)) {
	                            self.val(value.substring(0, max));
	                        }
	                    }
	                    break;
	            }
	        });
	    }
	});
}

function datepickers() {
	$('.datePicker').datepicker({
	    format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
	    startDate: '0d',	//달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
	    autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
	    calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
	    clearBtn : false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
	    datesDisabled : [],//선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
	    daysOfWeekDisabled : [],	//선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
	    daysOfWeekHighlighted : [], //강조 되어야 하는 요일 설정
	    disableTouchKeyboard : false,	//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
	    immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
	    multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
	    multidateSeparator :",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
	    templates : { 
	        leftArrow: '&laquo;',
	        rightArrow: '&raquo;'
	    }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
	    showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
	    title: "테스트",	//캘린더 상단에 보여주는 타이틀
	    todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
	    toggleActive : true,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
	    weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
	    language : "kr"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
	});
}

function addressSearch(id1, id2, id3) {
	new daum.Postcode({
        oncomplete: function(data) {
        	$("#"+id1).val(data.zonecode);
        	$("#"+id2).val(data.address);
        	$("#"+id3).focus();
        }
    }).open();
}

function buttonType() {
	const attr = 'button-type';
	$(document).on('click', '['+attr+']', function(){
		const self = $(this);
		const attrValue = self.attr(attr);
		switch (attrValue) {
			case 'submit':
				const formId = self.attr('form-id');
				const submitUrl = self.attr('submit-url');
				const submitType = self.attr('submit-type') ? self.attr('submit-type') : 'POST';
				if (!formId || !submitUrl) {
					console.error('submit 버튼의 필수 속성이 모두 설정되지 않았습니다.[form-id, submit-url]');
					return false;
				}
				const form = $('#'+formId);
				const redirect = form.attr('redirect-url') ? form.attr('redirect-url') : false;
				if (form.length == 0) {
					console.error('submit 버튼의 form-id 속성이 잘못 설정되었습니다.[form-id]');
					return false;
				}
				const data = form.serializeArray();
				let submitData = {};
				if (data.length > 0) {
					data.map(item => {
						submitData[item.name] = item.value;
					});
				}
				$.ajax({
				    url: submitUrl,
				    type: submitType,
				    data: data,
				    dataType: "json",
				    async: false,
				    success: function (resp) {
				    	$('.vali-fail-message').remove();
				    	$('.vali-fail').removeClass('vali-fail');
				    	
				    	if (resp.resultData.alert) {
			    			alert(resp.resultData.alert);
			    		}
				    	
				    	if (parseInt(resp.resultCode, 10) === 200) {	
				    		if (resp.resultData.redirect) {
				    			location.href = resp.redirect;
				    		} else if (redirect) {
				    			location.href = redirect;
				    		} else {
				    			history.back();
				    		}
				    	} else if (parseInt(resp.resultCode, 10) === 100) {
				    		resp.validationFailList.map(item => {
				    			const input = $('[name="' + item.name + '"]');
				    			if (input.length > 0 && !input.hasClass("vali-fail")) {
				    				input.addClass("vali-fail");
				    				input.after('<small class="form-text text-muted vali-fail-message w100p dp-block">' + item.message + '</small>');
				    			}
				    		});
				    	}
				    }
				});
				break;
			case 'go':
				const goUrl = self.attr('go-url');
				if (!goUrl) {
					console.error('go 버튼의 필수 속성이 모두 설정되지 않았습니다.[go-url]');
					return false;
				}
				location.href = goUrl;
				break;
			case 'back':
				history.back();
				break;
			case 'ajax':
				const ajaxType = self.attr('ajax-type') ? self.attr('ajax-type') : 'POST';
				const ajaxUrl = self.attr('ajax-url');
				const ajaxData = self.attr('ajax-data');
				if (!ajaxUrl) {
					console.error('ajax 버튼의 필수 속성이 모두 설정되지 않았습니다.[ajax-url]');
					return false;
				}
				
				let ajaxDataObj = {};
				if (ajaxData) {
					const ajaxDataArr = ajaxData.split('&');
					ajaxDataArr.map(item => {
						const itemArr = item.split('=');
						ajaxDataObj[itemArr[0]] = itemArr[1];
					});
				}
				$.ajax({
				    url: ajaxUrl,
				    type: ajaxType,
				    data: ajaxDataObj,
				    dataType: "json",
				    async: false,
				    success: function (resp) {
				    	if (resp.resultData.alert) {
			    			alert(resp.resultData.alert);
			    		}
				    	if (parseInt(resp.resultCode, 10) === 200) {
				    		const redirect = self.attr('redirect-url') ? self.attr('redirect-url') : false;
					    	if (resp.resultData.redirect) {
				    			location.href = resp.redirect;
				    		} else if (redirect) {
				    			location.href = redirect;
				    		} else {
				    			location.reload();
				    		}
				    	} else {
				    		console.error("ajax errorCode:"+resp.resultCode);
				    	}
				    }
				});
				break;
		}
	});
}

function adminLimitSelect() {
	$(document).on('change', '.admin-limit-select', function(){
		$(this).closest("form").submit();
	});
}

function adminSearchWord() {
	$(document).on('keyup', '.admin-search-word', function(key){
        if (key.keyCode == 13) {
        	$(this).closest("form").submit();
        }
	});
}

$(document).ready(function(){
	selectDefaultValue();
	inputValidation();
//	datepickers();
	buttonType();
	adminLimitSelect();
	adminSearchWord();
});
