
var curIndex=0;
var picNum;
var timeInterval=3000;
var arr=new Array();
arr[0]="imageadv/index-ad1.jpg";
arr[1]="imageadv/index-ad2.jpg";
arr[2]="imageadv/index-ad3.jpg";
arr[3]="imageadv/index-ad4.jpg";
arr[4]="imageadv/index-ad5.jpg";
var iId = setInterval(changeImg,timeInterval);

function changeImg()
{
    var obj=document.getElementById("now");
    if (curIndex==arr.length-1) 
    {
        curIndex=0;
    }
    else
    {
        curIndex+=1;
    }
    obj.src=arr[curIndex];
    var picNum2 = curIndex + 1;
    clearClickImage();
    document.getElementById("picimg"+picNum2).style.opacity="1";
}



function clickChange(picNum)
{
	var obj=document.getElementById("now");
	curIndex = picNum - 1;
	obj.src=arr[picNum-1];
	window.clearInterval(iId);
	iId = setInterval(changeImg,timeInterval);
	var pic = "picimg"+picNum;
	clearClickImage();
	document.getElementById("picimg"+picNum).style.opacity="1";
}

function clearClickImage()
{
	for(var i = 1;i<=5;i++)
		{
			document.getElementById("picimg"+i).style.opacity="0.3";
		}
	
}

function mouseonad(obj)
{
	obj.style.border="#FFCC00 solid 2px";
	obj.style.opacity="1";
}


function mouseoutad(obj)
{
	obj.style.border="none";
	obj.style.opacity="0.3"
}
