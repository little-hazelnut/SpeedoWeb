
			var cartoon = false; //��ǰ�Ƿ�����ִ�ж���
			var dt = null; //ִ�еĶ�������
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