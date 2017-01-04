<!DOCTYPE html>
<html lang="en">
<head>
<title>Our Photos</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="css/gallery.css">
<link rel="stylesheet" href="css/photoswipe.css">
<link rel="stylesheet" href="gallery/default-skin/default-skin.css">
<script src="js/photoswipe.js"></script>
<script src="js/photoswipe-ui-default.js"></script>
<script src="js/gallery.js"></script>


</head>
<body>
	<div id="container">
		<h1>Our Gallery</h1>
		<div class="my-gallery" itemscope itemtype="http://schema.org/ImageGallery">
		  $$$
		</div>

		<div class="container">
			<!-- Root element of PhotoSwipe. Must have class pswp. -->
			<div class="pswp" tabindex="-1">
				<!-- Background of PhotoSwipe. 
         It's a separate element as animating opacity is faster than rgba(). -->
				<div class="pswp__bg"></div>

				<!-- Slides wrapper with overflow:hidden. -->
				<div class="pswp__scroll-wrap">

					<!-- Container that holds slides. 
            PhotoSwipe keeps only 3 of them in the DOM to save memory.
            Don't modify these 3 pswp__item elements, data is added later on. -->
					<div class="pswp__container">
						<div class="pswp__item"></div>
						<div class="pswp__item"></div>
						<div class="pswp__item"></div>
					</div>

					<!-- Default (PhotoSwipeUI_Default) interface on top of sliding area. Can be changed. -->
					<div class="pswp__ui pswp__ui--hidden">

						<div class="pswp__top-bar">

							<!--  Controls are self-explanatory. Order can be changed. -->

							<div class="pswp__counter"></div>

							<button class="pswp__button pswp__button--close"
								title="Close (Esc)"></button>

							<button class="pswp__button pswp__button--share" title="Share"></button>

							<button class="pswp__button pswp__button--fs"
								title="Toggle fullscreen"></button>

							<button class="pswp__button pswp__button--zoom"
								title="Zoom in/out"></button>

							<!-- Preloader demo http://codepen.io/dimsemenov/pen/yyBWoR -->
							<!-- element will get class pswp__preloader--active when preloader is running -->
							<div class="pswp__preloader">
								<div class="pswp__preloader__icn">
									<div class="pswp__preloader__cut">
										<div class="pswp__preloader__donut"></div>
									</div>
								</div>
							</div>
						</div>
						<div
							class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
							<div class="pswp__share-tooltip"></div>
						</div>

						<button class="pswp__button pswp__button--arrow--left"
							title="Previous (arrow left)"></button>

						<button class="pswp__button pswp__button--arrow--right"
							title="Next (arrow right)"></button>

						<div class="pswp__caption">
							<div class="pswp__caption__center"></div>
						</div>

					</div>

				</div>

			</div>

		</div>
	</div>
</body>

<script type="text/javascript">
	//execute above function
	initPhotoSwipeFromDOM('.my-gallery');
</script>

</html>