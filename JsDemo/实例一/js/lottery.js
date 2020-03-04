var gift = ['IPhoneX','IPad','三星笔记本','50元话费','谢谢参与','1元红包','10元话费']
var show = document.getElementById("show") //显示抽奖
var result = document.getElementById("result") //显示结果
var start = document.getElementById("start") //开始按钮
var stop = document.getElementById("stop")    //结束按钮
var timer = null;
window.onload = function(){
    //给开始按钮添加单击事件
    start.onclick = startGift
    stop.onclick = stopGift

}

function startGift(){
    //清除定时器
    clearTimeout(timer)
    //随机取奖品
    var good = gift[Math.floor(Math.random() * 7)]
    console.log(good)
    //显示奖品
    show.innerHTML = good
    //50毫秒调用一次
    timer = setTimeout(startGift,50)

}

function stopGift(){
    //清除定时器
    clearTimeout(timer)
    result.innerHTML = "恭喜抽中:"+show.innerHTML
}
