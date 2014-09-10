

function createIframe(){ 
//mask遮罩层 
var newMask=document.createElement("div"); 
newMask.id="mDiv"; 
newMask.style.position="absolute"; 
newMask.style.zIndex="1"; 
_scrollWidth=Math.max(document.body.scrollWidth,document.documentElement.scrollWidth); 
_scrollHeight=Math.max(document.body.scrollHeight,document.documentElement.scrollHeight);
// _scrollHeight = Math.max(document.body.offsetHeight,document.documentElement.scrollHeight); 
newMask.style.width=_scrollWidth+"px"; 
newMask.style.height=_scrollHeight+"px"; 
newMask.style.top="0px"; 
newMask.style.left="0px"; 
newMask.style.background="#33393C"; 
//newMask.style.background = "#FFFFFF"; 
newMask.style.filter="alpha(opacity=40)"; 
newMask.style.opacity="0.50"; 
newMask.style.display='none'; 
var objDiv=document.createElement("DIV"); 
objDiv.id="div1"; 
objDiv.name="div1"; 

objDiv.style.width="378.6px"; 
objDiv.style.height="450px"; 
objDiv.style.left="35%";
objDiv.style.top="18%"; 
objDiv.style.position="fixed";




objDiv.style.background="black"; 
 
objDiv.style.zIndex="2"; //加了这个语句让objDiv浮在newMask之上 
objDiv.style.display="none"; //让objDiv预先隐藏 
objDiv.innerHTML='<div>' +
	'				<div style="height:30px;">' +
	'					<div id="titleblank" style="position:relative;height:30px;width:5%;float:left;line-height:30px;background:white;"></div><div id="title" style="position:relative;height:30px;width:45%;float:left;line-height:30px;background:white;">登录到netcool</div> <div id="drag" style="position:relative;float:left;height:30px;width:50%;z-index:10001;top:0; background-color:white;" align="right"> <input type=button style="cursor:pointer;background:blue;border:none;" value="X" onclick="HideIframe(document.getElementById(\'mDiv\'),document.getElementById(\'div1\'));"/> </div></div>' +
	'				<div style="width:12%;height:330px;background:white;float:left;">' +
	'				</div>' +
	'				<div style="width:76%;height:330px;background:white;float:left;">' +
	'					<div style="height:40px;"></div>' +
	'					<div>' +
	'						<div style="width:50%;height:30px;line-height:30px; float:left;"><label style="color:red;">用户名:</label></div><div style="width:50%;float:left;"><label id="userwrong" style="display:none;">用户名出错</label></div></div>' +
	'					<div><input id="userload" type="text" name="user" style="border:solid 1px #282828;height: 30px;width:90%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;padding-left:5%;padding-right:5%;" placeholder="用户名"/>' +
	'						</div>' +
	'					<div style="height:10px;"></div>' +
	'						<div>' +
	'					<div style="width:50%;height:30px;line-height:30px; float:left;"><label style="color:red;">密码:</label></div><div style="width:50%;float:left;"><label id="userwrong" style="display:none;">密码出错</label></div></div>	' +
	'					<div><input id="psdload" type="password" name="psd" style="border:solid 1px #282828;height: 30px;width:90%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;padding-left:5%;padding-right:5%;" placeholder="密码"/>' +
	'						</div>' +
	'					<div style="height:15px;"></div>' +
	'					<div><input type="submit" value="立即登录" onMouseOver="this.style.backgroundColor=\'red\'" onMouseOut="this.style.backgroundColor=\'blue\'" id="loadbtn" style="cursor:pointer;color:white;font-size:14px;font-weight:bold;border:solid 1px #282828;height:35px;width:100%;position: relative;-webkit-border-radius:8px; -moz-border-radius:8px; -khtml-border-radius:8px;border-radius:8px;background:blue;font-color:white;"/>' +
	'						</div>' +
	'					<div style="height:20px;"></div>' +
	'					<div style="height:20px;line-height:20px;"><a>忘记密码?</a></div>' +
	'					<div style="height:30px;line-height:30px;"><label>还没加入我们?</label><a onclick="goToRegister()" style="cursor:pointer;">赶紧注册吧!</a></div>' +
	'					' +
	'				</div>' +
	'				<div style="width:12%;height:330px;background:white;float:left;">' +
	'					</div>' +
	'				<div style="height:90px;width:100%;background:white;float:left;"><img id="loadimg" src="image/image1.jpg" style="height: 100%;width: 100%;"/></div>' +
'				</div>'; 
//更改了X按钮为触发关闭事件。 
objDiv.style.border="solid yellow 10px"; 
// newMask.appendChild(objDiv); //问题出在这里：你把frame所在的div变成了 newMask的子元素，当newMask透明度更改时，当然会影响到frame 
document.body.appendChild(newMask); 
document.body.appendChild(objDiv); 









} 


function loadEditor(){ 

var objDiv=document.getElementById("div1"); 
var mDiv=document.getElementById("mDiv"); 
mDiv.style.display=''; 

document.getElementById("userload").value="";
document.getElementById("psdload").value="";

objDiv.style.display = ""; 

} 

function HideIframe(mDiv,objDiv){ 
mDiv.style.display='none'; 
objDiv.style.display = "none"; 
} 

function goToRegister()
{
	var objDiv=document.getElementById("div1"); 
	var mDiv=document.getElementById("mDiv"); 
	mDiv.style.display='none'; 	
	objDiv.style.display = "none"; 
	
	var objDiv2=document.getElementById("2div1"); 
	var mDiv2=document.getElementById("2mDiv");
	
	mDiv2.style.display = ''; 	
	objDiv2.style.display = ""; 
}

