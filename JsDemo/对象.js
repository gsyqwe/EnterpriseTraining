var box = {
   name: '张三',
   age: 22,
   demo: function(){
       return this.name + "," + this.age
   },
   demo1(){
       return this.name + ":" + this.age
   }
}

console.log(typeof(box))
console.log(box.name)
console.log(box.demo1())


var date = new Date();
var year = date.getFullYear();
var month = date.getMonth() + 1;
var day = date.getDate();
var hour = date.getHours();
var min = date.getMinutes().toString();
var sec = date.getSeconds().toString();
min = min.length<2?'0'+min:min
sec = sec.length<2?'0'+sec:sec
var time = year + '-' + month + '-' + day + ' ' + hour + ':' + min + ':' + sec;
console.log(time)


var a = 3.4
var b = Math.ceil(a)
console.log(b)

b = Math.floor(a)
console.log(b)

for(var i=0;i<100;i++){
    var ran = Math.ceil(Math.random() * 10)
    console.log(ran)
}

var s = '12'
var s1 = '11.1'
var s2 = parseInt(s) + parseFloat(s1)
console.log(s2)


var s3 = "abc"
console.log(isNaN(s3))
console.log(isNaN(s2))