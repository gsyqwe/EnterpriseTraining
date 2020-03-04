//从convert.js中导入需要的变量或方法
//import {PAGE_SIZE,SYS_NAME,demo} from 'convert'
//console.log(PAGE_SIZE,SYS_NAME)

class Student {
    constructor(name,age){
        this.name = name
        this.age = age
    }

    show(){
        return this.name + ',' + this.age
    }
}

let st = new Student('张三',22)
let result = st.show()
console.log(result)