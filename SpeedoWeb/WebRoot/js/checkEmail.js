// JavaScript Document

function checkEmail(email){

		var email = "";
		var count = 0;
		var count2 = 0;
		
		for(var i=0;i<email.length;i++) {
			if(email.charAt(i) == '@') {
				count++;
			}else if (email.charAt(i) == '.'){
				count2++;
			}
		}
		
		if(count != 1 || count2 !=1) {
			return false;
		}
		
		//此部分判断条件2,条件3
		var index = email.trim().indexOf('@');
		var index2 = email.trim().indexOf('.');
		if(index == 0 || index2 == email.trim().length-1 || index > index2 || index2-index == 1 ) {
			return false;
		} else{
			return true;
		}
		
	}

　　String.prototype.trim=function(){
　　   return this.replace(/(^\s*)|(\s*$)/g, "");
　 }
		