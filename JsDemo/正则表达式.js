//.任意字符
var patten = /g..gle/
var str = 'go1gle'
console.log(patten.test(str))

//*匹配0个或任意多个
patten = /g.*gle/
str = 'gogle'
console.log(patten.test(str))

patten = /g[a-zA-Z]*gle/
str = 'gocccgle'
console.log(patten.test(str))

patten = /g[^0-9]*gle/
str = 'go0ccgle'
console.log(patten.test(str))

//+匹配1个或任意多个
patten = /[a-z][A-Z]+/
str = 'gGGGG0ccgle'
console.log(patten.test(str))
//^:以开头
//$:以结尾
//{m,n}出现m-n次
patten = /^\D{1,3}\d+/
str = 'aaa8'
console.log(patten.test(str))

pattern = /[1-9][0-9]{5}/
str = '210000'
console.log(pattern.test(str))

//i忽略大小写
//g全局匹配
pattern = /\w+\.zip|rar|gz/i
str = 'a12.ZIP'
console.log(pattern.test(str))

pattern = /\s/g
str = '111   222   333'
str = str.replace(pattern,'')
console.log(str)

pattern = /^\s+/
str  = '     goo    gle     '
str = str.replace(pattern,'')
console.log(str)