
			var cartoon = false; //当前是否正在执行动画
			var dt = null; //执行的动画方向
			function slideImage() {
				var obj = document.getElementById("picturecenter");
				var px = obj.style.pixelLeft;
				if(px < - len + imgW) {
					px = 0;
				}
				if(px > 0) {
					px = - len + imgW;
				}
				px -= (dt ? 1 : -1);
				obj.style.left = px+"px";
				if(px % imgW != 0) { 
					setTimeout('slideImage()',5);
				}else{
					cartoon = false;
				}
			}
			function moveImage(direction) {
				if(!cartoon) {
					cartoon = true;
					if(direction == 0) {
						dt = true;
						slideImage();
					}else{
						dt = false;
						slideImage();
					}
				}
			}