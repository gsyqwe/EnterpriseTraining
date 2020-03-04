function demo(){
    console.log("你好")
    //延迟执行
    setTimeout(demo,1000)
}
//demo()

var timer = null;
var index = 1
timer = setInterval(demo1,1000)
function demo1(){
    console.log(index+".睛天")
    if(index===10) clearInterval(timer)
    index++
}

var str = 's'
var str1 = 123
var result = str===str1?'ok':'false'
console.log(result)


