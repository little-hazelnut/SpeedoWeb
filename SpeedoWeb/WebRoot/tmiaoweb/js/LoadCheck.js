

function chkForm()
{
	document.getElementById("fault").innerHTML="";
	if(!nullOrNot())
		{
			
		}
	else if(!nameCheck())
		{
		
		}
	else if(!psdCheck())
		{
		
		}
	
	else if(!mailAvailable())
	{
		
	}
	else if(!idcodeCheck())
	{
		
	}
	//else document.forms["formreg"].submit();
	
}

function nullOrNot()
{
	
	if(document.getElementById("nicknamereg").value=="")
		{
			document.getElementById("fault").innerHTML='�û���Ϊ��,���������룡';
			document.getElementById("nicknamereg").focus();
			document.getElementById("idimage").src="jsp/ImageGen.jsp";
			return false;
		}
	else if(document.getElementById("psdreg").value=="")
		{	
			document.getElementById("fault").innerHTML='����Ϊ��,���������룡';
			document.getElementById("psdreg").focus();
			document.getElementById("idimage").src="jsp/ImageGen.jsp";
			return false;
		}
	else if(document.getElementById("psdreg2").value=="")
		{
			document.getElementById("fault").innerHTML='�ٴ���������Ϊ��,���������룡';
			document.getElementById("psdreg2").focus();
			document.getElementById("idimage").src="jsp/ImageGen.jsp";
			return false;
		}
	else if(document.getElementById("mailbox").value=="")
		{	
			document.getElementById("fault").innerHTML='����Ϊ��,���������룡';
			document.getElementById("mailbox").focus();
			document.getElementById("idimage").src="jsp/ImageGen.jsp";
			return false;
		}
	else if(document.getElementById("idcodetxt").value=="")
		{	
			document.getElementById("fault").innerHTML='��֤��Ϊ��,���������룡';
			document.getElementById("idcodetxt").focus();
			document.getElementById("idimage").src="jsp/ImageGen.jsp";
			return false;
		}
	else 
		{
			
			alert("bbbbbbbbb");
			return true;
		}
}
function nameCheck()
{
	var name = document.getElementById("nicknamereg").value;
	if(name.toString().length>12||name.toString().length<6)
	{
		document.getElementById("nicknamereg").focus();
		document.getElementById("fault").innerHTML="�ǳƵĳ��Ȳ�����Ҫ��!";
		return false;
	}
	return true;
}
function psdCheck()
{
	var psd = document.getElementById("psdreg").value;
	var psd2 = document.getElementById("psdreg2").value;
	if(psd.toString().length<6||psd.toString().length>12)
		{
			document.getElementById("fault").innerHTML="����̫�̻���̫��!";
			return false;
		}
	if(psd!=psd2)
		{
			document.getElementById("fault").innerHTML="������������벻һ��!";
			return false;
		}
	else return true;
}


function mailAvailable()
{
	return true;
}

function idcodeCheck()
{
	var trueidcode='${sessionScope.rand}';
	alert(trueidcode);
	return true;
}


function CheckBoxItem()
{
	if(document.getElementById("protocol").checked==true)
		{		
			document.getElementById("protocol").checked=false;
			document.getElementById("regbtn").disabled=true;
			document.getElementById("regbtn").style.backgroundColor='#d4d4d4';
		}
	else 
		{
			document.getElementById("protocol").checked=true;
			document.getElementById("regbtn").disabled=false;
			document.getElementById("regbtn").style.backgroundColor='blue';
		}
}

function checkboxfunc(){
		
		if(document.getElementById("protocol").checked==true)
		{
			
			document.getElementById("regbtn").disabled=false;
			document.getElementById("regbtn").style.backgroundColor='blue';
		}
		else 
		{
			document.getElementById("regbtn").disabled=true;
			document.getElementById("regbtn").style.backgroundColor='#d4d4d4';
			
		}
}

