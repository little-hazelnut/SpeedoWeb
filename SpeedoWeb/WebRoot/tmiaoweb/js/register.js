

function createIframe2(){ 
//mask���ֲ� 
var newMask2=document.createElement("div"); 
newMask2.id="2mDiv"; 
newMask2.style.position="absolute"; 
newMask2.style.zIndex="1"; 
_scrollWidth2=Math.max(document.body.scrollWidth,document.documentElement.scrollWidth); 
_scrollHeight2=Math.max(document.body.scrollHeight,document.documentElement.scrollHeight);
// _scrollHeight = Math.max(document.body.offsetHeight,document.documentElement.scrollHeight); 
newMask2.style.width=_scrollWidth2+"px"; 
newMask2.style.height=_scrollHeight2+"px"; 
newMask2.style.top="0px"; 
newMask2.style.left="0px"; 
newMask2.style.background="#33393C"; 
//newMask.style.background = "#FFFFFF"; 
newMask2.style.filter="alpha(opacity=40)"; 
newMask2.style.opacity="0.50"; 
newMask2.style.display='none'; 
var objDiv2=document.createElement("div"); 
objDiv2.id="2div1"; 
objDiv2.name="2div1"; 

objDiv2.style.width="757px"; 
objDiv2.style.height="450px"; 
objDiv2.style.left="20%";
objDiv2.style.top="18%"; 
objDiv2.style.position="fixed";




objDiv2.style.background="black"; 
 
objDiv2.style.zIndex="2"; //������������objDiv����newMask֮�� 
objDiv2.style.display="none"; //��objDivԤ������ 
objDiv2.innerHTML='<div><div id="titleblank2" style="position:relative;height:30px;width:5%;float:left;line-height:30px;background:white;"></div><div id="title2" style="position:relative;height:30px;width:45%;float:left;line-height:30px;background:white;">�Ͻ��������ǰ�!</div> <div id="drag2" style="position:relative;float:left;height:30px;width:50%;z-index:10001;top:0; background-color:white;" align="right"> <input type=button style="cursor:pointer;background:blue;border:none;" value="X" onclick="HideIframe(document.getElementById(\'2mDiv\'),document.getElementById(\'2div1\'));"/> </div></div>' +			
'						<form onSubmit="jsp/Test.jsp" name="formreg"  method="post" action="jsp/LoadDeal.jsp">' +
'						<div id="leftblankreg" style="width:6%;height:360px;float:left;background:white;">' +
'							</div>' +
'						<div id="leftreg" style="width:41%;height:360px;float:left;background:white;">' +
	'							<div style="height:30px;"></div>' +
	'							<div style="height:30px;line-height:30px"><label>�ǳ�:</label></div>' +
'								<div><input type="text" onclick="ClearFault()" id="nicknamereg" name="userreg" style="border:solid 1px #282828;height: 30px;width:90%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;padding-left:5%;padding-right:5%;" placeholder="�ǳ�ֻ����6��12�����֡��»��ߡ���ĸ���"/>' +
	'								</div>' +
	'							<div style="height:20px;"></div>' +
	'							<div style="height:30px;line-height:30px"><label>����:</label></div>' +
'								<div><input type="password" onclick="ClearFault()" id="psdreg" name="psdreg" style="border:solid 1px #282828;height: 30px;width:90%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;padding-left:5%;padding-right:5%;" placeholder="����ֻ����6��12�����֡���ĸ���O(��_��)O~"/>' +
	'								</div>' +
	'							<div style="height:20px;"></div>' +
	'							<div style="height:30px;line-height:30px"><label>�ٴ���������:</label></div>' +
'								<div><input type="password" onclick="ClearFault()" id="psdreg2"  name="psdreg2" style="border:solid 1px #282828;height: 30px;width:90%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;padding-left:5%;padding-right:5%;" placeholder="�ٴ�ȷ����������I(^��^)�J"/>' +
	'								</div>' +
	'							<div style="height:20px;"></div>' +
	'							<div style="height:30px;line-height:30px"><label>����:</label></div>' +
'								<div><input type="text" onclick="ClearFault()" id="mailbox" name="mailreg" style="border:solid 1px #282828;height: 30px;width:90%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;padding-left:5%;padding-right:5%;" placeholder="��������������Ŷ+_+"/>' +
	'								</div>' +
'							</div>' +
'						<div id="centerblankreg" style="width:6%;height:360px;float:left;background:white;">' +
'							c</div>' +
'						<div id="rightreg" style="width:41%;height:360px;float:left;background:white;">' +
'							<div style="height:30px;"></div>' +
	'						<div style="height:30px;line-height:30px"><label>��֤��:</label></div>' +
				'			<div style="height:118px;">	' +
				'				<div style="position:relative;height:118px;width:10%;float:left;"></div>' +
				'				<div style="position:relative;height:118px;width:80%;float:left;">' +
				'					<div style="height:98px;"><img style="width:100%;height:100%;" src="jsp/ImageGen.jsp" id="idimage" alt="�����壿�������" onclick="this.src=this.src+\'?\'" /></div>' +
				'					<div style="height:20px;line-height:20px;"><a  href="javascript:ImageRepaint()">�����壿�������</a></div>' +
				'				</div>' +
				'				<div style="position:relative;height:118px;width:10%;float:left;"></div>' +
'							</div>' +
'							<div style="height:20px;"></div>' +
'							<div style="height:30px;line-height:30px"><label>��������֤��:</label></div>' +
'							<div><input type="text" onclick="ClearFault()" id="idcodetxt" name=idcodetxt style="border:solid 1px #282828;height: 30px;width:90%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;padding-left:5%;padding-right:5%;" placeholder="һ��Ҫ�������֤��~(@^_^@)~"/>' +
	'								</div>' +
	'						<div style="height:20px;"></div>' +
	'						<div style="height:30px;line-height:30px;">	' +
				'				<div style="position:relative;height:30px;width:10%;float:left;"></div>' +
				'				<div style="position:relative;height:30px;width:80%;float:left;">' +
				'					<input id="protocol" onclick="checkboxfunc();" type="checkbox" name="checkbox" value="checkbox" /><a href="javascript:CheckBoxItem()">�����Ķ���ͬ����ط�������!</a>' +
				'				</div>' +
				'				<div style="position:relative;height:30px;width:10%;float:left;"></div>' +
'							</div>' +
'							<div>' +
'									<input id="regbtn" type="button" onclick="chkForm()" value="����ע��" onMouseOver="this.style.backgroundColor=\'red\'" onMouseOut="this.style.backgroundColor=\'blue\'" id="loadbtn" style="cursor:pointer;color:white;font-size:14px;font-weight:bold;border:solid 1px #282828;height:35px;width:100%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;background:blue;font-color:white;"/>' +
	'								' +
	'						</div>' +
'						</div>' +
'							' +
'						<div id="rightblankreg" style="width:6%;height:360px;float:left;background:white;">' +
'							e</div>' +
'						<div style="width:100%;height:30px;float:left;background:white;line-height:30px;color:red;font-size:22px;" align="center";><label id="fault"></label></div>' +
'						<div style="width:100%;height:30px;float:left;background:white;"></div>' +
'						</form>' +
'					</div>'; 
//������X��ťΪ�����ر��¼��� 
objDiv2.style.border="solid yellow 10px"; 
// newMask.appendChild(objDiv); //�������������frame���ڵ�div����� newMask����Ԫ�أ���newMask͸���ȸ���ʱ����Ȼ��Ӱ�쵽frame 
document.body.appendChild(newMask2); 
document.body.appendChild(objDiv2); 









} 


function registerEditor(){ 


	
var objDiv2=document.getElementById("2div1"); 
var mDiv2=document.getElementById("2mDiv"); 

mDiv2.style.display=''; 
document.getElementById("nicknamereg").value="";
document.getElementById("protocol").checked=false;
document.getElementById("regbtn").disabled=true;
document.getElementById("regbtn").style.backgroundColor='#d4d4d4';
document.getElementById("psdreg").value="";
document.getElementById("psdreg2").value="";
document.getElementById("mailbox").value="";
document.getElementById("idimage").src="jsp/ImageGen.jsp";
objDiv2.style.display = ""; 
} 

function HideIframe2(mDiv,objDiv){ 

mDiv2.style.display='none'; 
objDiv2.style.display = "none"; 
} 

function ImageRepaint()
{
	document.getElementById("idimage").src="jsp/ImageGen.jsp";
}



function ClearFault()
{
	document.getElementById("fault").innerHTML="";
}
