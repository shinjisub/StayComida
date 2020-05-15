<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/fr/common.jspf" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${projectNm}</title>
</head>

<body id="page-top" class="regular-navigation">


    <div class="master-wrapper">
        <div class="preloader">
            <div class="preloader-img">
            	<span class="loading-animation animate-flicker"><img src="${contextPath}/resources/Front_Temp/img/loading.GIF" alt="loading" /></span>
            </div>
        </div>

        <!-- Header -->
		<%@ include file="/WEB-INF/views/common/fr/header.jspf" %>
		<!-- /Header -->
		
		<header id="headerwrap" class="backstretched fullheight">
		    <div class="container-fluid fullheight">
		        <div class="vertical-center row">
		        	<h3 class="fontC_W">
		        		솔직한 리뷰...</br>
						음식종류별 평점...</br>
		       		</h3>
						<input type="text" id="search-input" name="search-input" class="text-left heading-font" style=" font-size:21px; width:650px; height: 52px; border-radius: 9px;" placeholder="가게명 또는 음식명 찾기...">
						<a href="javascript::;" id="search-btn" style="color: #ffffff;"><i class="fa fa-search"></i></a>
						<ul class="list-group searchArea " id="keyWordList"></ul>
		        </div>
		    </div>
		</header>
		
        <section id="the-menu">
            <div class="section-inner">

                 <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center mb100">
                            <h2 class="section-heading">맛집 리스트</h2>
                            <!-- <hr class="thin-hr"> -->
                            <h3 class="section-subheading secondary-font">Your tastebuds will thank you.</h3>
                        </div>
                    </div>
                </div>
                
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 wow fadeIn">
                            <h2 class="mb50"><span class="heading-font text-uppercase">고기 맛집 TOP <i style="color: red;">5</i></span></h2>
                            <div class="food-menu-item">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <img src="${contextPath}/resources/Front_Temp/img/food/meal4.jpg" class="img-responsive">
                                    </div>
                                    <div class="col-xs-9">
                                        <h3>삼진 식당 (<span class="theme-accent-color">평점 4.5</span>)</h3>
                                        <p>No phone no lights no motor car not a single luxury. Like Robinson Crusoe it's primitive as can be. Like Robinson Crusoe it's primitive as can be</p>
                                    </div>
                                </div>
                            </div>
                        <!-- 
                            <div class="food-menu-item">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <img src="${contextPath}/resources/Front_Temp/img/food/meal1.jpg" class="img-responsive">
                                    </div>
                                    <div class="col-xs-9">
                                        <h3>Lorem Ipsum <span class="theme-accent-color">$8.95</span></h3>
                                        <p>No phone no lights no motor car not a single luxury. Like Robinson Crusoe it's primitive as can be. Like Robinson Crusoe it's primitive as can be</p>
                                    </div>
                                </div>
                            </div>
                        -->
                        </div>

                        <div class="col-md-6 wow fadeIn">
                            <h2 class="mb50"><span class="heading-font text-uppercase">파스타 맛집 TOP <i style="color: red;">5</i></span></h2>
                            <div class="food-menu-item">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <img src="${contextPath}/resources/Front_Temp/img/food/meal3.jpg" class="img-responsive">
                                    </div>
                                    <div class="col-xs-9">
                                        <h3>토파 (<span class="theme-accent-color">평점 2.5</span>)</h3>
                                        <p>No phone no lights no motor car not a single luxury. Like Robinson Crusoe it's primitive as can be. Like Robinson Crusoe it's primitive as can be</p>
                                    </div>
                                </div>
                            </div>
                        <!--    
                            <div class="food-menu-item">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <img src="${contextPath}/resources/Front_Temp/img/food/meal5.jpg" class="img-responsive">
                                    </div>
                                    <div class="col-xs-9">
                                        <h3>Lorem Ipsum <span class="theme-accent-color">$8.95</span></h3>
                                        <p>No phone no lights no motor car not a single luxury. Like Robinson Crusoe it's primitive as can be. Like Robinson Crusoe it's primitive as can be</p>
                                    </div>
                                </div>
                            </div>
                        -->
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="dark-wrapper opaqued parallax" data-parallax="scroll" data-image-src="${contextPath}/resources/Front_Temp/img/bg/bg4.jpg" data-speed="0.8">
            <div class="section-inner">
                 <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center mb100">
                            <h2 class="section-heading">Our <span class="theme-accent-color">Acclaimed</span> Chefs</h2>
                            <hr class="thin-hr">
                            <h3 class="section-subheading secondary-font">Dedicated to excellence.</h3>
                        </div>
                    </div>
                </div>
                <div class="wow fadeIn" data-wow-delay="0.2s">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <ul class="owl-carousel-paged testimonial-owl wow fadeIn list-unstyled" data-items="3" data-items-tablet="[768,2]" data-items-mobile="[479,1]">
                                    <li>
                                        <div class="row hover-item">
                                            <div class="col-xs-12">
                                                <img src="${contextPath}/resources/Front_Temp/img/team/1.jpg" class="img-responsive smoothie" alt="">
                                            </div>
                                            <div class="col-xs-12 overlay-item-caption smoothie"></div>
                                            <div class="col-xs-12 hover-item-caption smoothie">
                                                <div class="vertical-center">
                                                    <h3 class="smoothie"><a href="single-portfolio.html" title="view project">John Doe</a></h3>
                                                    <ul class="smoothie list-inline social-links wow fadeIn" data-wow-delay="0.2s">
                                                        <li>
                                                            <a href="#"><i class="fa fa-twitter"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-pinterest"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-dribbble"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-behance"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-linkedin"></i></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <span class="col-xs-12 theme-accent-color-bg hover-bar"></span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="row hover-item">
                                            <div class="col-xs-12">
                                                <img src="${contextPath}/resources/Front_Temp/img/team/2.jpg" class="img-responsive smoothie" alt="">
                                            </div>
                                            <div class="col-xs-12 overlay-item-caption smoothie"></div>
                                            <div class="col-xs-12 hover-item-caption smoothie">
                                                <div class="vertical-center">
                                                    <h3 class="smoothie"><a href="single-portfolio.html" title="view project">Barry Scott</a></h3>
                                                    <ul class="smoothie list-inline social-links wow fadeIn" data-wow-delay="0.2s">
                                                        <li>
                                                            <a href="#"><i class="fa fa-twitter"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-pinterest"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-dribbble"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-behance"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-linkedin"></i></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <span class="theme-accent-color-bg hover-bar"></span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="row hover-item">
                                            <div class="col-xs-12">
                                                <img src="${contextPath}/resources/Front_Temp/img/team/3.jpg" class="img-responsive smoothie" alt="">
                                            </div>
                                            <div class="col-xs-12 overlay-item-caption smoothie"></div>
                                            <div class="col-xs-12 hover-item-caption smoothie">
                                                <div class="vertical-center">
                                                    <h3 class="smoothie"><a href="single-portfolio.html" title="view project">Tom Smooth</a></h3>
                                                    <ul class="smoothie list-inline social-links wow fadeIn" data-wow-delay="0.2s">
                                                        <li>
                                                            <a href="#"><i class="fa fa-twitter"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-pinterest"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-dribbble"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-behance"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-linkedin"></i></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <span class="theme-accent-color-bg hover-bar"></span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="row hover-item">
                                            <div class="col-xs-12">
                                                <img src="${contextPath}/resources/Front_Temp/img/team/4.jpg" class="img-responsive smoothie" alt="">
                                            </div>
                                            <div class="col-xs-12 overlay-item-caption smoothie"></div>
                                            <div class="col-xs-12 hover-item-caption smoothie">
                                                <div class="vertical-center">
                                                    <h3 class="smoothie"><a href="single-portfolio.html" title="view project">Harvey Wallace</a></h3>
                                                    <ul class="smoothie list-inline social-links wow fadeIn" data-wow-delay="0.2s">
                                                        <li>
                                                            <a href="#"><i class="fa fa-twitter"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-pinterest"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-dribbble"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-behance"></i></a>
                                                        </li>
                                                        <li>
                                                            <a href="#"><i class="fa fa-linkedin"></i></a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <span class="theme-accent-color-bg hover-bar"></span>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="dark-wrapper opaqued parallax" data-parallax="scroll" data-image-src="${contextPath}/resources/Front_Temp/img/bg/bg10.jpg" data-speed="0.8">
            <div class="section-inner">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center mb100">
                            <h2 class="section-heading">Our <span class="theme-accent-color">Happy</span> Customers</h2>
                            <hr class="thin-hr">
                            <h3 class="section-subheading secondary-font">Satisfaction, everytime.</h3>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <ul class="owl-carousel-paged testimonial-owl wow fadeIn list-unstyled" data-items="1" data-items-desktop="[1200,1]" data-items-desktop-small="[980,1]" data-items-tablet="[768,1]" data-items-mobile="[479,1]">
                                <li>
                                    <div class="row">
                                        <div class="col-xs-8 col-xs-offset-2 item-caption">
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <img src="${contextPath}/resources/Front_Temp/img/team/small1.jpg" class="img-responsive testimonial-author" alt="">
                                                </div>
                                                <div class="col-sm-10">                                                
                                                    <h4>Charles Davies</h4>
                                                    <p>Compellingly customize highly efficient outsourcing with premium quality vectors. Conveniently target customer directed relationships after highly efficient process improvements.</p>
                                                    <ul class="list-inline">
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="row">
                                        <div class="col-xs-8 col-xs-offset-2 item-caption">
                                            <div class="row">
                                                <div class="col-sm-2">
                                                    <img src="${contextPath}/resources/Front_Temp/img/team/small1.jpg" class="img-responsive testimonial-author" alt="">
                                                </div>
                                                <div class="col-sm-10">                                                
                                                    <h4>Charles Davies</h4>
                                                    <p>Compellingly customize highly efficient outsourcing with premium quality vectors. Conveniently target customer directed relationships after highly efficient process improvements.</p>
                                                    <ul class="list-inline">
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                        <li><i class="fa fa-star theme-accent-color"></i></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="dark-wrapper opaqued parallax" data-parallax="scroll" data-image-src="${contextPath}/resources/Front_Temp/img/bg/bg1.jpg" data-speed="0.8">
            <div class="section-inner">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center mb100">
                            <h2 class="section-heading">Book <span class="theme-accent-color">Your</span> Table</h2>
                            <hr class="thin-hr">
                            <h3 class="section-subheading secondary-font">Satisfaction, everytime.</h3>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row mb100"> 
                        <!-- Address, Phone & Email -->
                        <div class="col-md-5 col-md-offset-1 wow fadeIn">
                            <h3 class="mb30">Address</h3>
                            <p class="lead">Florence Building</p>
                            <p class="lead">Kings Square<br>
                            London, LDN1 23 </p>
                            <p class="lead">+448754 658 048<br>
                        </div>

                        <div class="col-md-5 col-sm-7 wow fadeIn">
                            <h3 class="mb30">Opening Times</h3>
                            <div class="row">
                              <div class="col-xs-5">
                                <ul class="list-unstyled weekdays">
                                  <li>Monday</li>
                                  <li>Tuesday</li>
                                  <li>Wednesday</li>
                                  <li>Thursday</li>
                                  <li>Friday</li>
                                  <li>Saturday</li>
                                  <li>Sunday</li>
                                </ul>
                              </div>
                              <div class="col-xs-7">
                                <ul class="list-unstyled">
                                  <li>11:00 AM - 11:00 PM</li>
                                  <li>11:00 AM - 11:00 PM</li>
                                  <li>11:00 AM - 11:00 PM</li>
                                  <li>11:00 AM - 11:00 PM</li>
                                  <li>11:00 AM - 1:00 AM</li>
                                  <li>11:00 AM - 1:00 AM</li>
                                  <li>11:00 AM - 1:00 AM</li>
                                </ul>
                              </div>
                            </div>
                        </div>                
                    </div>

                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <div class="row">
                                <div id="message" class="col-md-12"></div>
                                <form method="post" action="sendemail.php" id="contactform" class="form-group main-contact-form col-md-12 wow fadeIn" data-wow-delay="0.2s">
                                    <input type="text" class="form-control col-md-4" name="name" placeholder="Your Name *" id="name" required data-validation-required-message="Please enter your name." />
                                    <input type="text" class="form-control col-md-4" name="email" placeholder="Your Email *" id="email" required data-validation-required-message="Please enter your email address." />
                                    <input type="text" class="form-control col-md-4" name="website" placeholder="Your URL *" id="website" required data-validation-required-message="Please enter your web address." />
                                    <textarea name="comments" class="form-control" id="comments" placeholder="Your Message *" required data-validation-required-message="Please enter a message."></textarea>
                                    <input class="btn btn-primary btn-white mt30 pull-right" type="submit" name="submit" value="Submit" />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    	</section>

        <!-- <section>
            <div id="mapwrapper"></div>  
        </section>
 -->
		<!-- FOOTER -->
		<%@ include file="/WEB-INF/views/common/fr/footer.jspf" %>
		<!-- /FOOTER -->
        <div id="bottom-frame"></div>
        <a href="#" id="back-to-top"><i class="fa fa-long-arrow-up"></i></a>
    </div>

    <script src="${contextPath}/resources/Front_Temp/js/jquery.js"></script>
    <script src="${contextPath}/resources/Front_Temp/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/Front_Temp/js/plugins.js"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script src="${contextPath}/resources/Front_Temp/js/init.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
    $(document).ready(function(){
    	$('#search-input').focus();
       'use strict';
        jQuery('#headerwrap').backstretch([
          "${contextPath}/resources/Front_Temp/img/bg/bg1.jpg",
          "${contextPath}/resources/Front_Temp/img/bg/bg2.jpg",
          "${contextPath}/resources/Front_Temp/img/bg/bg3.jpg",
        ], {duration: 8000, fade: 500});

        $('#search-btn').on('click', function(){
        	let searchKeyWord = $('input[name=search-input]').val();
        	location.href = "${contextPath}search?keyWord="+searchKeyWord;
        });
        
        $('input[name=search-input]').keypress(function(e){
        	(e.keyCode ==13)? $('#search-btn').click() : '';
        });

		$('input[name=search-input]').keyup(function(e){
			if($.trim(this.value) == '' || this.value =='/')
				return false;

			let param = {
				keyWord : this.value,
				sqlId : 'getMainKeyWordList'
			};
	    	util.commonRetrieve({
	    		data : param,
	    		callBackFunc : function(e){
	    			if(e.resultCode == 200){
		    			let html = '';
		    			let tagHeight = (e.data.length > 0)? 'auto' : 'auto';

		    			if(e.data.length > 0){
			    			$.each(e.data, function(idx, ele){
					    		html += '<a href="${contextPath}search?keyWord='+ele.store_name+'"><li class="list-group-item text-left heading-font">'+ele.store_name+'</li></a>';
					    	});
			    			$('#keyWordList').css({overflow : 'scroll', height: tagHeight});
		    			}else {
		    				html = '<li class="list-group-item">데이터가 존재하지 않습니다.</li>';
		    				$('#keyWordList').css({height: tagHeight});
		    			}

		    			$('#keyWordList').html(html);
	    			} else{
	    				common.errorMsgAlert();
	    				console.error('errorMsg', e.errorMsg);
	    			}
	    		}

	    	});
		});
		
    });
    </script>
    
    

</body>

</html>
