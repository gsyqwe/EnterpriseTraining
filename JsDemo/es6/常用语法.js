//let a = 0
/*for(let i=0;i<10;i++){
    console.log(i)
}*/
//console.log(i)
//常量
//const b = 0
//b = 1

//解构赋值
let arr = [1,2,3]
let [c,d,e] = arr
console.log(c,d,e)

//解构赋值
let {bar,foo} = {bar:'hello',foo:'world'}
console.log(bar,foo)

//模板表达式
let name = 'John'
let str = `This is example,hello ${name}`
console.log(str)

let temp = 1
//箭头函数
let fruit = ['苹果','西瓜','桔子']
fruit.forEach((item,index)=>{
    console.log(index,item)
})

function demo(a=0,b=0){
    let c = a + b
    let result = `${a}+${b}=${c}`
    console.log(result)
}
demo()