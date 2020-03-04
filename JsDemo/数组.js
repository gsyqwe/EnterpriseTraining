//数组定义
var arr = [];
console.log(arr)
var arr1 = new Array()
var arr2 = [1,2,3]
console.log(arr2)
//添加元素
arr.push("苹果");
arr.push("桔子");
arr.push("香蕉");
arr.push("西瓜");
console.log(arr)
//把数组的所有元素放入一个字符串。元素通过指定的分隔符进行分隔
var show = arr.join("/")
console.log(show)
//删除并返回数组的第一个元素
//var first = arr.shift()
//console.log(first)
//console.log(arr)
//从某个已有的数组返回选定的元素,同java中的substring
var arr3 = arr.slice(1,3)
console.log(arr3)
console.log(arr)
//从数组中删除项目，然后返回被删除的项目
arr.splice(1,2)
console.log(arr);

//遍历
for(var i=0;i<arr.length;i++){
    console.log(arr[i])
}

arr.forEach(function(value,index){
    console.log(index,value)
})

//includes() 方法用来判断一个数组是否包含一个指定的值
console.log(arr.includes("西瓜1"))

//往数组中的第一个位置插入元素
arr.unshift("柚子")
console.log(arr)
//把数组的最后一个元素弹出
var last = arr.pop()
console.log(last)
console.log(arr)