<%--
  Created by IntelliJ IDEA.
  User: home-pc
  Date: 2017/6/4
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
    <title>Title</title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link rel="stylesheet" href="mainBodyCss/HomePageCss.css">
    <script type="text/javascript"src="js/JavaScript.js"></script>
    <script>

        window.onload = function()
        {
            var oDiv = document.getElementById('playBox');
            var oPre = getByClass(oDiv,'pre')[0];
            var oNext = getByClass(oDiv,'next')[0];
            var oUlBig = getByClass(oDiv,'oUlplay')[0];
            var aBigLi = oUlBig.getElementsByTagName('li');
            var oDivSmall = getByClass(oDiv,'smalltitle')[0]
            var aLiSmall = oDivSmall.getElementsByTagName('li');

            function tab()
            {
                for(var i=0; i<aLiSmall.length; i++)
                {
                    aLiSmall[i].className = '';
                }
                aLiSmall[now].className = 'thistitle'
                startMove(oUlBig,'left',-(now*aBigLi[0].offsetWidth))
            }
            var now = 0;
            for(var i=0; i<aLiSmall.length; i++)
            {
                aLiSmall[i].index = i;
                aLiSmall[i].onclick = function()
                {
                    now = this.index;
                    tab();
                }
            }
            oPre.onclick = function()
            {
                now--
                if(now ==-1)
                {
                    now = aBigLi.length;
                }
                tab();
            }
            oNext.onclick = function()
            {
                now++
                if(now ==aBigLi.length)
                {
                    now = 0;
                }
                tab();
            }
            var timer = setInterval(oNext.onclick,2000)
            oDiv.onmouseover = function()
            {
                clearInterval(timer)
            }
            oDiv.onmouseout = function()
            {
                timer = setInterval(oNext.onclick,2000)
            }

        }
    </script>
</head>
<body>
<div id="bodyContent">
        <div id="playBox">
            <div class="pre"></div>
            <div class="next"></div>
            <div class="smalltitle">
                <ul>
                    <li class="thistitle"></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <ul class="oUlplay">
                <li><a href="#"><img src="commonalityPageImage/slide1.jpg" /></a></li>
                <li><a href="#"><img src="commonalityPageImage/slide2.jpg" /></a></li>
                <li><a href="#"><img src="commonalityPageImage/slide3.jpg"/></a></li>
                <li><a href="#"><img src="commonalityPageImage/slide4.jpg"/></a></li>
            </ul>
        </div>
</div>
</body>
</html>
